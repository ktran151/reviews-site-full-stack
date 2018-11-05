package org.wecancodeit.reviewssite.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Doggo {

	@Id
	@GeneratedValue
	private Long id;

	private String title;
	private String url;

	@Lob
	private String review;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "doggo")
	private Collection<Comment> comments;

	@ManyToMany
	private Collection<Tag> tags = new ArrayList<>();

	public Doggo() {
	}

	public Doggo(String title, String url, Category category, String review) {
		this.title = title;
		this.url = url;
		this.category = category;
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public Category getCategory() {
		return category;
	}

	public String getReview() {
		return review;
	}

	public void addTag(Tag tag) {
		tags.add(tag);
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public Collection<Comment> getComments() {
		return comments;
	}
}
