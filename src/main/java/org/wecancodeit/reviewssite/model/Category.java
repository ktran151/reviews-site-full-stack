package org.wecancodeit.reviewssite.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private Collection<Doggo> doggos;

	public Category(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Doggo> getDoggos() {
		return doggos;
	}

}
