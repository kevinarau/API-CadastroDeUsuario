package AppUser.CadastroUsuario.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private SecurityDataBaseConfig securityDataBaseConfig;

    public void  GlobalUserConfig(AuthenticationManagerBuilder auth )throws Exception{
        auth.userDetailsService(securityDataBaseConfig).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure (HttpSecurity http ) throws Exception {
        http .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/Login").permitAll()
                .antMatchers("/users").hasAnyRole("USER","PERFIL")
                .antMatchers("/perfil").hasAnyRole("PERFIL")
                .anyRequest().authenticated().and().httpBasic();


    }

      /*  @Override
        protected void configure (AuthenticationManagerBuilder http ) throws Exception {

        http.inMemoryAuthentication()
                .withUser("kevin")
                .password("{noop}user123")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}admin123")
                .roles("ADMIN");
       }*/
    }


