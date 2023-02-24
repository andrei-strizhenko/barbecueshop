package com.diplomproject.barbecueshop.config;

import com.diplomproject.barbecueshop.services.userDetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(CustomUserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //  Конфигурация прав доступа пользоватлея
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                //Страницы доступные всем
                .antMatchers("/login", "/users/registration", "/users/remember-password", "/users/change-password/**", "swagger-ui.html", "/error-with-message/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/resources/**")
                .permitAll()
                .antMatchers(
                        "/product/add-product",
                        "/authors/update/*",
                        "/authors/add-book/*",
                        "/authors/delete/*")
                .not().hasRole("USER") //  недоступны пользователю
                .antMatchers(
                        "/books/add",
                        "/books/update/*",
                        "/books/delete/*") //  недоступны пользователю
                .not().hasRole("USER")
                .antMatchers("/authors/**").authenticated() // /authors/ доступен всем указанным ролям
                .antMatchers("/books/**").authenticated() // /books/ доступен всем указанным ролям
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/login")
                //Перенарпавление на главную страницу после успешного входа
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                //перенаправление после выходаы
                .logoutSuccessUrl("/login");
        return http.build();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
}
