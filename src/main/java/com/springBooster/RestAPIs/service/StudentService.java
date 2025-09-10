package com.springBooster.RestAPIs.service;

import com.springBooster.RestAPIs.dto.StudentDto;
import com.springBooster.RestAPIs.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    //============== Here we create all method =======================

    List<StudentDto>getAllStudents();

     StudentDto createStudents(Student student);

    StudentDto getSingleStudentById(Long id);

    void deleteStudentById(Long id);

    StudentDto updateStudentDetails(Long id,Student updatedStudent);

    void deleteAllStudent();

    StudentDto updatePartialDetails(Long id, Map<String,Object>updates);
}
