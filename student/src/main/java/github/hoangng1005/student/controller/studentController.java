package github.hoangng1005.student.controller;

import github.hoangng1005.student.model.student;
import github.hoangng1005.student.service.studentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/student")
public class studentController {
    private final studentService service;

    public studentController(studentService service) {
        this.service = service;
    }

    @GetMapping
    public List<student> getStudent(){
        return service.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody student stu){
        service.addStudent(stu);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        service.deleteStudentById(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId")Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email)
    {
        service.updateStudentById(studentId, name, email);
    }

}
