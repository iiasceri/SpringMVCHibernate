package md.ciocana.dao.impl;

import lombok.RequiredArgsConstructor;
import md.ciocana.dao.StudentDAO;
import md.ciocana.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Component
//Only for SQL (Without any logic besides Where)
public class StudentDAOImpl implements StudentDAO {

    private final SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT student FROM Student student", Student.class)
                .getResultList();
    }

    @Override
    public int save(Student student) {
        return (int) sessionFactory.getCurrentSession().save(student);
    }
}
