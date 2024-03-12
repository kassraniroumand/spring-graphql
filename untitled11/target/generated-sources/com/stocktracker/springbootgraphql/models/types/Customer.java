package com.stocktracker.springbootgraphql.models.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated(
    value = "com.netflix.graphql.dgs.codegen.CodeGen",
    date = "2024-03-12T13:35:52.232217Z"
)
@com.stocktracker.springbootgraphql.models.Generated
public class Customer {
  private String id;

  private String name;

  private Integer age;

  private String city;

  public Customer() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Customer{" + "id='" + id + "'," +"name='" + name + "'," +"age='" + age + "'," +"city='" + city + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(name, that.name) &&
                            java.util.Objects.equals(age, that.age) &&
                            java.util.Objects.equals(city, that.city);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, name, age, city);
  }

  public static com.stocktracker.springbootgraphql.models.types.Customer.Builder newBuilder() {
    return new Builder();
  }

  @Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T13:35:52.232217Z"
  )
  @com.stocktracker.springbootgraphql.models.Generated
  public static class Builder {
    private String id;

    private String name;

    private Integer age;

    private String city;

    public Customer build() {
                  com.stocktracker.springbootgraphql.models.types.Customer result = new com.stocktracker.springbootgraphql.models.types.Customer();
                      result.id = this.id;
          result.name = this.name;
          result.age = this.age;
          result.city = this.city;
                      return result;
    }

    public com.stocktracker.springbootgraphql.models.types.Customer.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.stocktracker.springbootgraphql.models.types.Customer.Builder name(String name) {
      this.name = name;
      return this;
    }

    public com.stocktracker.springbootgraphql.models.types.Customer.Builder age(Integer age) {
      this.age = age;
      return this;
    }

    public com.stocktracker.springbootgraphql.models.types.Customer.Builder city(String city) {
      this.city = city;
      return this;
    }
  }
}
