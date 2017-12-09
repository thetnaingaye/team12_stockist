package team12.stockist.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import team12.stockist.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

//	@Bean(name="passwordEncoder")
//	public PasswordEncoder passwordencoder() {
//		// TODO Auto-generated method stub
//		return new BCryptPasswordEncoder();
//	}

//	 @Override
//	 protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//	
//	
//	 auth.inMemoryAuthentication()
//	 .withUser("naing").password("test123").roles("mechanic");
//	
//	 auth.inMemoryAuthentication()
//	 .withUser("alice").password("test123").roles("mechanic","admin");
//	 }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/").hasAnyRole("mechanic", "admin")
		.antMatchers("/admin/**").access("hasRole('admin')")
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login")
		.loginProcessingUrl("/authenticateTheUser")
		.and()
		.logout()
				.permitAll();

		//
		// http.authorizeRequests()
		// .antMatchers("/").access("hasAnyRole('mechanic','admin)")
		// .antMatchers("/admin/**").access("hasRole('admin')")
		// .and()
		// .formLogin()
		// .loginPage("/login")
		// .loginProcessingUrl("/authenticateTheUser")
		// .permitAll()
		// .and()
		// .logout().permitAll();

		// http.authorizeRequests()
		// .anyRequest().authenticated()
		// .and()
		// .formLogin()
		// .loginPage("/login")
		// .loginProcessingUrl("/authenticateTheUser")
		// .permitAll()
		// .and()
		// .logout().permitAll();

	}

}
