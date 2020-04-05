package md.ciocana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_age")
    private int studentAge;

    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonIgnore
    private Group group;

//    @Override
//    public String toString() {
//        return "Student{" +
//                "studentId=" + studentId +
//                ", studentName='" + studentName + '\'' +
//                ", studentAge=" + studentAge +
//                ", groupId=" + group.getGroupId() +
//                '}';
//    }
}
