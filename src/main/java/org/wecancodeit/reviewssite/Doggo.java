package org.wecancodeit.reviewssite;

public class Doggo {

	private Long id;
	private String title;
	private String url;
	private String category;
	private String review;

	public Doggo(Long id, String title, String url, String category, String review) {
		this.id = id;
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

	public String getCategory() {
		return category;
	}

	public String getReview() {
		return review;
	}
}
