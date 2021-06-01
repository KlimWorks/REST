
package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import utils.CustomLocalDateSerializer;

@Data
@AllArgsConstructor
@JsonPropertyOrder({"name", "date", "id"})

public class Deal {
    
    private String name;
    
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    private LocalDate date;
    
    private int id;
   
}
