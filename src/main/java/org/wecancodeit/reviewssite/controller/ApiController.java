package org.wecancodeit.reviewssite.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
	
//	@PostMapping("api/doggos/{id}/add-tag")
//	public Iterable<Tag> addComment(@PathVariable(value = "id") Long id, String tagName, Model model) {
//		if(tagRepo.findByTagNameIgnoreCase(tagName)!=null) {
//			tagRepo.findByTagNameIgnoreCase(tagName).addDoggo(reviewRepo.findById(id).get());
//		} else {
//			tagRepo.save(new Tag(tagName));
//			tagRepo.findByTagNameIgnoreCase(tagName).addDoggo(reviewRepo.findById(id).get());
//		}
//		return tagRepo.findAll();
//	}
	
//	@PostMapping("/api/doggos/{id}/tags/add")
//	public String addTag(@PathVariable(value = "id") Long id, @RequestBody String body) {
//		
//		if(tagRepo.findByTagNameIgnoreCase(tagName)!=null) {
//			tagRepo.findByTagNameIgnoreCase(tagName).addDoggo(reviewRepo.findById(id).get());
//		} else {
//			tagRepo.save(new Tag(tagName));
//			tagRepo.findByTagNameIgnoreCase(tagName).addDoggo(reviewRepo.findById(id).get());
//		}
//		System.out.println(body);
//		return null;
//	}
	
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
