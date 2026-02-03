package com.springboot.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.restapi.entity.Student;
import com.springboot.restapi.repisotory.studentRpisotory;

@RestController
@RequestMapping("/students") // Préfixe commun pour toutes les routes
public class studentControler {

    // Dependency Injection
    @Autowired
    private studentRpisotory studentRepository;

    // GET /students → tous les étudiants
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET /students/{id} → un étudiant par id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST /students/add → créer un nouvel étudiant
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // PATCH /students/{id} → mettre à jour un ou plusieurs champs
    @PatchMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Student s = optionalStudent.get();

        if (updatedStudent.getNom() != null) {
            s.setNom(updatedStudent.getNom());
        }
        if (updatedStudent.getPercentage() != 0) {
            s.setPercentage(updatedStudent.getPercentage());
        }
        if (updatedStudent.getBranche() != null) {
            s.setBranche(updatedStudent.getBranche());
        }

        Student savedStudent = studentRepository.save(s);
        return ResponseEntity.ok(savedStudent);
    }
    
    
    @DeleteMapping("/delets/{id}")
    public void removeStudent(@PathVariable int id ) {
    	Student stundent = studentRepository.findById(id).orElse(null);
    	studentRepository.delete(stundent);
    }
}
