package org.wecancodeit.reviewssite.controller;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.reviewssite.model.Category;
import org.wecancodeit.reviewssite.model.Doggo;
import org.wecancodeit.reviewssite.model.Tag;
import org.wecancodeit.reviewssite.repositories.CategoryRepository;
import org.wecancodeit.reviewssite.repositories.DoggoRepository;
import org.wecancodeit.reviewssite.repositories.TagRepository;

@RestController
public class ApiController {

	@Autowired
	private DoggoRepository doggoRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private TagRepository tagRepo;

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

	@GetMapping("/api/category/{id}")
	public Category getCategory(@PathVariable(value = "id") Long id) {
		return categoryRepo.findById(id).get();
	}

	@PostMapping("/api/doggos/{id}/add-tag")
	public Collection<Tag> addTag(@PathVariable(value = "id") Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String tagName = json.getString("tagName");
		System.out.println(tagName);
		System.out.println(id);
		Doggo doggo = doggoRepo.findById(id).get();
		Tag tag;

		if (tagRepo.findByTagNameIgnoreCase(tagName) == null) {
			tag = new Tag(tagName);

		} else {
			tag = tagRepo.findByTagNameIgnoreCase(tagName);
		}

		doggo.addTag(tag);
		tagRepo.save(tag);
		return doggo.getTags();
	}

}
