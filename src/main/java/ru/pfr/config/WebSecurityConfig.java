package ru.pfr.config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.pfr.viewhtml.ViewHtml;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    WebSecurityConfig(){
     PropertyConfigurator.configure("src\\main\\resources\\log4j.properties");
 }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/css/**").permitAll().anyRequest()
//                .fullyAuthenticated().and().formLogin();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//			.ldapAuthentication()
//				.userDnPatterns("uid={0},OU=Отдел информационных технологий")
//
//				.groupSearchBase("OU=Пользователи,OU=ЦО,OU=Отделение ПФР по г. Севастополь")
//				.contextSource()
//					.url("ldap://10.92.0.25:389/dc=0092,dc=pfr,dc=ru")
//				    .managerDn("cn=092Infomat,dc=0092,dc=pfr,dc=ru")
//				    .managerPassword("Sev7777")
////				    .managerDn(conf.getBindCn())
////				    .managerPassword(conf.getBindPass())
//					.and()
//				.passwordCompare()
//					.passwordEncoder(new BCryptPasswordEncoder())
//					.passwordAttribute("userPassword");
        }

    private static final Logger log = Logger.getLogger(WebSecurityConfig.class);
}
