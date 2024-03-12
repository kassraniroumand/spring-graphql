package com.stocktracker.springbootgraphql.models.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.stocktracker.springbootgraphql.models.types.Customer;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "com.netflix.graphql.dgs.codegen.CodeGen",
    date = "2024-03-12T17:21:10.672718Z"
)
@com.stocktracker.springbootgraphql.models.Generated
@DgsComponent
public class Customers2Datafetcher {
  @DgsData(
      parentType = "Query",
      field = "customers2"
  )
  public List<Customer> getCustomers2(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
