package org.wecancodeit.reviewssite;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssite.models.Tag;

public interface TagRespository extends CrudRepository<Tag, Long> {

}
