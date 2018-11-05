package org.wecancodeit.reviewssite.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviewssite.controller.ReviewController;
import org.wecancodeit.reviewssite.repositories.TagRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldBeOkfromHome() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
		// ^Arrange----^Act--------------------^Assert
	}

	@Test
	public void shouldShowHome() throws Exception {
		mockMvc.perform(get("/")).andExpect(view().name("index"));
		// ^Arrange----^Act--------------------^Assert
	}

	@Test
	public void shouldBeOkAtDoggos() throws Exception {
		mockMvc.perform(get("/doggos")).andExpect(status().isOk());
		// ^Arrange----^Act--------------------^Assert
	}

	@Test
	public void shouldBeOkAtDoggo() throws Exception {
		mockMvc.perform(get("/doggos/3")).andExpect(status().isOk());
		// ^Arrange----^Act--------------------^Assert
	}

	@Test
	public void shouldReturnDoggoTemplate() throws Exception {
		mockMvc.perform(get("/doggos/3")).andExpect(view().name("review"));
	}

	@Test
	public void shouldReturnDoggosTemplate() throws Exception {
		mockMvc.perform(get("/doggos")).andExpect(view().name("reviews"));
	}

	@Test
	public void shouldGoToTag() throws Exception {
		mockMvc.perform(get("/tags/#furry")).andExpect(status().isOk());
	}

	@Test
	public void shouldGoToTagTemplate() throws Exception {
		mockMvc.perform(get("/tags/#furry")).andExpect(view().name("tag"));
	}
}
