package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {

    @PostMapping
    public String create(@RequestBody @Valid Student student){
        return "create student";
    }

    @GetMapping("/{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId){
        return "read student";
    }

    @PutMapping("/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){
        return "update student";
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Integer studentId){
        return "delete student";
    }

}
