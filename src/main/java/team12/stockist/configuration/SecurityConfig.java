package team12.stockist.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		
		auth.inMemoryAuthentication()
		.withUser("naing").password("test123").roles("mechanic");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
		.and()
		.logout().permitAll();
		
	}
	
	

}
