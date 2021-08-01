package com.maison.onYoutube.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentControl {

    private final StudentService studentService;

    @Autowired
    public StudentControl(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void createStudent(@RequestBody Student student) throws Exception {
        studentService.addNewStudent(student);

    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    /**
     * "api/v1/student/999?name=maison&email=maisonwangsh@gmail.com"
     * 获取url里的999参数, 使用@PathVariable,
     * 获取url里的问号?后面的参数, 使用@RequestParam
     */
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

//    @GetMapping
//    public List<Student> getStudents() {
//        return List.of(new Student(
//                1L,
//                "maison",
//                "maisonwangsh@gmail.com",
//                LocalDate.of(2000, Month.NOVEMBER, 07),
//                21
//        ));
//    }

}
