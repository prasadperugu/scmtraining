package com.prasad.scm.springapplication.security.services;

import com.prasad.scm.springapplication.security.jwt.AuthEntryPointJwt;
import com.prasad.scm.springapplication.security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    /**
     * Creates and configures the authentication token filter.
     *
     * @return The authentication token filter
     */
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    /**
     * Creates and configures the DAO authentication provider.
     *
     * @return The DAO authentication provider
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    /**
     * Creates and configures the authentication manager.
     *
     * @param authConfig Authentication configuration
     * @return The authentication manager
     * @throws Exception if an exception occurs during the configuration
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Creates and configures the password encoder.
     *
     * @return The password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the security filter chain.
     *
     * @param http HttpSecurity object
     * @return The security filter chain
     * @throws Exception if an exception occurs during the configuration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                // authenticationEntryPoint will catch authentication error.
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
                // Here we are going to set the session as stateless, which means we are not creating any session state on the server side
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // We provide the authorization rules for every endpoint
                .authorizeRequests().antMatchers("/api/auth/**","/getData").permitAll().antMatchers("/api/test/**","/getData").permitAll()
                .antMatchers("/shipment/**","/getData").permitAll() // Requires either ROLE_ADMIN or ROLE_USER
                .anyRequest().authenticated();
        // Authenticating users based on the configured rules
        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        http.formLogin();

        return http.build();
    }
}
