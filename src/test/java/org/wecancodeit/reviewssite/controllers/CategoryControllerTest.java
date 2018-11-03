package org.wecancodeit.reviewssite.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviewssite.controllers.CategoryController;
import org.wecancodeit.reviewssite.repositories.CategoryRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CategoryRepository categoryRepo;

	@Test
	public void shouldBeOkfromHome() throws Exception {
		mockMvc.perform(get("/categories")).andExpect(status().isOk());
		// ^Arrange----^Act--------------------^Assert
	}

	@Test
	public void shouldShowHome() throws Exception {
		mockMvc.perform(get("/categories")).andExpect(view().name("categories/categories"));
		// ^Arrange----^Act--------------------^Assert
	}

}
