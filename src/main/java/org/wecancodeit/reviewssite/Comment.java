package org.wecancodeit.reviewssite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	
	public Comment() {
	}

	public Comment(String text, Doggo doggo) {
		this.text = text;
		this.doggo = doggo;
	}

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Doggo getDoggo() {
		return doggo;
	}

	@Lob
	private String text;

	@ManyToOne
	private Doggo doggo;

}
