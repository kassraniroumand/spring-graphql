package com.stocktracker.springbootgraphql.models;

import java.lang.String;

@javax.annotation.processing.Generated(
    value = "com.netflix.graphql.dgs.codegen.CodeGen",
    date = "2024-03-12T13:35:52.232217Z"
)
@Generated
public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  @javax.annotation.processing.Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T13:35:52.232217Z"
  )
  @Generated
  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String Customers = "customers";

    public static final String CustomerById = "customerById";

    @javax.annotation.processing.Generated(
        value = "com.netflix.graphql.dgs.codegen.CodeGen",
        date = "2024-03-12T13:35:52.232217Z"
    )
    @Generated
    public static class CUSTOMERBYID_INPUT_ARGUMENT {
      public static final String Id = "id";
    }
  }

  @javax.annotation.processing.Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T13:35:52.232217Z"
  )
  @Generated
  public static class MUTATION {
    public static final String TYPE_NAME = "Mutation";

    public static final String CreateCustomer = "createCustomer";

    public static final String UpdateCustomer = "updateCustomer";

    public static final String DeleteCustomer = "deleteCustomer";

    @javax.annotation.processing.Generated(
        value = "com.netflix.graphql.dgs.codegen.CodeGen",
        date = "2024-03-12T13:35:52.232217Z"
    )
    @Generated
    public static class CREATECUSTOMER_INPUT_ARGUMENT {
      public static final String Input = "input";
    }

    @javax.annotation.processing.Generated(
        value = "com.netflix.graphql.dgs.codegen.CodeGen",
        date = "2024-03-12T13:35:52.232217Z"
    )
    @Generated
    public static class UPDATECUSTOMER_INPUT_ARGUMENT {
      public static final String Id = "id";

      public static final String Input = "input";
    }

    @javax.annotation.processing.Generated(
        value = "com.netflix.graphql.dgs.codegen.CodeGen",
        date = "2024-03-12T13:35:52.232217Z"
    )
    @Generated
    public static class DELETECUSTOMER_INPUT_ARGUMENT {
      public static final String Id = "id";
    }
  }

  @javax.annotation.processing.Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T13:35:52.232217Z"
  )
  @Generated
  public static class CUSTOMER {
    public static final String TYPE_NAME = "Customer";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Age = "age";

    public static final String City = "city";
  }

  @javax.annotation.processing.Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T13:35:52.232217Z"
  )
  @Generated
  public static class DELETERESPONSE {
    public static final String TYPE_NAME = "DeleteResponse";

    public static final String Id = "id";

    public static final String Status = "status";
  }

  @javax.annotation.processing.Generated(
      value = "com.netflix.graphql.dgs.codegen.CodeGen",
      date = "2024-03-12T13:35:52.232217Z"
  )
  @Generated
  public static class CUSTOMERINPUT {
    public static final String TYPE_NAME = "CustomerInput";

    public static final String Name = "name";

    public static final String Age = "age";

    public static final String City = "city";
  }
}
