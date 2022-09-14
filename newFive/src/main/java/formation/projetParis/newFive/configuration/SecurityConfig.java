package formation.projetParis.newFive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig { // esta clase es para administrar la config de secu
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		// @formatter:off
		http.antMatcher("/**")
				.csrf().disable()//esto es indispensable para que la desconexión sea simplemente un url /logout
				.authorizeRequests()
					.antMatchers(HttpMethod.GET,"/","/home").permitAll() //n'importe qui va etre capabla de lister ce contenu. Tambien especificar si es en get o post. Default get, no es necesario escribir
					.antMatchers("/inscription","/login").anonymous() //anonymous es lo contrario a authenticated
					.anyRequest().permitAll()  //solo lo que ya esta autenticado?
					.and()
					.formLogin()
						.loginPage("/login")
						.defaultSuccessUrl("/secure/home") //debemos hacer un controlador nosotros mismos ahora
						.failureUrl("/login?error=")
					.and()
					.logout()
						.logoutUrl("/logout")
						.logoutSuccessUrl("/home"); //nos va a mandar a produit despues de desconectarse
		// @formatter:on
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
