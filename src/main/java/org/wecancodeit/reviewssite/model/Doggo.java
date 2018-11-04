package org.wecancodeit.reviewssite.model;

import java.util.Collection;
import java.util.HashSet;

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
	
	@ManyToMany(mappedBy = "doggos")
	private Collection<Tag> tags = new HashSet<>();

	public Doggo() {
	}

	public Doggo(String title, String url, Category category, String review) {
		this.title = title;
		this.url = url;
		this.category = category;
		this.review = review;
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
		System.out.println("heyyyy");
	}

	public Collection<Tag> getTags() {
		return tags;
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
	
	public Collection<Comment> getComments(){
		return comments;
	}
}
