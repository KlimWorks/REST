
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
