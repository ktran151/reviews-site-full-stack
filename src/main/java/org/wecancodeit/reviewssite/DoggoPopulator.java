package org.wecancodeit.reviewssite;

import java.util.ArrayList;
import java.util.Collection;

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
		
		
		Collection<Tag> trickyTags = new ArrayList<>();
		trickyTags.add(tagOne);
		trickyTags.add(tagTwo);
		trickyTags.add(tagFour);
		
		Collection<Tag> bearTags = new ArrayList<>();
		bearTags.add(tagThree);
		bearTags.add(tagFour);
		
		Collection<Tag> dancingTags = new ArrayList<>();
		dancingTags.add(tagFive);
		dancingTags.add(tagSix);
		
		Collection<Tag> dogtorTags = new ArrayList<>();
		dogtorTags.add(tagFour);
		dogtorTags.add(tagSeven);
		dogtorTags.add(tagEight);
		
		Collection<Tag> happyTags = new ArrayList<>();
		happyTags.add(tagNine);
		
		Collection<Tag> fluffyTags = new ArrayList<>();
		fluffyTags.add(tagFour);
		fluffyTags.add(tagNine);
		
		Collection<Tag> spookyTags = new ArrayList<>();
		spookyTags.add(tagTwo);
		spookyTags.add(tagNine);
		spookyTags.add(tagTen);
		
		Collection<Tag> wizardTags = new ArrayList<>();
		wizardTags.add(tagTwo);
		wizardTags.add(tagEleven);
		wizardTags.add(tagTwelve);
	
		Collection<Tag> policeTags = new ArrayList<>();
		policeTags.add(tagEight);
		
		Doggo doggoOne = new Doggo("Tricky", "tricky.gif", categoryOne,
				"Sneaky boy will fake pets to steal treats (2/10)", trickyTags);
		Doggo doggoTwo = new Doggo("Bear", "bear.jpg", categoryThree,
				"Still happy to be welcomed playing with other doggos (8/10)", bearTags);
		Doggo doggoThree = new Doggo("Dancing", "dancing.gif", categoryTwo,
				"Peppy doggo getting primming and can't wait for a night out (10/10)", dancingTags);
		Doggo doggoFour = new Doggo("Dogtor", "dogtor.jpg", categoryTwo,
				"Ready to inspect and sniff out diagnosis (9/10)", dogtorTags);
		Doggo doggoFive = new Doggo("Happy Dach", "happyDach.jpg", categoryTwo,
				"Just wants you to know you're his whole world (12/10)", happyTags);
		Doggo doggoSix = new Doggo("Fluffy", "fluffy.jpg", categoryThree,
				"Really fluffy boy, fluffiest boy on the farm (9/10)", fluffyTags);
		Doggo doggoSeven = new Doggo("Spooky", "spooky.jpg", categoryOne, "Real scary boy, many frights had (4/10)", spookyTags);
		Doggo doggoEight = new Doggo("Wizard Boy", "wizard.gif", categoryOne,
				"UR A WIZARD HAIRY. Messin with all the lights, scarin your cousin Dudley (6/10)", wizardTags);
		Doggo doggoNine = new Doggo("Police", "police.jpg", categoryTwo,
				"Helpful boy upholding justice for citizen doggos. (9/10)", policeTags);

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
