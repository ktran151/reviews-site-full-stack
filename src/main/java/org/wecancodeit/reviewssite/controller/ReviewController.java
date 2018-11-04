package org.wecancodeit.reviewssite.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.reviewssite.model.Category;
import org.wecancodeit.reviewssite.model.Doggo;
import org.wecancodeit.reviewssite.repositories.DoggoRepository;

@Controller
public class ReviewController {

	@Resource
	private DoggoRepository reviewRepo;

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
		model.addAttribute("category", reviewRepo.findById(id));
		return "review";
	}

	@GetMapping("doggos/add-doggo")
	public String showAddDoggo() {
		return "add-doggo";
	}

	@PostMapping
	public String addDoggo(String title, String url, Category category, String review) {
		Doggo addedDoggo = new Doggo(title, url, category, review);
		reviewRepo.save(addedDoggo);
		return "doggos/" + addedDoggo.getId();
	}
}
