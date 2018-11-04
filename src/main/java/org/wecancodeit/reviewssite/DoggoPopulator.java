package org.wecancodeit.reviewssite;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviewssite.model.Category;
import org.wecancodeit.reviewssite.model.Doggo;
import org.wecancodeit.reviewssite.model.Tag;
import org.wecancodeit.reviewssite.repositories.CategoryRepository;
import org.wecancodeit.reviewssite.repositories.CommentRepository;
import org.wecancodeit.reviewssite.repositories.DoggoRepository;
import org.wecancodeit.reviewssite.repositories.TagRepository;

@Service
public class DoggoPopulator implements CommandLineRunner {
	@Resource
	DoggoRepository doggoRepo;

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	CommentRepository commentRepo;

	@Resource
	TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		Category categoryOne = new Category("Bad boy");
		Category categoryTwo = new Category("Good boy");
		Category categoryThree = new Category("Not a dog");

		categoryOne = categoryRepo.save(categoryOne);
		categoryTwo = categoryRepo.save(categoryTwo);
		categoryThree = categoryRepo.save(categoryThree);

		Tag tagOne = new Tag("#hungry");
		Tag tagTwo = new Tag("#tricky");
		Tag tagThree = new Tag("#bear");
		Tag tagFour = new Tag("#furry");
		Tag tagFive = new Tag("#dancing");
		Tag tagSix = new Tag("#pomeranian");
		Tag tagSeven = new Tag("#medical");
		Tag tagEight = new Tag("#professional");
		Tag tagNine = new Tag("#happy");
		Tag tagTen = new Tag("#unded");
		Tag tagEleven = new Tag("#magical");
		Tag tagTwelve = new Tag("#golden");

		tagOne = tagRepo.save(tagOne);
		tagTwo = tagRepo.save(tagTwo);
		tagThree = tagRepo.save(tagThree);
		tagFour = tagRepo.save(tagFour);
		tagFive = tagRepo.save(tagFive);
		tagSix = tagRepo.save(tagSix);
		tagSeven = tagRepo.save(tagSeven);
		tagEight = tagRepo.save(tagEight);
		tagNine = tagRepo.save(tagNine);
		tagTen = tagRepo.save(tagTen);
		tagEleven = tagRepo.save(tagEleven);
		tagTwelve = tagRepo.save(tagTwelve);

		Doggo doggoOne = new Doggo("Tricky", "tricky.gif", categoryOne,
				"Sneaky boy will fake pets to steal treats (2/10)");
		Doggo doggoTwo = new Doggo("Bear", "bear.jpg", categoryThree,
				"Still happy to be welcomed playing with other doggos (8/10)");
		Doggo doggoThree = new Doggo("Dancing", "dancing.gif", categoryTwo,
				"Peppy doggo getting primming and can't wait for a night out (10/10)");
		Doggo doggoFour = new Doggo("Dogtor", "dogtor.jpg", categoryTwo,
				"Ready to inspect and sniff out diagnosis (9/10)");
		Doggo doggoFive = new Doggo("Happy Dach", "happyDach.jpg", categoryTwo,
				"Just wants you to know you're his whole world (12/10)");
		Doggo doggoSix = new Doggo("Fluffy", "fluffy.gif", categoryThree,
				"Really fluffy boy, fluffiest boy on the farm (9/10)");
		Doggo doggoSeven = new Doggo("Spooky", "spooky.jpg", categoryOne, "Real scary boy, many frights had (4/10)");
		Doggo doggoEight = new Doggo("Wizard Boy", "wizard.gif", categoryOne,
				"UR A WIZARD HAIRY. Messin with all the lights, scarin your cousin Dudley (6/10)");
		Doggo doggoNine = new Doggo("Police", "police.jpg", categoryTwo,
				"Helpful boy upholding justice for citizen doggos. (9/10)");

		doggoOne.addTag(tagOne);
		doggoOne.addTag(tagTwo);
		doggoOne.addTag(tagFour);

		doggoTwo.addTag(tagThree);
		doggoTwo.addTag(tagFour);

		doggoThree.addTag(tagFive);
		doggoThree.addTag(tagSix);

		doggoFour.addTag(tagFour);
		doggoFour.addTag(tagSeven);
		doggoFour.addTag(tagEight);

		doggoFive.addTag(tagNine);

		doggoSix.addTag(tagFour);
		doggoSix.addTag(tagNine);

		doggoSeven.addTag(tagTwo);
		doggoSeven.addTag(tagNine);
		doggoSeven.addTag(tagTen);

		doggoEight.addTag(tagTwo);
		doggoEight.addTag(tagEleven);
		doggoEight.addTag(tagTwelve);

		doggoNine.addTag(tagEight);

		doggoOne = doggoRepo.save(doggoOne);
		doggoTwo = doggoRepo.save(doggoTwo);
		doggoThree = doggoRepo.save(doggoThree);
		doggoFour = doggoRepo.save(doggoFour);
		doggoFive = doggoRepo.save(doggoFive);
		doggoSix = doggoRepo.save(doggoSix);
		doggoSeven = doggoRepo.save(doggoSeven);
		doggoEight = doggoRepo.save(doggoEight);
		doggoNine = doggoRepo.save(doggoNine);

	}
}
