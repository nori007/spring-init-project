package com.sample.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;
import com.sample.common.exception.BadRequestException;
import com.sample.common.jwt.JwtUtil;
import com.sample.common.jwt.excption.TokenExpiredException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String jwt = getJwtFromRequest(request);

        try {
            if (StringUtils.isNotEmpty(jwt) && JwtUtil.validateToken(jwt)) {
                Authentication authentication = JwtUtil.getAuthentication(jwt);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(request, response);
        } catch (TokenExpiredException e) {
            setErrorResponse(response, e);
        } catch (BadRequestException e){
            setErrorResponse(response, e);
        }
    }

    private void setErrorResponse(HttpServletResponse response, BaseException error) throws IOException {
        String errorCode = error.getError().getCode();
        String errorMessage = error.getMessage().equals("") ? error.getError().getMessage() : error.getMessage();

        response.setStatus(error.getError().getStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(
                "{ \"errorCode\": \"" + errorCode
                        + "\", \"errorMessage\": \"" + errorMessage + "\" }");
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.isNotEmpty(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }

        return null;
    }
}
