package com.diplomproject.barbecueshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true) // Включает разделение по ролям
public class JwtSecurityConfig
        implements WebMvcConfigurer {

    private final JwtTokenFilter jwtTokenFilter;


    public JwtSecurityConfig(JwtTokenFilter jwtTokenFilter) {
        this.jwtTokenFilter = jwtTokenFilter;
    }

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/swagger-ui.html/**",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/css/**", "/img/**", "/js/**", "/encode/*", "/login",
            // other public endpoints of your API may be appended to this array
            "/rest/user/auth"

    };

    private static final String[] USER_ACCESS = {

            "/rest/user",
            "product/{id}",
            "product/list"
//            "product/search",
//            "/rest/product/get-one",
//            "/rest/order",
//            "/rest/order/add-product-in-order",
//            "/rest/product/search"
    };

    private static final String[] MANAGER_ACCESS = {

            "/rest/product/**",
            "/rest/order/**"

    };
    private static final String[] ADMIN_ACCESS = {
            "/rest/**"
    };

    @Bean
    public SecurityFilterChain filterChainJwt(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                //включаем базовую авторизацию
                .httpBasic().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //Доступ для всех пользователей
                .antMatchers(AUTH_WHITELIST).permitAll()//.hasRole("ROLE_ADMIN")
                .and()
                .exceptionHandling()
                //.accessDeniedPage()
                .authenticationEntryPoint((request, response, ex) ->
                        response.sendError(
                                HttpServletResponse.SC_UNAUTHORIZED,
                                ex.getMessage()
                        ))
                .and().authorizeRequests()
                .antMatchers("/rest/user/deleted/*", "/rest/user/list", "/rest/user/get-one/*",
                        "/product/create", "/product/update/*", "/product/delete/*", "/rest/order/list", "/rest/order/deleted/*","/rest/order/list","/rest/provider/*",
                        "/role/list","/rest/delivery-order/update/*", "/rest/delivery-order/delete/*",
                        "/rest/delivery-order/get-one/*", "/rest/delivery-order/list",
                        "/rest/provider/update/*", "/rest/provider/create", "/rest/provider/delete/*","/rest/provider/list", "/rest/provider/update/*","/rest/provider/get-one/*").hasAnyRole("ADMIN","MANAGER")
                .antMatchers("/product/list", "/product/get-one/*","/product/search","/rest/order/create","/rest/order/get-one/*",
                        "/rest/order/create-new-order", "/rest/order/update/*").hasAnyRole( "USER")

                .and()
                //JWT Token VALID or NOT
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}

//Spring Boot 3
//import org.springframework.context.annotation.Bean;
//    import org.springframework.context.annotation.Configuration;
//    import org.springframework.security.authentication.AuthenticationManager;
//    import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//    import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//    import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//    import org.springframework.security.config.http.SessionCreationPolicy;
//    import org.springframework.security.web.SecurityFilterChain;
//    import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//    import ru.sbercources.library.service.userDetails.CustomUserDetailsService;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class JwtSecurityConfig {
//
//  private final JwtTokenFilter jwtTokenFilter;
//  private final CustomUserDetailsService customUserDetailsService;
//
//  public JwtSecurityConfig(JwtTokenFilter jwtTokenFilter,
//      CustomUserDetailsService customUserDetailsService) {
//    this.jwtTokenFilter = jwtTokenFilter;
//    this.customUserDetailsService = customUserDetailsService;
//  }
//
//  private static final String[] AUTH_WHITELIST = {
//      // -- Swagger UI v2
//      "/v2/api-docs",
//      "/swagger-resources",
//      "/swagger-resources/**",
//      "/configuration/ui",
//      "/configuration/security",
//      "/swagger-ui.html",
//      "/swagger-ui.html/**",
//      "/swagger-ui/index.html",
//      "/webjars/**",
//      // -- Swagger UI v3 (OpenAPI)
//      "/v3/api-docs/**",
//      "/swagger-ui/**",
//      "/css/**", "/img/**", "/js/**", "/encode/*"
//      // other public endpoints of your API may be appended to this array
//  };
//
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    return http
//        .cors(AbstractHttpConfigurer::disable)
//        .csrf(AbstractHttpConfigurer::disable)
//        .authorizeHttpRequests(auth -> auth
//            .requestMatchers(AUTH_WHITELIST).permitAll()
//            .requestMatchers("/rest/user/auth").permitAll()
//            .requestMatchers("/rest/authors").hasAnyRole("ADMIN", "LIBRARIAN")
//        )
//        .sessionManagement(
//            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
//        .userDetailsService(customUserDetailsService)
//        .build();
//  }
//
//  @Bean
//  public AuthenticationManager authenticationManager(
//      AuthenticationConfiguration authenticationConfiguration)
//      throws Exception {
//    return authenticationConfiguration.getAuthenticationManager();
//  }
//}
//

