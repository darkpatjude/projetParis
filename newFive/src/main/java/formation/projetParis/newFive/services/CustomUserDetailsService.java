package formation.projetParis.newFive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.projetParis.newFive.repositories.AdminRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{ //clase usada para usar base de datos para login
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return adminRepo.findByLogin(username).orElseThrow(()->{throw new UsernameNotFoundException("utilisateur "+ username+" innconu");});
	}

}
