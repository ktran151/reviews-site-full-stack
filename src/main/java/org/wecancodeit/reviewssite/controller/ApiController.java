package org.wecancodeit.reviewssite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.reviewssite.model.Doggo;
import org.wecancodeit.reviewssite.repositories.DoggoRepository;


@RestController
public class ApiController {

	@Autowired
	DoggoRepository doggoRepo;

	@GetMapping("/api/doggos")
	public Iterable<Doggo> getDoggos() {
		return doggoRepo.findAll();
	}
 
	@GetMapping("/api/tags/{title}")
	public Doggo getStates(@PathVariable(value = "title") String title) {
		return doggoRepo.findByTitleIgnoreCase(title);
	}
	@PostMapping("/api/doggo/{id}/tags/add")
	public String addTag(@PathVariable(value = "id") Long id, @RequestBody String body) {
		System.out.println(body);
		return null;
	}
	
	
}


