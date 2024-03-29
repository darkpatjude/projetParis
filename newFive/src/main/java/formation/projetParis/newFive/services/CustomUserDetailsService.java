package formation.projetParis.newFive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import formation.projetParis.newFive.repositories.AdminRepository;
import formation.projetParis.newFive.repositories.ClientRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService { // clase usada para usar base de datos para login

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private ClientRepository clientRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if(adminRepo.findByLogin(username).isEmpty()) { //.isEmpty est l'invers a .isPresent()
			
			System.out.println(adminRepo.findByLogin(username)); //uno de los dos será Optional.empty
			System.out.println(clientRepo.findByLogin(username));
			return clientRepo.findByLogin(username).orElseThrow(() -> {throw new UsernameNotFoundException("utilisateur " + username + " innconu");});
			
		} else {
			
			System.out.println(adminRepo.findByLogin(username)); //uno de los dos será Optional.empty
			System.out.println(clientRepo.findByLogin(username));
			return adminRepo.findByLogin(username).orElseThrow(() -> {throw new UsernameNotFoundException("utilisateur " + username + " innconu");});
			
		}


		
	}

}
