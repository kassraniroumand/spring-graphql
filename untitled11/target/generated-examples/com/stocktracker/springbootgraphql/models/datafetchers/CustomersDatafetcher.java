package com.stocktracker.springbootgraphql.models.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.stocktracker.springbootgraphql.models.types.Customer;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "com.netflix.graphql.dgs.codegen.CodeGen",
    date = "2024-03-12T12:24:24.050070Z"
)
@com.stocktracker.springbootgraphql.models.Generated
@DgsComponent
public class CustomersDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "customers"
  )
  public List<Customer> getCustomers(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
