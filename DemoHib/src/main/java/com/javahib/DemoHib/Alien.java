package com.javahib.DemoHib;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Alien {
	
	@Id
	private int aid;
	private String aname;
	private String color;
	
	public int getAid() {
	return aid;
	}
	
		public String getAname() {
		return aname;
	}

	public void setAname(String string) {
		this.aname = string;
	}

		public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	
	

}
