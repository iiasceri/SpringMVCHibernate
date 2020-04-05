package md.ciocana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "groups")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "group_id")
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JsonIgnore
    List<Student> studentList;
}
