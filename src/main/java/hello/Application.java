package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Application { //extends WebSecurityConfigurerAdapter {


	public static void main(String[] args) {

		SpringApplication.run(Application.class);
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.antMatcher("/**").
//				authorizeRequests().
//				antMatchers("/", "/login**", "/webjars/**").
//				permitAll().
//				anyRequest().
//				authenticated();
//	}
}

