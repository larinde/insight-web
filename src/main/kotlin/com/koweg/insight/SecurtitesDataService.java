package com.koweg.insight;

import com.koweg.insight.domain.data.DgsConstants;
import com.koweg.insight.domain.data.types.StockAlert;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import graphql.Scalars;

import java.util.List;

@DgsComponent
public class SecurtitesDataService {

  //@DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.GetAllStockAlerts)
  @DgsQuery
  public List<StockAlert> getAllStockAlerts(){
    System.out.println("############### stock alerts ###################");
    return stockAlertRepository;
  }

  private List<StockAlert> stockAlertRepository = List.of(
          new StockAlert("1","BNGO",100,5.23,7.15),
          new StockAlert("2","CS",100,5.00,6.37)
  );
}
