package com.leo.citiesapi.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

@Entity
@Table(name = "cidade")
@TypeDefs(value = {
	    @TypeDef(name = "point", typeClass = PointType.class)
	})
public class City {

  @Id
  private Long id;

  @Column(name = "nome")
  private String name;

  @ManyToOne
  @JoinColumn(name = "uf", referencedColumnName = "id")
  private State uf;

  private Integer ibge;

 
  @Column(name = "lat_lon")
  private String geolocation;

  @Type(type = "point")
  @Column(name = "lat_lon", updatable = false, insertable = false)
  private Point location;

  public City() {
  }

 

  public State getUf() {
	return uf;
}



public void setId(Long id) {
	this.id = id;
}


public void setName(String name) {
	this.name = name;
}


public void setUf(State uf) {
	this.uf = uf;
}


public void setIbge(Integer ibge) {
	this.ibge = ibge;
}

public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }



  public Integer getIbge() {
    return ibge;
  }


	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point location) {
		this.location = location;
	}



	public String getGeolocation() {
		return geolocation;
	}



	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}




}