package metamodern7.testspringboot.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by igor on 02.06.2020
 */
@Configuration
@EnableWebSecurity                //обеспечиваем аутентификацию
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication().withUser("user").password(encoder.encode("user")).roles("USER");     //для теста задал сам
        auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users**").access("hasRole('ROLE_ADMIN')")//добавляем префикс - задается выражение проверки
                .antMatchers("/requests").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
                .and().formLogin().defaultSuccessUrl("/", false)
                .and().csrf().disable();                                                     //отключаем защиту, т.к. по-дефолту активна

    }
}
