package cj.k8s.app.controller;

import cj.k8s.app.dto.StudentNameDto;
import cj.k8s.app.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("")
    public List<String> getStudentsName() {
        return studentService.getAllStudentNames();
    }

    @GetMapping("/{id}")
    public String getStudentNameById(@PathVariable Long id) {
        return studentService.getStudentNameById(id);
    }

    @PostMapping("")
    public void addStudent(@RequestBody StudentNameDto dto) {
        studentService.addStudent(dto);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentNameDto dto) {
        studentService.updateStudentName(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
