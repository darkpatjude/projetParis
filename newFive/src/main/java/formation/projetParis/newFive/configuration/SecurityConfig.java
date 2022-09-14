package formation.projetParis.newFive.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig { // esta clase es para administrar la config de secu
	
	protected void configure(HttpSecurity http) throws Exception { //REGLES D'ACCES
		
		// @formatter:off
		http.antMatcher("/**") //je sais que tout commence par api
				.csrf().disable()//esto es indispensable para que la desconexión sea simplemente un url /logout
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.GET,"/").permitAll() //n'importe qui va etre capabla de lister ce contenu. Tambien especificar si es en get o post. Default get, no es necesario escribir
					 //anonymous es lo contrario a authenticated, on est obligés d'etre connectés
					.anyRequest().permitAll()
					.and()
					.httpBasic();
					//solo lo que ya esta autenticado?

		// @formatter:on
	}
	
	@Autowired
	private UserDetailsService userDetailsService; //pusimos en comentario al utilisador en memoria y añadimos este autowire y la linea de auth.user...

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// utilisateur en memoire
		// @formatter:off
		auth.inMemoryAuthentication()
			.withUser("admin").password("{noop}admin").roles("ADMIN") //noop hace que no se encode la cadena de caracteres "admin"
			.and()
			.withUser("user1").password("{noop}user1").roles("USER");
		// @formatter:on
		
		auth.userDetailsService(userDetailsService);

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
