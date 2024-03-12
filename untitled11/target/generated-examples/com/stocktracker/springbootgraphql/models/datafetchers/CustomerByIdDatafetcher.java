package com.stocktracker.springbootgraphql.models.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.stocktracker.springbootgraphql.models.types.Customer;
import graphql.schema.DataFetchingEnvironment;
import javax.annotation.processing.Generated;

@Generated(
    value = "com.netflix.graphql.dgs.codegen.CodeGen",
    date = "2024-03-12T13:35:52.232217Z"
)
@com.stocktracker.springbootgraphql.models.Generated
@DgsComponent
public class CustomerByIdDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "customerById"
  )
  public Customer getCustomerById(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
