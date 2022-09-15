package formation.projetParis.newFive.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{ // esta clase es para administrar la config de secu

	@Override
	protected void configure(HttpSecurity http) throws Exception { // REGLES D'ACCES

		// @formatter:off
		http.antMatcher("/api/**") //je sais que tout commence par api
				.csrf().disable()//esto es indispensable para que la desconexión sea simplemente un url /logout
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.GET,"/api/marchandise/**").permitAll() //n'importe qui va etre capabla de lister ce contenu. Tambien especificar si es en get o post. Default get, no es necesario escribir
					.antMatchers("/api/admin").hasRole("ADMIN")
					.antMatchers("/api/client").hasRole("USER")
					.anyRequest().permitAll()
					.and()
					.httpBasic();
					//solo lo que ya esta autenticado?

		// @formatter:on
	}

	@Autowired
	private UserDetailsService userDetailsService; // pusimos en comentario al utilisador en memoria y añadimos este
													// autowire y la linea de auth.user...

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
