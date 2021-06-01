
package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Table;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import static java.time.LocalDate.parse;
import java.util.ArrayList;
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
    
    private Table<String, LocalDate, Integer> dealsTable;
    
    
    @Override
    public void init() throws ServletException {
        
        final Object deal = getServletContext().getAttribute("deals");
        this.deals = (ConcurrentHashMap<Integer, Deal>) deal;
        
        final Object dealTable = getServletContext().getAttribute("dealsTable");
        this.dealsTable = (Table<String, LocalDate, Integer>) dealTable;
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        //final String id = request.getParameter("id"); // это было ранее
        
        final String name = request.getParameter("name");
        
        LocalDate startDate = parse(request.getParameter("start_date"));
        final LocalDate endDate = parse(request.getParameter("end_date"));
        
        // final Integer deal_number = dealsTable.get(name, startDate); 
        
        ArrayList<Integer> anotherJsonDeal = new ArrayList<>();
        
        while(endDate.isAfter(startDate)){
            anotherJsonDeal.add(dealsTable.get(name, startDate));
            startDate = startDate.plusDays(1);
        }
                
        //final Deal deal = deals.get(Integer.parseInt(id)); // это было ранее
               
        final String jsonDeal = new ObjectMapper().writeValueAsString(anotherJsonDeal);
        
        response.setContentType("application/json; charset = UTF-8");
        PrintWriter out = response.getWriter();
        out.write(jsonDeal);
    }
    
}
