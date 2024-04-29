package com.hypo.driven.recording

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

//    @Bean
//    fun filterChain(http: HttpSecurity): SecurityFilterChain {
//
//
//        // @formatter:off
//        http
//            .authorizeHttpRequests{
//                it.requestMatchers("/static/**", "/favicon.ico", "/login").permitAll()
//                it.anyRequest().authenticated()
//            }
//            .oauth2Login(Customizer.withDefaults())
//            .oauth2Client(Customizer.withDefaults())
//        // @formatter:on
//        return http.build()
//    }

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web ->
            web.debug(true) // デバッグモードを有効にする
        }
    }
}