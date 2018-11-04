package org.wecancodeit.reviewssite.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	Long id;
	String tagName;
	
	@JsonIgnore
	@ManyToMany
	private Collection<Doggo> doggos = new HashSet<>();

	public Tag() {}
	
	public Tag(String tagName) {
		this.tagName = tagName;
	}
	
	public void addDoggo(Doggo newDoggo) {
		doggos.add(newDoggo);
		System.out.println("fuck ya chicken strips");
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
