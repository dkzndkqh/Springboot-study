//package org.example.springdeveloper.config;
//
//import lombok.RequiredArgsConstructor;
//import org.example.springdeveloper.service.UserDetailService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.ProviderManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
//
//
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class WebSecurityConfig {
//
//
//    private final UserDetailsService userService;
//
//
//    @Bean // 스프링 시큐리티 기능 비활성화 모든 기능을 사용하지 않기 위함 인증, 인가 서비스를 모든곳에 적용하지 않음
//    //정적 리소스만 설정하는데 static 하위경로에 있는 리소스, h2의 데이터를 확인하는 h2-console 하위 url을 대상으로 ignoring함
//    public WebSecurityCustomizer configure() {
//        return (web) -> web.ignoring().requestMatchers(toH2Console()).requestMatchers(new AntPathRequestMatcher("/static/**"));
//    }
//
//    //requestMatchers 는 특정 요청과 일치하는 url에 대한 액세스를 설정
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception // 특정 Http 요청에 대한 웹 기반 보안 구성
//     {
//        return http.authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/login"), //인증, 인가 설정
//                                                                       new AntPathRequestMatcher("/signup"),
//                                                                       new AntPathRequestMatcher("/user")
//        ).permitAll().anyRequest().authenticated()).formLogin(formLogin -> formLogin.loginPage("/login").defaultSuccessUrl("/articles")).logout(logout -> logout
//                .logoutSuccessUrl("/login").invalidateHttpSession(true)).csrf(AbstractHttpConfigurer::disable).build();
//    } // permitAll()은 누구나 접근이 가능하게함
//      // anyReuqest()는 위에서 설정한 url 이외의 요청에 대해서 설정함
//      // authenticated()는 인증이 성공된 상태여야 접근가능함.
//      //loginPage 로그인 페이지 경로를 설정, defaultSuccessUrl(로그인 성공시) /articles 요청 logoutSuccessUrl (로그아웃 성공시) /login 요청
//      // invalidateHttpSession 로그아웃 이후에 세션을 전체 삭제할지 여부 결정
//      // csrf csrf공격에 대한 보안기능 활성화 여부
//
//    //인증 관리자 설정
//    //
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailService userDetailService) throws Exception {
//
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userService); //사용자 정보 서비스 설정
//        authProvider.setPasswordEncoder(bCryptPasswordEncoder);
//        return new ProviderManager(authProvider);
//
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
//
//
