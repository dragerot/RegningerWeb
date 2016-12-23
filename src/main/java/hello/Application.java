package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

