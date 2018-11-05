package org.wecancodeit.reviewssite.model;

//*Test github Update of Tag Class with jrbranch01

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Collection<Doggo> doggos;

	public Collection<Doggo> getDoggos() {
		return doggos;
	}

	public String getTagName() {
		return tagName;
	}

}