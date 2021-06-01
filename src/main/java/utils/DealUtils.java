
package utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import model.Deal;

public class DealUtils {
    
    public static List<Deal> generateDeals(){
        
        final Deal deal1 = new Deal("Alex", LocalDate.of(2021, Month.MAY, 1), 345);
        final Deal deal2 = new Deal("Alex", LocalDate.of(2021, Month.MAY, 2), 346);
        final Deal deal3 = new Deal("Bob", LocalDate.of(2021, Month.MAY, 2), 347);
        final Deal deal4 = new Deal("Alex", LocalDate.of(2021, Month.MAY, 3), 348);
        final Deal deal5 = new Deal("Bob", LocalDate.of(2021, Month.MAY, 5), 349);
        final Deal deal6 = new Deal("Alex", LocalDate.of(2021, Month.MAY, 6), 350);
        
        List<Deal> deals = new ArrayList<>();
        
        deals.add(deal1);
        deals.add(deal2);
        deals.add(deal3);
        deals.add(deal4);
        deals.add(deal5);
        deals.add(deal6);
        
        return deals;
        
    }
    
  
    
}
