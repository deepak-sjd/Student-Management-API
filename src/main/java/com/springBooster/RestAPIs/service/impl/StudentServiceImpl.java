package com.springBooster.RestAPIs.service.impl;

import com.springBooster.RestAPIs.repository.StudentRepository;
import com.springBooster.RestAPIs.dto.StudentDto;
import com.springBooster.RestAPIs.entity.Student;
import com.springBooster.RestAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
//@RequiredArgsConstructor // it create constructor and noArsConstructor if you declared StudentRepository or ModelMapper final
//@RequiredArgsConstructor // its work if you declared final ModelMapper or StudentRepository
public class StudentServiceImpl implements StudentService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private StudentRepository studentRepository;

//    public StudentServiceImpl(StudentRepository studentRepository){
//        this.studentRepository = studentRepository;
//    } // @RequiredArgConstructor is also create constructor of all private in this class

    @Override
    public StudentDto createStudents(Student student) {
        Student saved = studentRepository.save(student);
        return mapper.map(saved, StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> list = studentRepository.findAll();
        return list.stream().map(student ->
                new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getPhone(),
                        student.getAddress(),
                        student.getState(),
                        student.getCity(),
                        student.getHostelName(),
                        student.getBranch(),
                        student.getSemester(),
                        student.getCollageName()
                )).toList();
    }

    @Override
    public StudentDto getSingleStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found on given id"));
        // here we used Model mapper to return student data in studentDto format form StudentDto
        // to map with StudentDto class

        StudentDto studentDto = mapper.map(student, StudentDto.class);
        return studentDto;
    }


    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student does not exists by id: " + id);
        }
        studentRepository.deleteById(id);
    }


    @Override
    public StudentDto updateStudentDetails(Long id, Student updatedStudent) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found on given Id"));

        // this is short form to update table
//        mapper.map(updatedStudent,student);
//        student = studentRepository.save(student);
//        return mapper.map(student,StudentDto.class);

        //    update fields this is a long method used ModelMapper to easily update table
        student.setHostelName(updatedStudent.getHostelName());
        student.setName(updatedStudent.getName());
        student.setPhone(updatedStudent.getPhone());
        student.setState(updatedStudent.getState());
        student.setEmail(updatedStudent.getEmail());
        student.setSemester(updatedStudent.getSemester());
        student.setCity(updatedStudent.getCity());
        student.setBranch(updatedStudent.getBranch());
        student.setCollageName(updatedStudent.getCollageName());
        student.setAddress(updatedStudent.getAddress());

        Student savedDetails = studentRepository.save(student);
        return mapper.map(savedDetails, StudentDto.class);
    }


    @Override
    public void deleteAllStudent() {
        studentRepository.deleteAll();
    }


// here we only update email and name you can update anything according to conditions
    @Override
    public StudentDto updatePartialDetails(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student does not found on given Id" + id));

        updates.forEach((field, value) -> {
            switch (field) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return mapper.map(savedStudent,StudentDto.class);
    }
}
