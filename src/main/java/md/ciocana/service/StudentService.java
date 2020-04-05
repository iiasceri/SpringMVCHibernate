package md.ciocana.service;

import md.ciocana.model.Student;

import java.util.List;

public interface StudentService {
    void createStudent(Student student);
    List<Student> getAllStudents();
}
