package org.wecancodeit.reviewssite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssite.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>  {

}



