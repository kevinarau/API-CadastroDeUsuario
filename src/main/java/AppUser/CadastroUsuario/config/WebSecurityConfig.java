package AppUser.CadastroUsuario.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
        protected void configure (AuthenticationManagerBuilder http ) throws Exception {

        http.inMemoryAuthentication()
                .withUser("kevin")
                .password("{noop}user123")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin123")
                .roles("ADMIN");
       }
    }


