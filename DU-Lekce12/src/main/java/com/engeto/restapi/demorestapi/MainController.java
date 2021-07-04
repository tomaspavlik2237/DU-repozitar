package com.engeto.restapi.demorestapi;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController
{
    DBController dbController = new DBController();

    @PostMapping("/api/students")
    public Student postStudent(@RequestBody Student student)
    {
        return this.dbController.saveToDB(student);
    }

    @GetMapping("/api/students/{studentId}")
    public Student getStudentById(@PathVariable Long studentId)
    {
        return this.dbController.getFromDB(studentId);
    }

    @PutMapping("/api/students/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody Student student)
    {
        this.dbController.updateStudent(studentId, student);
    }

    @DeleteMapping("/api/students/{studentId}")
    public void deleteStudentById(@PathVariable Long studentId)
    {
        this.dbController.deleteStudentFromDB(studentId);
    }
}
