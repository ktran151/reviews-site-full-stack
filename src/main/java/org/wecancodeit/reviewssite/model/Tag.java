package org.wecancodeit.reviewssite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	Long id;
	String tagName;
	
	@ManyToMany
	private Collection<Doggo> doggos;

	public Tag() {}
	
	public Tag(String tagName) {
		this.tagName = tagName;
	}
	
	public void addDoggo(Doggo newDoggo) {
		doggos.add(newDoggo);
	}

	public Long getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public Collection<Doggo> getDoggos() {
		return doggos;
	}
	
}
