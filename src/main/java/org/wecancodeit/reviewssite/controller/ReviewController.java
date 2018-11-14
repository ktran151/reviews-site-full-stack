package org.wecancodeit.reviewssite.controller;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wecancodeit.reviewssite.model.Category;
import org.wecancodeit.reviewssite.model.Comment;
import org.wecancodeit.reviewssite.model.Doggo;
import org.wecancodeit.reviewssite.model.Tag;
import org.wecancodeit.reviewssite.repositories.CategoryRepository;
import org.wecancodeit.reviewssite.repositories.CommentRepository;
import org.wecancodeit.reviewssite.repositories.DoggoRepository;
import org.wecancodeit.reviewssite.repositories.TagRepository;


@Controller
public class ReviewController {

	@Autowired
	private DoggoRepository reviewRepo;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private TagRepository tagRepo;

	@GetMapping("/")
	public String getHome() {
		return "index";
	}

	@GetMapping("/doggos")
	public String getDoggos(Model model) {
		model.addAttribute("doggos", reviewRepo.findAll());
		return "reviews";
	}

	@GetMapping("doggos/{id}")
	public String getDoggo(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("doggo", reviewRepo.findById(id).get());
		return "review";
	}

	@GetMapping("doggos/add-doggo")
	public String showAddDoggo() {
		return "add-doggo";
	}

//	@PostMapping("doggo/{id}/add-doggo")
//	public String addDoggo(String title, String url, Category category, String review) {
//		Doggo addedDoggo = new Doggo(title, url, category, review);
//		categoryRepo.save(category);
//		reviewRepo.save(addedDoggo);
//		return "doggos/" + addedDoggo.getId();
//	}

	@GetMapping("tags/{tagName}")
	public String getTag(@PathVariable(value = "tagName") String tagName, Model model) {
		model.addAttribute("tag", tagRepo.findByTagNameIgnoreCase(tagName));
		return "tag";
	}

	@PostMapping("doggos/{id}/add-comment")
	public String addComment(@PathVariable(value = "id") Long id, String message, Model model) {
		commentRepo.save(new Comment(message, reviewRepo.findById(id).get()));
		return "redirect:/doggos/" + id;
	}

	@PostMapping("/reviews/{id}/tag")
	public String addTag(@PathVariable(value = "id") Long id, String tagName, Model model) {
		Tag tag = new Tag(tagName);
		reviewRepo.findById(id).get().addTag(tag);
		tagRepo.save(tag);
		return "redirect:/doggos/{id}";
	}

}
