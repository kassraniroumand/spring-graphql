package com.stocktracker.springbootgraphql.models.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import javax.annotation.processing.Generated;

@Generated(
    value = "com.netflix.graphql.dgs.codegen.CodeGen",
    date = "2024-03-12T13:35:52.232217Z"
)
@com.stocktracker.springbootgraphql.models.Generated
public class DeleteResponse {
  private String id;

  private Status status;

  public DeleteResponse() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "DeleteResponse{" + "id='" + id + "'," +"status='" + status + "'" +"}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteResponse that = (DeleteResponse) o;
        return java.util.Objects.equals(id, that.id) &&
                            java.util.Objects.equals(status, that.status);
  }

  @Override
  public int hashCode() {
    return java.util.Objects.hash(id, status);
  }

  public static com.stocktracker.springbootgraphql.models.types.DeleteResponse.Builder newBuilder(
      ) {
    return new Builder();
  }

  @Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T13:35:52.232217Z"
  )
  @com.stocktracker.springbootgraphql.models.Generated
  public static class Builder {
    private String id;

    private Status status;

    public DeleteResponse build() {
                  com.stocktracker.springbootgraphql.models.types.DeleteResponse result = new com.stocktracker.springbootgraphql.models.types.DeleteResponse();
                      result.id = this.id;
          result.status = this.status;
                      return result;
    }

    public com.stocktracker.springbootgraphql.models.types.DeleteResponse.Builder id(String id) {
      this.id = id;
      return this;
    }

    public com.stocktracker.springbootgraphql.models.types.DeleteResponse.Builder status(
        Status status) {
      this.status = status;
      return this;
    }
  }
}
