package org.jt.finalsms.repository;

import java.util.Optional;

import org.jt.finalsms.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByRoll(int roll);
}
