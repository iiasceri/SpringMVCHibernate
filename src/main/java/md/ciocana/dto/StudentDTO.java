package md.ciocana.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class StudentDTO {
    private String studentName;
    private int studentAge;
    private int groupId;
}
