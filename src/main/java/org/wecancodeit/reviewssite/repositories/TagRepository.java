package org.wecancodeit.reviewssite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssite.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findByTagNameIgnoreCase(String tagName);

}
