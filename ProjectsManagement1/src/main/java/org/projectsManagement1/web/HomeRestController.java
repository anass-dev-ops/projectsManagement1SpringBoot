package org.projectsManagement1.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
	
	@GetMapping("/")
	public String getHomeMessage() {
		return "Hello";
	}

}
