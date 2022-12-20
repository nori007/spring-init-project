package com.sample.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.common.exception.BadRequestException;
import com.sample.common.jwt.excption.TokenExpiredException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) {

        try {
            filterChain.doFilter(request, response);
        } catch (TokenExpiredException e) {
            setErrorResponse(response, e);
        } catch (BadRequestException e){
            //토큰의 유효기간 만료
            setErrorResponse(response, e);
        } catch (IllegalArgumentException e){
            //유효하지 않은 토큰
            setErrorResponse(response, e);
        } catch (Exception e) {

        }
    }
    private void setErrorResponse(HttpServletResponse response, Exception error){
        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try {
            response.getWriter().write(objectMapper.writeValueAsString(error.toString()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
