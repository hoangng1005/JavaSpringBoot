package github.hoangng1005.student.repository;

import github.hoangng1005.student.model.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {
    @Query("Select s from student s where s.email = ?1")
    Optional<student> findStudentByEmail(String student);

}
