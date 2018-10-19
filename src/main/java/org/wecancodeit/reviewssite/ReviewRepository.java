package org.wecancodeit.reviewssite;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReviewRepository {

	private Map<Long, Doggo> doggos = new HashMap<>();

	public ReviewRepository() {
		add(new Doggo(1L, "Tricky", "tricky.gif", "Bad boy", "Sneaky boy will fake pets to steal treats (3/10)"));
		add(new Doggo(2L, "Bear", "bear.jpg", "not a Dog",
				"Still happy to be welcomed playing with other doggos (8/10)"));
		add(new Doggo(3L, "Dancing", "dancing.gif", "Good boy", "Peppy doggo getting ready for a night out (10/10)"));
		add(new Doggo(4L, "Dogtor", "dogtor.jpg", "Good boy", "Ready to inspect and sniff out diagnosis (9/10)"));
		add(new Doggo(5L, "Happy", "happyDach.jpg", "Good boy",
				"Just wants you to know you're his whole world (12/10)"));
	}

	public void add(Doggo dummyDoggo) {
		doggos.put(dummyDoggo.getId(), dummyDoggo);

	}

	public Collection<Doggo> findAll() {
		return doggos.values();
	}

	public Doggo findOne(long id) {
		return doggos.get(id);

	}

}
