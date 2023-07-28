package com.green.smart_grade.security.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


//spring security 5.7.0부터 WebSecurityConfigurerAdapter deprecated 됨
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtTokenProvider jwtTokenProvider;

    //webSecurityCustomizer를 제외한 모든 것, 시큐리티를 거친다. 보안과 연관
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(authz ->
                            authz.requestMatchers(
                                    "/sign-api/sign-in"
                                    ,"/swagger.html"
                                    , "/swagger-ui/**"
                                    , "/v3/api-docs/**"
                                    , "/"
                                    , "/index.html"
                                    ,"/static/**"
                            ).permitAll() // 권한 상관없이 전부 사용이 가능하다.
                            .requestMatchers(HttpMethod.GET, "/sign-api/refresh-token").permitAll()
                            .requestMatchers(HttpMethod.GET, "/product/**").permitAll()
                            .requestMatchers("**exception**").permitAll()
                            .requestMatchers("/todo-api").hasAnyRole("USER", "ADMIN") // 권한있는 사람만 필터링 한거다
                            .requestMatchers("/todo-api").hasAnyRole("USER", "ADMIN") // 권한있는 사람만 필터링 한거다
                            .anyRequest().hasRole("ADMIN") // anyRequest 는 거의 마지막에 작성 되어야함
                ) //사용 권한 체크
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //세션 사용 X
        .httpBasic(http -> http.disable()) //UI 있는 시큐리티 설정을 비활성화
                .csrf(csrf -> csrf.disable()) //CSRF 보안이 필요 X, 쿠키와 세션을 이용해서 인증을 하고 있기 때문에 발생하는 일, https://kchanguk.tistory.com/197
                .exceptionHandling(except -> {
                    except.accessDeniedHandler(new CustomAccessDeniedHandler()); // 인가부분(권한)
                    except.authenticationEntryPoint(new CustomAuthenticationEntryPoint()); // 인증 부분 로그인이 반려됐을때 어떻게 할 것인가
                })
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    //시큐리티를 거치지 않는다. 보안과 전혀 상관없는 페이지 및 리소스

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        //함수형 인터페이스 람다
//        WebSecurityCustomizer lamda = (web) -> web.ignoring()
//                    .requestMatchers(HttpMethod.GET, "/sign-api/refresh-token");
//        return lamda;
//    }
}
