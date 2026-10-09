package com.library.greets.Controller;


import com.library.greets.Model.Students;
import com.library.greets.Service.IGreet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCont {
  @Autowired
    private IGreet service;

  @GetMapping("/greet")
    public ResponseEntity<String> getWish(){
      String res =service.greet("Karan");
      return new ResponseEntity<String>(res , HttpStatus.OK);

  }
  @PostMapping("/add")
  public ResponseEntity<String> addStudent(@RequestBody Students data){
    System.out.println(data);
    Boolean status= service.addStudent(data);
    if(status){
      String msg="student data added";
      return new ResponseEntity<>(msg , HttpStatus.OK);
    }
    else{
      String msg ="not added";
      return new ResponseEntity<>(msg , HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }



}
