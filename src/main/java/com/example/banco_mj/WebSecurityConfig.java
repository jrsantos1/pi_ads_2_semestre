package com.example.banco_mj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
   DataSource dataSource;

    @Override
    public void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> requests
                        .antMatchers("/", "/home", "/conta/formulario_nova_conta").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/user/home", true)
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll()).csrf().disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//        UserDetails user =
//                User.builder().
//                        username("45179292808").
//                        password(encoder.encode("admin")).
//                        roles("ADM").
//                        build();

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder);
                   // .withUser(user);
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//            UserDetails user =
//                    User.withDefaultPasswordEncoder().
//                            username("admin").
//                            password("admin").
//                            roles("ADM").
//                            build();
//            return new InMemoryUserDetailsManager(user);
//    }



}
