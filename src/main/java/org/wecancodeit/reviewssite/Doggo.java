package org.wecancodeit.reviewssite;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
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

	@OneToMany(mappedBy = "comment")
	private Collection<Comment> comment;

	private Collection<Tag> tags;

	@ManyToMany
	@JoinTable(name = "DOG_TAGS")
	private Collection<Tag> getTags() {
		return tags;
	}

	public Doggo() {
	}

	public Doggo(String title, String url, Category category, String review, Collection<Tag> tags) {
		this.title = title;
		this.url = url;
		this.category = category;
		this.review = review;
		this.tags = tags;
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

}
