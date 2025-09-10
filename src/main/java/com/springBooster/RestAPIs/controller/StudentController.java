package com.springBooster.RestAPIs.controller;

import com.springBooster.RestAPIs.dto.StudentDto;
import com.springBooster.RestAPIs.entity.Student;
import com.springBooster.RestAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
//@RequiredArgsConstructor
public class StudentController {

  //  @Autowired // you can use one in both @Autowired field inject or Constructor dependencies to inject
    @Autowired // we can also create constructor
    private StudentService studentService;

//    public StudentController(StudentService studentService){
//        this.studentService = studentService;
//    }

    @PostMapping
    public ResponseEntity<String>createStudents(@Valid @RequestBody Student student){
        studentService.createStudents(student);
        return new ResponseEntity<>("Student data inserted successfully",HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<StudentDto>>getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto>getStudentById(@PathVariable Long id){
       StudentDto student =studentService.getSingleStudentById(id);
       return new ResponseEntity<>(student,HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteStudentById(@PathVariable Long id){
         studentService.deleteStudentById(id);
         return new ResponseEntity<>("student deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentDetails(@PathVariable Long id,
                                                      @Valid @RequestBody Student studentRequest){
        StudentDto updated = studentService.updateStudentDetails(id,studentRequest);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<String>deleteAll(){
        studentService.deleteAllStudent();
        return new ResponseEntity<>("all student records deleted",HttpStatus.OK);
    }

    // patchMapping used partial update not full data only some small update for whole data update we used putMapping
    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updateSmallDetails(@PathVariable Long id, @Valid @RequestBody Map<String,Object> updates){
        return new ResponseEntity<>(studentService.updatePartialDetails(id,updates),HttpStatus.OK);

    }

}
