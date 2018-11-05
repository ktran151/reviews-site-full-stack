package org.wecancodeit.reviewssite.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewssite.repositories.TagRepository;

@Controller
@RequestMapping("/tags")
public class TagController {

	@Resource
	private TagRepository tagRepo;

	@GetMapping("")
	public String getTags(Model model) {
		model.addAttribute("tag", tagRepo.findAll());
		return "tags";
	}

	@GetMapping("/{id}")
	public String getTag(@PathVariable(value = "tagName") String tagName, Model model) {
		model.addAttribute("tag", tagRepo.findByTagNameIgnoreCase(tagName));
		return "tag";
	}
}