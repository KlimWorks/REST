
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

@WebServlet(urlPatterns = "/getjson")
public class JsonConvertServlet extends HttpServlet{
    
    private Map <Integer, Deal> deals;
    
    
    @Override
    public void init() throws ServletException {
        
        final Object deal = getServletContext().getAttribute("deals");
        this.deals = (ConcurrentHashMap<Integer, Deal>) deal;
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        request.setCharacterEncoding("UTF-8");
        final String id = request.getParameter("id");
        
        final Deal deal = deals.get(Integer.parseInt(id));
               
        final String jsonDeal = new ObjectMapper().writeValueAsString(deal);
        
        response.setContentType("application/json; charset = UTF-8");
        PrintWriter out = response.getWriter();
        out.write(jsonDeal);
    }
    
}
