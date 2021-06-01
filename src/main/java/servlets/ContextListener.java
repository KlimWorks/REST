
package servlets;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import model.Deal;
import org.apache.commons.collections4.map.MultiKeyMap;
import utils.DealUtils;

@WebListener
public class ContextListener implements ServletContextListener {
    
    private Map <Integer, Deal> deals;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
             
        final ServletContext servletContext =
                servletContextEvent.getServletContext();
        
        deals = new ConcurrentHashMap();
        servletContext.setAttribute("deals", deals);
        
        List<Deal> dealList = DealUtils.generateDeals();
        
        dealList.forEach(deal -> this.deals.put(deal.getId(), deal));
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }
    
}
