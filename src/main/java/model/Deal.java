/*
Deal - это простой Java-класс, представляющий
единственную сущность данного приложения.
Поля класса включают в себя имя агента в сделке (name), 
дату совершения сделки (date) и ее номер (id).

Аннотации @Data и @AllArgsConstructor предоставлены библиотекой lombok и 
позволяют автоматически и неявно создавать геттеры и сеттеры для полей класса.

Для простоты приложения, данные для сделок предоставляются классом
DealUtils.java из пакета utils, единственный метод которого возвращает список
сделок.
*/


package model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Deal {
    
    private String name;
    
    private LocalDate date;
    
    private int id;
   
}
