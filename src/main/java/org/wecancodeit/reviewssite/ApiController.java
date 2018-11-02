package org.wecancodeit.reviewssite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


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
