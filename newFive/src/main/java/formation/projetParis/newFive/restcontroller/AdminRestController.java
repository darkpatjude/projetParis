package formation.projetParis.newFive.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import formation.projetParis.newFive.entities.Admin;
import formation.projetParis.newFive.entities.JsonViews;
import formation.projetParis.newFive.services.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins="*")
public class AdminRestController {

	@Autowired
    private AdminService  adminService;


    @GetMapping("")
    @JsonView(JsonViews.Base.class)
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    @JsonView(Base.class)
    public Admin getById(@PathVariable Long id) {
        return adminService.getById(id);
    }


    @JsonView(JsonViews.Base.class)
    @PostMapping("")
    public Admin create(@Valid @RequestBody Admin admin, BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return adminService.create(admin);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Base.class)
    public Admin update(@PathVariable Long id, @Valid @RequestBody Admin admin, BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        admin.setId(id);
        return adminService.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        adminService.deleteById(id);
    }
}
