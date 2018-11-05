package org.wecancodeit.reviewssite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.reviewssite.model.Doggo;
import org.wecancodeit.reviewssite.model.Tag;
import org.wecancodeit.reviewssite.repositories.DoggoRepository;
import org.wecancodeit.reviewssite.repositories.TagRepository;

@RestController
public class ApiController {

	@Autowired
	DoggoRepository doggoRepo;

	@Autowired
	TagRepository tagRepo;

	@GetMapping("/api/doggos")
	public Iterable<Doggo> getDoggos() {
		return doggoRepo.findAll();
	}

	@GetMapping("/api/doggos/{id}")
	public Doggo getDoggo(@PathVariable(value = "id") Long id) {
		return doggoRepo.findById(id).get();
	}

	@GetMapping("/api/tags/{name}")
	public Tag getTag(@PathVariable(value = "name") String tagName) {
		return tagRepo.findByTagNameIgnoreCase(tagName);
	}

	@PostMapping("/api/doggo/{id}/tags/add")
	public String addTag(@PathVariable(value = "id") Long id, @RequestBody String body) {
		System.out.println(body);
		return null;
	}

}
