package com.readlearncode.dukesbookshop.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Author implements Serializable {
  private String id;
  private String firstName;
  private String lasstName;

  public Author(){

  }
  public Author(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Author{" + "id='" + id + '\'' + ", firstName='" + firstName + '\'' + ", lasstName='" + lasstName + '\'' + ", blogURL='" + blogURL + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Author author = (Author) o;
    return Objects.equals(id, author.id) && Objects.equals(firstName, author.firstName) && Objects.equals(lasstName, author.lasstName) &&
        Objects.equals(blogURL, author.blogURL);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lasstName, blogURL);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLasstName() {
    return lasstName;
  }

  public void setLasstName(String lasstName) {
    this.lasstName = lasstName;
  }

  public String getBlogURL() {
    return blogURL;
  }

  public void setBlogURL(String blogURL) {
    this.blogURL = blogURL;
  }

  private String blogURL;
}
