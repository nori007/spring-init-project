package com.sample.common.jwt;

import com.sample.common.jwt.dto.TokenResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JwtUtilTest {

    private final String TEST_LOGINID = "123123123";
    private final String TEST_PASSWORD = "1234";
    private final String TEST_NAME = "testName";
    private final String TEST_EMAIL = "test@email.com";

    @Test
    @DisplayName("토큰 생성")
    public void 토큰_생성(){

        TokenResponseDto tokenResponseDto = JwtUtil.create(this.TEST_LOGINID, this.TEST_NAME);

        Assertions.assertThat(tokenResponseDto.getAccessToken());
        Assertions.assertThat(tokenResponseDto.getRefreshToken());
    }

    @Test
    @DisplayName("토큰 검증")
    public void 토큰_검증() {
        // given
        TokenResponseDto tokenResponseDto = JwtUtil.create(this.TEST_LOGINID, this.TEST_NAME);

        // when
        boolean token = JwtUtil.validateToken(tokenResponseDto.getAccessToken());
        boolean refreshToken = JwtUtil.validateToken(tokenResponseDto.getRefreshToken());

        // then
        Assertions.assertThat(token);
        Assertions.assertThat(refreshToken);
    }

    @Test
    @DisplayName("토큰 생성 요청 아이디")
    public void 토큰_생성_요청_아이디() {
        // given
        TokenResponseDto tokenResponseDto = JwtUtil.create(this.TEST_LOGINID, this.TEST_NAME);

        // when
        String loginName = JwtUtil.getUserId(tokenResponseDto.getAccessToken());

        // then
        Assertions.assertThat(this.TEST_LOGINID.equals(loginName));
    }
}
