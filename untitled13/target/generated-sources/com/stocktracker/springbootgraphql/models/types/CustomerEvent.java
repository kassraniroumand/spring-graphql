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
public class CustomerEvent {
  private String id;

  private Action action;

  public CustomerEvent() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return "CustomerEvent{" + "id='" + id + "'," +"action='" + action + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEvent that = (CustomerEvent) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(action, that.action);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, action);
  }

  public static com.stocktracker.springbootgraphql.models.types.CustomerEvent.Builder newBuilder() {
    return new Builder();
  }

  @Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T17:21:10.672718Z"
  )
  @com.stocktracker.springbootgraphql.models.Generated
  public static class Builder {
    private String id;

    private Action action;

    public CustomerEvent build() {
                  com.stocktracker.springbootgraphql.models.types.CustomerEvent result = new com.stocktracker.springbootgraphql.models.types.CustomerEvent();
                      result.id = this.id;
          result.action = this.action;
                      return result;
    }

    public com.stocktracker.springbootgraphql.models.types.CustomerEvent.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.stocktracker.springbootgraphql.models.types.CustomerEvent.Builder action(
        Action action) {
      this.action = action;
      return this;
    }
  }
}
