package org.wecancodeit.reviewssite.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewssite.repositories.TagRepository;

@Controller
@RequestMapping("/categories")
public class TagController {

	@Resource
	private TagRepository categoryRepo;

	@GetMapping("")
	public String getHome(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "Tags";
	}

	@GetMapping("/{id}")
	public String getDoggo(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("category", categoryRepo.findById(id).get());
		return "tag";
	}
}