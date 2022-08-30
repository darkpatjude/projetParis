package fivefoot.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {

	@GetMapping("")
	public String hello() {
		return "hello werld";
	}


}
