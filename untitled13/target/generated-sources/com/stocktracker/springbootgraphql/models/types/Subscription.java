package com.stocktracker.springbootgraphql.models.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated(
    value = "com.netflix.graphql.dgs.codegen.CodeGen",
    date = "2024-03-12T17:21:10.672718Z"
)
@com.stocktracker.springbootgraphql.models.Generated
public class Subscription {
  private CustomerEvent customerEvents;

  public Subscription() {
  }

  public CustomerEvent getCustomerEvents() {
    return customerEvents;
  }

  public void setCustomerEvents(CustomerEvent customerEvents) {
    this.customerEvents = customerEvents;
  }

  @Override
  public String toString() {
    return "Subscription{" + "customerEvents='" + customerEvents + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return java.util.Objects.equals(customerEvents, that.customerEvents);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(customerEvents);
  }

  public static com.stocktracker.springbootgraphql.models.types.Subscription.Builder newBuilder() {
    return new Builder();
  }

  @Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T17:21:10.672718Z"
  )
  @com.stocktracker.springbootgraphql.models.Generated
  public static class Builder {
    private CustomerEvent customerEvents;

    public Subscription build() {
      com.stocktracker.springbootgraphql.models.types.Subscription result = new com.stocktracker.springbootgraphql.models.types.Subscription();
          result.customerEvents = this.customerEvents;
          return result;
    }

    public com.stocktracker.springbootgraphql.models.types.Subscription.Builder customerEvents(
        CustomerEvent customerEvents) {
      this.customerEvents = customerEvents;
      return this;
    }
  }
}
