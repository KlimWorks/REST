
package servlets;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import model.Deal;
import utils.DealUtils;

@WebListener
public class ContextListener implements ServletContextListener {
    
    private Map <Integer, Deal> deals;
    
    private Table<String, LocalDate, Integer> dealsTable;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
             
        final ServletContext servletContext =
                servletContextEvent.getServletContext();
        
        deals = new ConcurrentHashMap();
        servletContext.setAttribute("deals", deals);
        
        dealsTable = HashBasedTable.create();
        servletContext.setAttribute("dealsTable", dealsTable);
        
        List<Deal> dealList = DealUtils.generateDeals();
        
        dealList.forEach(deal -> this.deals.put(deal.getId(), deal));
        
        dealList.forEach(deal -> this.dealsTable.put(deal.getName(), deal.getDate(), deal.getId()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }
    
}
