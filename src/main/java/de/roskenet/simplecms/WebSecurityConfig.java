package de.roskenet.simplecms;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		 auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery(
		   "select id, passwd, 'true' from suser where id=?")
		  .authoritiesByUsernameQuery(
		   "SELECT suser.id, srole.id "
		   + "FROM suser, suser_sgroup, sgroup, srole, sgroup_srole "
		   + "WHERE sgroup_srole.sgroup_id=sgroup.id "
		   + "AND sgroup_srole.srole_id=srole.id "
		   + "AND sgroup.id=suser_sgroup.sgroup_id "
		   + "AND suser_sgroup.suser_id=suser.id AND suser.id=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/index.html", "/page/**", "/static/**")
				    .permitAll()
				.antMatchers("/api/**").access("hasRole('ROLE_ADMIN')")
				.and()
					.formLogin()
				.and()
					.httpBasic();
						
	}
}
