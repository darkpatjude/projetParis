package fivefoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fivefoot.Exception.AdminException;
import fivefoot.entities.Admin;
import fivefoot.repositories.AdminRepository;
@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepo;
	
	public Admin create(Admin admin) {
		if (admin.getPrenom()==null||admin.getPrenom().isEmpty()) {
			throw new AdminException();
		}
		if (admin.getNom()==null||admin.getNom().isEmpty()) {
			throw new AdminException();
		}
		return adminRepo.save(admin);
	}

	public Admin create(String prenom, String nom) {
		Admin admin=new Admin();
		admin.setPrenom(prenom);
		admin.setNom(nom);
		return create(admin);
	}

	public Admin getById(Long id) {
		return adminRepo.findById(id).orElseThrow(AdminException::new); //ecriture pour declarer une exception sans parametres
		
	}
	
//	public Admin getByIdWithCommandes(Long id) {
//		return adminRepo.findByKeyWithCommandes(id).orElseThrow(()->{
//			throw new AdminException();
//		}); //escritura clasica para una exception sin parametros... más facil es la de arriba
//	}

	public Admin update(Admin admin) {
		Admin adminEnBase= getById(admin.getId_admin());
		adminEnBase.setPrenom(admin.getPrenom());
		adminEnBase.setNom(admin.getNom());
		adminEnBase.setAdresse(admin.getAdresse());
		return adminRepo.save(adminEnBase);
	}
	
	public List<Admin>getAll(){
		return adminRepo.findAll();
	}
	public void delete(Admin admin) {
		adminRepo.delete(admin);
	}
	
	public void deleteById(Long id) {
		delete(getById(id));
	}
}
