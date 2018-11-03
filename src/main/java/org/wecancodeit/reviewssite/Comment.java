package org.wecancodeit.reviewssite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;

	@Lob
	private String text;

	@ManyToOne
	private Doggo doggo;

	public Comment() {
	}

	public Comment(String text, Doggo doggo) {
		this.text = text;
		this.doggo = doggo;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Doggo getDoggo() {
		return doggo;
	}

}
