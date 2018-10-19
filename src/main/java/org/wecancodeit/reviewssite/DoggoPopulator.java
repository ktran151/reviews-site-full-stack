package org.wecancodeit.reviewssite;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DoggoPopulator implements CommandLineRunner {
	@Resource
	DoggoRepository doggoRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Override
	public void run(String... args) throws Exception {
		Category categoryOne = new Category("Bad boy");
		Category categoryTwo = new Category("Good boy");
		Category categoryThree = new Category("Not a dog");

		categoryOne = categoryRepo.save(categoryOne);
		categoryTwo = categoryRepo.save(categoryTwo);
		categoryThree = categoryRepo.save(categoryThree);

		Doggo doggoOne = new Doggo("Tricky", "tricky.gif", categoryOne,
				"Sneaky boy will fake pets to steal treats (3/10)");
		Doggo doggoTwo = new Doggo("Bear", "bear.jpg", categoryThree,
				"Still happy to be welcomed playing with other doggos (8/10)");
		Doggo doggoThree = new Doggo("Dancing", "dancing.gif", categoryTwo,
				"Peppy doggo getting ready for a night out (10/10)");
		Doggo doggoFour = new Doggo("Dogtor", "dogtor.jpg", categoryTwo,
				"Ready to inspect and sniff out diagnosis (9/10)");
		Doggo doggoFive = new Doggo("Happy", "happyDach.jpg", categoryTwo,
				"Just wants you to know you're his whole world (12/10)");

		doggoRepo.save(doggoOne);
		doggoRepo.save(doggoTwo);
		doggoRepo.save(doggoThree);
		doggoRepo.save(doggoFour);
		doggoRepo.save(doggoFive);
	}
}
