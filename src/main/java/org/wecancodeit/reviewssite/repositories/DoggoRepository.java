package org.wecancodeit.reviewssite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssite.models.Doggo;

public interface DoggoRepository extends CrudRepository<Doggo, Long> {

	Doggo findByTitleIgnoreCase(String title);
}
