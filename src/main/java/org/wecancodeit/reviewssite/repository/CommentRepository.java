package org.wecancodeit.reviewssite.repository;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssite.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
