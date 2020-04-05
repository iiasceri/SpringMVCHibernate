package md.ciocana.service.impl;

import lombok.RequiredArgsConstructor;
import md.ciocana.dao.StudentDAO;
import md.ciocana.model.Student;
import md.ciocana.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
//Logic (Business Layer)
//Example .filterBy
//        .orderBy
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Override
    public void createStudent(Student student) {
        studentDAO.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }
}
