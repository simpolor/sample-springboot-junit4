package io.simpolor.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping({"/", "/index", "/welcome"})
	public String welcome() {
		return "Intergration Test";
	}
}
