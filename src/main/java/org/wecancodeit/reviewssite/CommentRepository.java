package org.wecancodeit.reviewssite;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssite.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
