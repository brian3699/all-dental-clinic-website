package kr.alldent.alldentalclinicwebsite.config.auth;

import kr.alldent.alldentalclinicwebsite.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
         .csrf().disable()
         .headers().frameOptions().disable()
         .and()
         .authorizeRequests()
         .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile", "/review-new", "/review/new").permitAll()
         .antMatchers("/static/**", "/js/**", "/js/app/**", "/review/**", "/js/**", "/static/**","/js/index.js", "/static/js/app/**", "/review/new", "/review/new/**").permitAll()
         .antMatchers("/resources/**", "/js/**", "/static/**","/js/index.js", "/static/js/app/**").permitAll()
         .antMatchers("/reservation/**", "/api/reservation/**","/reservation-update/**").permitAll()
         .antMatchers("/login", "/review/write", "/css/all/**", "/css/animate/**","/css/aos/**").permitAll()
         .antMatchers("/review/write").permitAll()
         .antMatchers("/api/**").permitAll()
         .antMatchers("/api/v1/**").hasRole(Role.USER.name())
         .anyRequest().authenticated()
         .and()
                .oauth2Login()
                .defaultSuccessUrl("/reservation", true)
                .and()
         .logout()
         .logoutSuccessUrl("/")
         .and()
         .oauth2Login().loginPage("/login")
         .userInfoEndpoint()
         .userService(customOAuth2UserService);

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");

        corsConfiguration.addAllowedOrigin("http://localhost:8080/assets");
        corsConfiguration.addAllowedOrigin("http://localhost:8080/review/new");
        corsConfiguration.addAllowedOrigin("http://localhost:8080/reservation-update/**");
        corsConfiguration.addAllowedOrigin("http://localhost:8080/reservation-update/**");

        corsConfiguration.addAllowedOrigin("/review/**");
        corsConfiguration.addAllowedOrigin("/review/write");



        source.registerCorsConfiguration("/**", corsConfiguration);
        source.registerCorsConfiguration("/review/**", corsConfiguration);
        source.registerCorsConfiguration("/review/new", corsConfiguration);
        source.registerCorsConfiguration("/reservation/**", corsConfiguration);
        source.registerCorsConfiguration("/api/reservation/**", corsConfiguration);
        source.registerCorsConfiguration("/reservation-update/**", corsConfiguration);


        return source;
    }
}
