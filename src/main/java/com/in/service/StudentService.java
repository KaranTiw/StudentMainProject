package com.in.service;

import com.in.entity.Student;
import com.in.exception.ResourceNotFoundException;
import com.in.payload.StudentDto;
import com.in.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;

    public StudentService(StudentRepository studentRepository, ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public StudentDto addStudent(StudentDto dto) {

        Student student = mapToEntity(dto); // Convert DTO to entity

        Student savedStudent = studentRepository.save(student); // Save entity

        return mapToDto(savedStudent); // Convert saved entity back to DTO


    }








    // Convert StudentDto to Student entity


    public Student mapToEntity(StudentDto dto) {
        return mapper.map(dto, Student.class);
    }



    // Convert Student entity to StudentDto
    public StudentDto mapToDto(Student student) {
        return mapper.map(student, StudentDto.class);
    }

    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }


    public Student updateStudent( Long id,Student student) {

        student.setId(id);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public StudentDto getStudentById(Long id) {

        Student student=studentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Record not found Exception "+id) );

        StudentDto studentDto = mapToDto(student);

    return studentDto;

    }

}
