package org.wecancodeit.reviewssite;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Tags {
	
	
	

	public Tags(String tName, Collection<Doggo> doggos) {
		this.tName = tName;
		this.doggos = doggos;
	}

	public void setDoggos(Collection<Doggo> doggos) {
		this.doggos = doggos;
	}

	@Id @GeneratedValue
	private Long id;
	private String tName;
	private Collection <Doggo> doggos;
	
	@ManyToMany (mappedBy = "Doggo")
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