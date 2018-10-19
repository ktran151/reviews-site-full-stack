package org.wecancodeit.reviewssite;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Test;

public class ReviewRepositoryTest {
	ReviewRepository underTest = new ReviewRepository();

	@Test
	public void shouldAddDoggo() {
		Doggo dummyDoggo = new Doggo(6L, "", "", "", "");
		underTest.add(dummyDoggo);
		Collection<Doggo> collectionDog = underTest.findAll();
		assertThat(collectionDog, hasItems(dummyDoggo));
	}

	@Test
	public void shouldFindDummy() {
		Doggo dummyDoggo = new Doggo(15L, "", "", "", "");
		underTest.add(dummyDoggo);
		Doggo result = underTest.findOne(15L);
		assertThat(dummyDoggo, is(result));
	}

	@Test
	public void shouldNotBeEmptyWhenConstructed() {
		assertThat(underTest.findAll(), is(not(empty())));
	}

	@Test
	public void shouldGetDogtor() {
		Doggo result = underTest.findOne(4L);
		assertEquals("Dogtor", result.getTitle());
	}

}
