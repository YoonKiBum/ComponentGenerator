package com.example.compgeneratorbe.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrfConfig) ->
                        csrfConfig.disable()
                )
                .headers((headerConfig) ->
                        headerConfig.frameOptions(frameOptionsConfig ->
                                frameOptionsConfig.disable()))//h2-console 화면을 사용하기 위해 해당 옵션들을 disable 합니다.
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers("/", "/test").permitAll()
                                .anyRequest().authenticated()
                            //권한 관리 대상을 지정하는 옵션입니다. URL, HTTP 메소드 별로 관리가 가능합니다.
                            //"/"등 지정된 URL들은 permitAll() 옵션을 통해 전체 열람 권한을 주었고,
                            //"/api/v1/**" 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 했습니다.
                )
                .formLogin((formLogin) ->
                            formLogin
                                    .defaultSuccessUrl("/", true)
                        )
                .logout((logoutConfig) ->
                        logoutConfig.logoutSuccessUrl("/")
                )
                .userDetailsService()
//
//                .and()
//                .logout()
//                .logoutSuccessUrl("/") //로그아웃 기능에 대한 여러 설정의 진입점입니다. 성공시 / 주소로 이동합니다.
//                .and()
//                .oauth2Login()//OAuth2 로그인 기능에 대한 여러 설정의 진입점입니다.
//                .userInfoEndpoint()//OAuth2 로그인 성공 이후 사용자 정보를 가져올 떄의 설정들을 담당합니다.
//                .userService(customOAuth2UserService); //소셜 로그인 성공시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록합니다.
//        //리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있습니다.
    }
}
