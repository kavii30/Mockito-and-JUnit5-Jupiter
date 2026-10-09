package com.library.greets.Service;

import com.library.greets.Model.Students;
import org.springframework.stereotype.Service;

import java.time.LocalTime;


@Service
public class Greet implements IGreet{

    public String greet(String name){

        LocalTime time =LocalTime.now();
        int hour = time.getHour();
        if(hour<12){
            return "good Morning "+name;
        }
        else if(hour<16){
            return "good afternoon "+name;
        }
        else if(hour<20){
            return "good evening "+name;
        }
        else{
            return "good night ";
        }
    }

    @Override
    public Boolean addStudent(Students stu) {
        System.out.println(stu);
        return true;
    }
}
