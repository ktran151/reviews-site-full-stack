package org.wecancodeit.reviewssite.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.reviewssite.model.Doggo;
import org.wecancodeit.reviewssite.model.Tag;
import org.wecancodeit.reviewssite.repository.DoggoRepository;
import org.wecancodeit.reviewssite.repository.TagRepository;

@RestController
public class ApiController {

	@Autowired
	private TagRepository tagRepo;
	
	@Autowired
	private DoggoRepository reviewRepo;
	
	@GetMapping("/api/tags/{tagName}")
	public Tag getTag(@PathVariable(value = "tagName") String tagName) {
		return tagRepo.findByTagNameIgnoreCase(tagName);
	}
	
	@GetMapping("/api/tags")
	public Iterable<Tag> getTags() {
		return tagRepo.findAll();
	}
	
	@GetMapping("/api/doggos/{id}")
	public Doggo getDoggo(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get();
	}
	
	@PostMapping("/api/doggos/{id}/tags/add")
	public String addTag(@PathVariable(value = "id") Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String newTag = json.getString("tagName");
		System.out.println(newTag);
		if(tagRepo.findByTagNameIgnoreCase(newTag)!=null) {
			//adds doggo to tag
			tagRepo.findByTagNameIgnoreCase(newTag).addDoggo(reviewRepo.findById(id).get());
			//adds tag to doggo
			reviewRepo.findById(id).get().addTag(tagRepo.findByTagNameIgnoreCase(newTag));
		} else {
			//creates tag
			tagRepo.save(new Tag(newTag));
			//adds doggo to tag
			tagRepo.findByTagNameIgnoreCase(newTag).addDoggo(reviewRepo.findById(id).get());
			//adds tag to doggo
			reviewRepo.findById(id).get().addTag(tagRepo.findByTagNameIgnoreCase(newTag));
		}
		return null;
	}
}
