package org.jt.finalsms.controller;

import java.util.List;

import org.jt.finalsms.dto.StudentRequestDto;
import org.jt.finalsms.model.Student;
import org.jt.finalsms.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private StudentService studentService;

    @GetMapping
    public List<Student> students() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student student(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/roll/{roll}")
    public ResponseEntity<?> studentByRoll(@PathVariable int roll) {
        var optionalStudent = studentService.getStudentByRoll(roll);

        if (optionalStudent.isPresent())
            return new ResponseEntity<>(optionalStudent.get(), HttpStatusCode.valueOf(200));
        else
            return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student saveStudent(@RequestBody StudentRequestDto dto) {
        var student = new Student();
        BeanUtils.copyProperties(dto, student);
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student removeStudent(@PathVariable String id) {
        return studentService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student updateStudent(@PathVariable String id, @RequestBody StudentRequestDto dto) {
        var student = new Student();
        BeanUtils.copyProperties(dto, student);
        return studentService.updateStudent(id, student);
    }
}
