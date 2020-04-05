package md.ciocana.controller;

import lombok.RequiredArgsConstructor;
import md.ciocana.dto.StudentDTO;
import md.ciocana.model.Group;
import md.ciocana.model.Student;
import md.ciocana.service.StudentService;
import md.ciocana.service.GroupService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;
    private final GroupService groupService;

    @GetMapping(value = "/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping(value = "/saveStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentName(studentDTO.getStudentName());
        student.setStudentAge(studentDTO.getStudentAge());
        Optional<Group> optionalGroup = groupService.getGroupById(studentDTO.getGroupId());
        if (optionalGroup.isPresent()) {
            student.setGroup(optionalGroup.get());
        }
        else {
            throw new IllegalArgumentException("There is no such group with id:" + studentDTO.getGroupId());
        }
        studentService.createStudent(student);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> showAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return ResponseEntity.ok().body(studentList);
    }
}
