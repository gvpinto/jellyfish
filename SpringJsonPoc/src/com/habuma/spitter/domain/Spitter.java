package com.habuma.spitter.domain;

import static java.util.Arrays.*;
import static javax.persistence.GenerationType.*;
import static org.apache.commons.lang.builder.EqualsBuilder.*;
import static org.apache.commons.lang.builder.HashCodeBuilder.*;
import static org.apache.commons.lang.builder.ToStringBuilder.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

public class Spitter implements Serializable {
  private static final long serialVersionUID = 1L;

  private static long key = 0;
  private Long id = Long.valueOf(++key);
  
  public Spitter() {
	  this("default", "password", "defaultName", "default@yahoo.com", true);
  }

  //<start id="java_SpitterValidated" /> 
  @Size(min=3, max=20, message=
      "Username must be between 3 and 20 characters long.") //<co id="co_enforceSize"/> 
  @Pattern(regexp="^[a-zA-Z0-9]+$",
          message="Username must be alphanumeric with no spaces")  //<co id="co_noSpaces"/>
  private String username;  
  
  @Size(min=6, max=20,
          message="The password must be at least 6 characters long.") //<co id="co_enforceSize"/>
  private String password;

  @Size(min=3, max=50, message=
      "Your full name must be between 3 and 50 characters long.")    //<co id="co_enforceSize"/>   
  private String fullName;
  
  @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", 
          message="Invalid email address.") //<co id="co_emailPattern"/>
  private String email;  
  //<end id="java_SpitterValidated" /> 

  private boolean updateByEmail;
  
  public Spitter(String username,
		  String password,
		  String fullName,
		  String email,
		  boolean updateByEmail
		  ) {
	  this.username = username;
	  this.password = password;
	  this.fullName = fullName;
	  this.email = email;
	  this.updateByEmail = updateByEmail;
  }
  
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFullName() {
    return fullName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name="email")
  public String getEmail() {
    return email;
  }

  public void setUpdateByEmail(boolean updateByEmail) {
    this.updateByEmail = updateByEmail;
  }

  public boolean isUpdateByEmail() {
    return updateByEmail;
  }

  public List<Spittle> getRecentSpittles() {
    Spittle spittle = new Spittle();
    spittle.setId(999L);
    spittle.setSpitter(this);
    spittle.setText("TEST SPITTLE #99");
    spittle.setWhen(new Date());
    return asList(spittle);
  }
  
  // plumbing
  @Override
  public boolean equals(Object obj) {
    return reflectionEquals(this, obj);
  }
  
  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }
  
  @Override
  public String toString() {
    return reflectionToString(this);
  }
}
