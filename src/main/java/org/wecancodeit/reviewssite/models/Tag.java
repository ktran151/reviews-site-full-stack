package org.wecancodeit.reviewssite.models;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	
	
	public Tag(){
	}

	public Tag(String tName) {
		this.tName = tName;
	}

	public void setDoggos(Collection<Doggo> doggos) {
		this.doggos = doggos;
	}

	@Id @GeneratedValue
	private Long id;
	private String tName;
	private Collection <Doggo> doggos;
	
//************* Many to Many	
	@ManyToMany (mappedBy = "tags")
	public Collection<Doggo> getDoggos() {
		return doggos;
	}

	
	
	public String gettName() {
		return tName;
	}
	
	public void settName(String tName) {
		this.tName = tName;
	}
}