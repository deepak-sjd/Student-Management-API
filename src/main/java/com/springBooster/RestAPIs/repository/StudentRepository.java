package com.springBooster.RestAPIs.repository;

import com.springBooster.RestAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //  @Repository is not required depends on you
public interface StudentRepository extends JpaRepository<Student,Long> {

// Repository Layer is help to access all types of query
    // we can also create custom query like getStudentByStudentPhone() similar
    // but so many query predefine  repository in jpa database
}
