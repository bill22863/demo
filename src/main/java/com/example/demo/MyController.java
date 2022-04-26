package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id,
                       @RequestParam String name){
        System.out.println("id : " + id + ", name : " + name);
        return "hello test";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student){
        System.out.println("id : " + student.getId());
        System.out.println("name : " + student.getName());
        return "hello test2";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader(name = "Content-Type") String info){
        System.out.println("header info : " + info);
        return "hello test3";
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id,
                        @PathVariable String name){
        System.out.println("path id : " + id);
        System.out.println("path name : " + name);
        return "hello test4";
    }


    @RequestMapping("/test5")
    public ResponseEntity<String> test5(){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Response Entity Demo");
    }

    @RequestMapping("/test6")
    public ResponseEntity<Student> test6(@RequestParam Integer id){
        Student student = new Student();
        student.setId(id);
        student.setName("小明");
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(student);
    }

    @RequestMapping("/test7")
    public String test7(){
        throw new RuntimeException("test7 error");
    }

    @RequestMapping("/test8")
    public String test8() {
        throw new IllegalArgumentException("test8 error");
    }

    @RequestMapping("/test9")
    public String test9(){
        System.out.println("執行 test9 方法");
        return  "Hello test9";
    }

    @RequestMapping("/test10")
    public String test10() {
        System.out.println("執行 test10 方法");
        return  "Hello test10";
    }

    /*@RequestMapping("/product")
    public Cart product(){
        Cart cart = new Cart();
        cart.add("蘋果");
        cart.add("香蕉");
        cart.setProductList(cart.getProductList());
        return cart;
    }

    @RequestMapping("/user")
    public Student user(){
        Student student = new Student();
        student.setName("John");
        return student;
    }*/

}
