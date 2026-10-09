package com.library.greets.Service;

import com.library.greets.Model.Students;

public interface IGreet {
     String greet(String name);
    Boolean addStudent(Students stu);
}
