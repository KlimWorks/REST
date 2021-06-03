
package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Table;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/deals/*")
public class RestServlet extends HttpServlet{
    
    private Table<String, LocalDate, Integer> dealsTable;
    
    @Override
    public void init() throws ServletException {
        
        final Object dealTable = getServletContext().getAttribute("dealsTable");
        this.dealsTable = (Table<String, LocalDate, Integer>) dealTable;
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
    
        String pathInfo = request.getPathInfo();
        String[] parts = pathInfo.split("/");
        
        String param1 = parts[1];
        String param2 = parts[2];
        String param3 = parts[3];
        
        final String name = param1;
        LocalDate startDate = LocalDate.parse(param2, DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US));
        final LocalDate endDate = LocalDate.parse(param3, DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US));
        
        request.setCharacterEncoding("UTF-8");
        
        ArrayList<Integer> anotherJsonDeal = new ArrayList<>();
        
        while(endDate.isAfter(startDate)){
            if(dealsTable.get(name, startDate) != null){
            anotherJsonDeal.add(dealsTable.get(name, startDate));
            }
            startDate = startDate.plusDays(1);
        }      
        
        final String jsonDeal = new ObjectMapper().writeValueAsString(anotherJsonDeal);
        
        response.setContentType("application/json; charset = UTF-8");
        
        PrintWriter out = response.getWriter();
        out.write(jsonDeal);
    
}

}
