package md.ciocana.dao;

import md.ciocana.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    int save(Student student);
}
