package cj.k8s.app.service;


import cj.k8s.app.dto.StudentNameDto;
import cj.k8s.app.entity.Student;
import cj.k8s.app.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    // 전체 이름 조회
    public List<String> getAllStudentNames() {
        return studentRepository.findAll()
                .stream().map(Student::getName).toList();
    }

    // id로 학생 이름 조회
    public String getStudentNameById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return "존재하지 않는 학생 id";
        }
        return student.getName();
    }

    public void addStudent(StudentNameDto dto) {
        Student student = new Student(dto.getName());
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudentName(Long id, StudentNameDto dto) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return;
        }
        student.updateName(dto.getName());
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return;
        }
        studentRepository.delete(student);
    }
}
