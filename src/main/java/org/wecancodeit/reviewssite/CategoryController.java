package org.wecancodeit.reviewssite;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	@Resource
	private CategoryRepository categoryRepo;

	@GetMapping("")
	public String getHome() {
		return "categories/index";
	}

	@GetMapping("/{id}")
	public String getDoggo(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("doggo", categoryRepo.findById(id));
		return "categories/category";
	}
}
