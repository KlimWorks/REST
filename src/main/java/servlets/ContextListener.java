/*
Данный класс устанавливает данные для контекста 
приложения, делая их доступными для всех остальных классов.
*/

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
    
    //Простая карта. Ключ - это номер сделки, значение - сама сделка
    private Map <Integer, Deal> deals;
    
    //Карта с двумя ключами - именем агента в сделке и датой. Значение - номер сделки
    private Table<String, LocalDate, Integer> dealsTable;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
             
        //Создание переменной контекста
        final ServletContext servletContext =
                servletContextEvent.getServletContext();
        
        //Устанавливаем в переменную контекста атрибут "deals" с ссылкой на поле deals данного класса
        deals = new ConcurrentHashMap();
        servletContext.setAttribute("deals", deals);
        
        //Аналогично, устанавливаем в переменную контекста атрибут "dealsTable"
        dealsTable = HashBasedTable.create();
        servletContext.setAttribute("dealsTable", dealsTable);
        
        //Обращаемся к классу DealUtils и получаем данные о сделках
        List<Deal> dealList = DealUtils.generateDeals();
        
        //Добавляем данные о сделках в мапу deals данного класса
        dealList.forEach(deal -> this.deals.put(deal.getId(), deal));
        
        //Аналогично, добавляем данные о сделках в структуру dealsTable
        dealList.forEach(deal -> this.dealsTable.put(deal.getName(), deal.getDate(), deal.getId()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }
    
}
