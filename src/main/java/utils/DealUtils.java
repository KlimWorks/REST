
package utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import model.Deal;

public class DealUtils {
    
    public static List<Deal> generateDeals(){
        
        final Deal deal1 = new Deal(345, "Alex", LocalDate.of(2021, Month.MAY, 1));
        final Deal deal2 = new Deal(346, "Alex", LocalDate.of(2021, Month.MAY, 2));
        final Deal deal3 = new Deal(347, "Bob", LocalDate.of(2021, Month.MAY, 2));
        final Deal deal4 = new Deal(348, "Alex", LocalDate.of(2021, Month.MAY, 3));
        final Deal deal5 = new Deal(349, "Bob", LocalDate.of(2021, Month.MAY, 5));
        final Deal deal6 = new Deal(350, "Alex", LocalDate.of(2021, Month.MAY, 6));
        
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
