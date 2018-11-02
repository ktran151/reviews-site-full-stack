package org.wecancodeit.reviewssite;

import org.springframework.data.repository.CrudRepository;

public interface DoggoRepository extends CrudRepository<Doggo, Long> {

	Doggo findByTitleIgnoreCase(String title);
}
