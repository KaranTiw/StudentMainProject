package com.in.controller;

import com.in.entity.Student;
import com.in.payload.StudentDto;
import com.in.service.StudentService;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {


    private StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;

    }

    @PostMapping("/student")
    public ResponseEntity<?> insertStudent(
           @Valid @RequestBody StudentDto dto,
           BindingResult result

    ) {


        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        StudentDto student = studentService.addStudent(dto);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }






//Delete Mapping


@DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "Student with id " + id + " deleted successfully";

}




@PutMapping("/student/{id}")

    public Student updateStudent(@PathVariable Long id,@RequestBody Student student){

         Student set=studentService.updateStudent(id,student);

        return set;
    }




//
//

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        StudentDto stu = studentService.getStudentById(id);
        return new ResponseEntity<>(stu, HttpStatus.OK);

//
//
//    }

    }
}
