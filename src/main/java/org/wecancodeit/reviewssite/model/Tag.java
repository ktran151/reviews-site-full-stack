package org.wecancodeit.reviewssite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	public Tag() {
	}

	public Tag(String tagName) {
		this.tagName = tagName;
	}

	public void setDoggos(Collection<Doggo> doggos) {
		this.doggos = doggos;
	}

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;

	@ManyToMany(mappedBy = "tags")
	private Collection<Doggo> doggos;

	public Collection<Doggo> getDoggos() {
		return doggos;
	}

	public String getTagName() {
		return tagName;
	}

}