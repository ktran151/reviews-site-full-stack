package org.wecancodeit.reviewssite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.reviewssite.model.Tag;
import org.wecancodeit.reviewssite.repository.TagRepository;

@RestController
public class ApiController {

	@Autowired
	TagRepository tagRepo;
	
	@GetMapping("/api/tags/{tagName}")
	public Tag getTag(@PathVariable(value = "tagName") String tagName) {
		return tagRepo.findByTagNameIgnoreCase(tagName);
	}
}
