
package servlets;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Deal;

@WebServlet(urlPatterns = "/")
public class GetStartPageServlet extends HttpServlet {
    
    private Map <Integer, Deal> deals;

    
    @Override
    public void init() throws ServletException{
        
         final Object deals = getServletContext().getAttribute("deals");  
         this.deals = (ConcurrentHashMap<Integer, Deal>) deals;
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          request.setAttribute("deals", deals.values());
          request.getRequestDispatcher("WEB-INF/View/StartPage.jsp").forward(request, response);
    }
    
}
