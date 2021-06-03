/*
Данный сервлет выполняется при отправке данных формы на странице StartPage.jsp
и демонстрирует работу простого web-приложения. Получает от клиента информацию
об имени агента в сделке и периоде сделок и отправляет список соответствующих сделок
в json-формате.
*/

package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Table;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import static java.time.LocalDate.parse;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/getjson")
public class JsonConvertServlet extends HttpServlet{
        
    private Table<String, LocalDate, Integer> dealsTable;
    
    @Override
    public void init() throws ServletException {
        
        //Получение данных из контекста и передача их в структуру dealsTable
        final Object dealTable = getServletContext().getAttribute("dealsTable");
        this.dealsTable = (Table<String, LocalDate, Integer>) dealTable;
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        //Получение данных из формы
        final String name = request.getParameter("name");
        LocalDate startDate = parse(request.getParameter("start_date"));
        final LocalDate endDate = parse(request.getParameter("end_date"));
        
        //Создание списка номеров сделок
        ArrayList<Integer> anotherJsonDeal = new ArrayList<>();
        
        //Заполнение списка на основании данных из формы
        while(endDate.isAfter(startDate)){
            if(dealsTable.get(name, startDate) != null){
            anotherJsonDeal.add(dealsTable.get(name, startDate));
            }
            startDate = startDate.plusDays(1);
        
        }
        
        //Представление списка номеров сделок в json-формате
        final String jsonDeal = new ObjectMapper().writeValueAsString(anotherJsonDeal);
        
        //Установление параметров ответа
        response.setContentType("application/json; charset = UTF-8");
        PrintWriter out = response.getWriter();
        out.write(jsonDeal);
    }
    
}
