package org.wecancodeit.reviewssite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssite.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
