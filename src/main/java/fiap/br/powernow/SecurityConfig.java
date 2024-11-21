package fiap.br.powernow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fiap.br.powernow.service.ClienteService;
import jakarta.servlet.ServletContext;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private final ClienteService usuarioService;

	@Autowired
	private ServletContext servletContext;

	@Bean
	public UserDetailsService userDetailsService() {
		return usuarioService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder() {
	        @Override
	        public boolean matches(CharSequence rawPassword, String encodedPassword) {
	            boolean matches = super.matches(rawPassword, encodedPassword);
	            return matches;
	        }
	    };
	}


	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(usuarioService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(AbstractHttpConfigurer::disable).formLogin(httpForm -> {
			httpForm.loginPage("/usuarios/login").permitAll();
			httpForm.failureUrl("/usuarios/login?error=true"); // URL de erro
		}).authorizeHttpRequests(registry -> {
			registry.requestMatchers("/powernow/**", "/usuarios/**", "/css/**", "/js/**","/swagger-ui/").permitAll();
			registry.anyRequest().authenticated();
		}).build();
	}

}

