package org.wecancodeit.reviewssite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	Long Id;
	String userName;
	@Lob
	String comment;
	
	@ManyToOne
	private Doggo doggo;
	
	public Comment() {}
	
	public Comment(String userName, String comment, Doggo doggo) {
		this.userName = userName;
		this.comment = comment;
		this.doggo = doggo;
	}

	public Long getId() {
		return Id;
	}

	public String getUserName() {
		return userName;
	}

	public String getComment() {
		return comment;
	}
	
	
}
