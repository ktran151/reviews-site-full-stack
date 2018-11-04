package org.wecancodeit.reviewssite.model;

import static org.hamcrest.Matchers.contains;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class DoggoTest {
	@Test
	public void shouldAddTag() {
		// arrange
		Tag tag = new Tag("#whatever");
		Doggo underTest = new Doggo("", "", null, "");

		// act
		underTest.addTag(tag);

		// assert
		Assert.assertThat(underTest.getTags(), contains(tag));
	}

}
