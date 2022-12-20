package com.sample.common.jwt;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;
import com.sample.common.exception.BadRequestException;
import com.sample.common.exception.NotFoundException;
import com.sample.common.jwt.dto.TokenResponseDto;
import com.sample.common.jwt.excption.TokenExpiredException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUtil {

    private static final String JWT_SECRET = "djfakskrlekfudiEhaucqkadmfejwltpdnjdisjfqhroehlfRksjfqhroehlfRkaksskrpehlfRkaksskrpehlfRkdkdkdk";
    private static final String BEARER_TYPE = "bearer";
    private static final String ISS = "DAOU";
    private static final String SUB = "{project_name}";

    private static final long JWT_ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 1; // 30분
    private static final long JWT_REFRESH_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 7;   // 7일

    public static Authentication getAuthentication(String accessToken) {
        UserDetails principal = new User(getUserId(accessToken), "", new ArrayList<>());
        return new UsernamePasswordAuthenticationToken(principal, "", principal.getAuthorities());
    }

    private static Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(JWT_SECRET.getBytes())).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    public static String getUserId(String token) {
        Claims claims = parseClaims(token);
        return claims.get("loginId", String.class);
    }

    public static boolean validateToken(String token){
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(JWT_SECRET.getBytes()))
                    .build()
                    .parseClaimsJws(token);
            return true;
        }  catch (SignatureException ex) {
            log.error("Invalid JWT signature");
            throw new BadRequestException("SignatureException");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
            throw new BadRequestException("MalformedJwtException");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
            throw new TokenExpiredException(token);
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
            throw new BadRequestException("Unsupported");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
            throw new BadRequestException("IllegalArgumentException");
        }
    }

    public static TokenResponseDto create(String loginId, String name) {
        Date now = new Date(System.currentTimeMillis());

        String accessToken = Jwts.builder()
                .setIssuer(ISS)
                .setSubject(SUB)
                .setAudience(name)
                .claim("loginId", loginId)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + JWT_ACCESS_TOKEN_EXPIRATION))
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET.getBytes()), SignatureAlgorithm.HS512)
                .compact();

        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now.getTime() + JWT_REFRESH_TOKEN_EXPIRATION))
                .signWith(Keys.hmacShaKeyFor(JWT_SECRET.getBytes()), SignatureAlgorithm.HS512)
                .compact();

        return TokenResponseDto.builder()
                .grantType(BEARER_TYPE)
                .accessToken(accessToken)
                .accessTokenExpiresIn(new Date(now.getTime() + JWT_ACCESS_TOKEN_EXPIRATION).getTime())
                .refreshToken(refreshToken)
                .build();
    }
}
