package formation.projetParis.newFive.restcontroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@CrossOrigin(origins="*")
public class DemoRestController {

	@GetMapping("")
	public String hello() {
		return "hello werld";
	}


}
