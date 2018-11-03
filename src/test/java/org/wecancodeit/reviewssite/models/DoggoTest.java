package org.wecancodeit.reviewssite.models;

import static org.hamcrest.Matchers.contains;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class DoggoTest {
	@Test
	public void shouldAcceptTags() {
		// Arrange
		Tag tag = new Tag("#whatever");
		Doggo underTest = new Doggo("", "", null, "", new ArrayList<Tag>());

		// act
		underTest.addTag(tag);

		// assert
		Assert.assertThat(underTest.getTags(), contains(tag));

	}

}
