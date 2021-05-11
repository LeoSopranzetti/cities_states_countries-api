package com.leo.citiesapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class State {

  @Id
  private Long id;

  @Column(name = "nome")
  private String name;

  private String uf;

  private Integer ibge;

 
  @ManyToOne
  @JoinColumn(name = "pais", referencedColumnName = "id")
  private Country country;



  public void setId(Long id) {
	this.id = id;
}

public void setName(String name) {
	this.name = name;
}

public void setUf(String uf) {
	this.uf = uf;
}

public void setIbge(Integer ibge) {
	this.ibge = ibge;
}

public void setCountry(Country country) {
	this.country = country;
}

public State() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getUf() {
    return uf;
  }

  public Integer getIbge() {
    return ibge;
  }


  public Country getCountry() {
    return country;
  }


}

