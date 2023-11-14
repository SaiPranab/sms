package org.jt.finalsms.service;

import java.util.List;
import java.util.Optional;

import org.jt.finalsms.model.Student;
import org.jt.finalsms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(String id) {
        // return studentRepository.findById(id).orElseThrow();
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Optional<Student> getStudentByRoll(int roll) {
        return studentRepository.findByRoll(roll);
    }

    public Student deleteById(String id) {
        var student = getStudent(id);
        studentRepository.delete(student);
        return student;
    }

    public Student updateStudent(String id, Student newStudent) {
        if (!studentRepository.existsById(id))
            throw new RuntimeException("Student not found");

        newStudent.setId(id);
        return studentRepository.save(newStudent);
    }
}
