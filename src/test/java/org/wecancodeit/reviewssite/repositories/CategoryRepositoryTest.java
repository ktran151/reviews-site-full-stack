package org.wecancodeit.reviewssite.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.reviewssite.model.Category;
import org.wecancodeit.reviewssite.repositories.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Resource
	CategoryRepository categoryRepo;
	
	@Test
	public void shouldContainDoggo() {
		Category categoryOne = categoryRepo.save(new Category(""));
		
		Iterable<Category> result = categoryRepo.findAll();
		
		assertThat(result, hasItems(categoryOne));
		
	}
}
