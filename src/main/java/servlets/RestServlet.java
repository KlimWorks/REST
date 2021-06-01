
package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Deal;

@WebServlet(urlPatterns = "/deals/*")
public class RestServlet extends HttpServlet{
    
    private Map <Integer, Deal> deals;
    
    
    @Override
    public void init() throws ServletException {
        
        final Object deal = getServletContext().getAttribute("deals");
        this.deals = (ConcurrentHashMap<Integer, Deal>) deal;
        
    }

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
    
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        String param1 = parts[1];
        
        int dealId = Integer.parseInt(param1);
        
        req.setCharacterEncoding("UTF-8");
        
        final Deal deal = deals.get(dealId);
        final String jsonDeal = new ObjectMapper().writeValueAsString(deal);
        
        resp.setContentType("text/HTML; charset=UTF-8");
        resp.setStatus(200);
        
        PrintWriter out = resp.getWriter();
        out.write(jsonDeal);
    
}

}
