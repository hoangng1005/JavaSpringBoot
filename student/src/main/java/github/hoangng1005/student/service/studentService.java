package github.hoangng1005.student.service;

import github.hoangng1005.student.model.student;
import github.hoangng1005.student.repository.studentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class studentService {
    private final studentRepository studentRepo;

    public studentService(studentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<student> getStudent(){
        return studentRepo.findAll();
    }

    public void addStudent(student stu) {
        Optional<student> studentOptional = studentRepo.findStudentByEmail(stu.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email is taken");
        }
        studentRepo.save(stu);
    }

    public void deleteStudentById(Long studentId) {
        boolean existStudentId = studentRepo.existsById(studentId);
        if(!existStudentId){
            throw new IllegalStateException("student with " + studentId + " does not exist");
        }
        studentRepo.deleteById(studentId);
    }

    @Transactional
    public void updateStudentById(Long studentId, String name, String email){
        student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("id not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            student.setEmail(email);
        }

    }
}
