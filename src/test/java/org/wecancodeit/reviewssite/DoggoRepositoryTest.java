package org.wecancodeit.reviewssite;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DoggoRepositoryTest {
	@Resource
	DoggoRepository doggoRepo;
	
	@Resource
	CategoryRepository categoryRepo;
	
	@Test
	public void shouldContainDoggo() {
		Category categoryOne = categoryRepo.save(new Category(""));
		Doggo doggoOne = doggoRepo.save(new Doggo("Tricky", "tricky.gif", categoryOne,
				"Sneaky boy will fake pets to steal treats (3/10)",null));
		
		Iterable<Doggo> result = doggoRepo.findAll();
		
		assertThat(result, hasItems(doggoOne));
		
	}
}
