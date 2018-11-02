package org.wecancodeit.reviewssite.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssite.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
