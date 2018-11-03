package org.wecancodeit.reviewssite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.reviewssite.models.Doggo;
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

}
