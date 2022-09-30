package com.sample.common.jwt.controller;

import com.google.gson.Gson;
import com.sample.common.jwt.dto.TokenResponseDto;
import com.sample.common.jwt.service.AuthService;
import com.sample.domain.member.dto.MemberRequestDto;
import com.sample.domain.member.dto.MemberResponseDto;
import com.sample.domain.member.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    private MockMvc mockMvc;

    @Mock
    private AuthService authService;

    private String LOGINID = "member_test_login_id";
    private String PASSWORD = "member_test_password";
    private String NAME = "member_test_name";
    private String EMAIL = "member_test_email";

    private Member createMember() {
        Member member = Member.builder().loginId(LOGINID).password(PASSWORD).name(NAME)
                .email(EMAIL).build();
        ReflectionTestUtils.setField(member, "id", 1L);

        return member;
    }

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @Test
    @DisplayName("회원가입")
    public void 회원가입() throws Exception {
        // given
        Member member = createMember();
        MemberRequestDto memberRequestDto = new MemberRequestDto(LOGINID, PASSWORD, NAME, EMAIL);
        MemberResponseDto memberResponseDto = new MemberResponseDto(member);
        when(authService.signup(any(MemberRequestDto.class))).thenReturn(memberResponseDto);

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/auth/signup")
                        .content(new Gson().toJson(memberRequestDto))
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // then
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("id", memberResponseDto.getId()).exists())
                .andExpect(jsonPath("loginId", memberResponseDto.getLoginId()).exists());
    }

    @Test
    @DisplayName("로그인")
    public void 로그인() throws Exception{
        TokenResponseDto tokenResponseDto = TokenResponseDto.builder()
                .accessToken("").refreshToken("").build();
        MemberRequestDto memberRequestDto = new MemberRequestDto(LOGINID, PASSWORD, NAME, EMAIL);
        when(authService.login(any())).thenReturn(tokenResponseDto);

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/auth/login")
                        .content(new Gson().toJson(memberRequestDto))
                        .contentType(MediaType.APPLICATION_JSON)
        );
    }
}
