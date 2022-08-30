package fivefoot.restController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import fivefoot.entities.Client;
import fivefoot.entities.JsonViews;
import fivefoot.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	
	
	@Autowired
    private ClientService clientService;


//    @GetMapping("")
//    @JsonView(JsonViews.Base.class)
//    public List<Client> getAll() {
//        return clientService.getAll();
//    }

    @GetMapping("/{id}")
    @JsonView(Base.class)
    public Client getById(@PathVariable Long id) {
        return clientService.getById(id);
    }


    @JsonView(JsonViews.Base.class)
    @PostMapping("")
    public Client create(@Valid @RequestBody Client client, BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return clientService.create(client);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Base.class)
    public Client update(@PathVariable Long id, @Valid @RequestBody Client client, BindingResult br) {
        if (br.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        client.setId_client(id);
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
