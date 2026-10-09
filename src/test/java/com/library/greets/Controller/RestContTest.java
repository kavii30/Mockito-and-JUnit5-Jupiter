package com.library.greets.Controller;

import com.library.greets.Model.Students;
import com.library.greets.Service.IGreet;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(RestCont.class)
class RestContTest {
    @MockitoBean
    private IGreet service;

    @Autowired
    private MockMvc mockMvc;


    @Test
    @Disabled
    void getWish() throws Exception {
        //Mocking
        Mockito.when(service.greet("suresh")).thenReturn("Good Morning");

        //RequestObject
        // to generate fake http request we use RequestBody
        MockHttpServletRequestBuilder requestBuilder =MockMvcRequestBuilders.get("/greet");
        ResultActions result = mockMvc.perform(requestBuilder);
        MvcResult mvcResult=result.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        int res=response.getStatus();
        //Assertion
        assertEquals(200,res);

    }

    @Test
    void addStudent() throws Exception {

        //Mocking
        Mockito.when(service.addStudent(ArgumentMatchers.any())).thenReturn(true);

        Students student=new Students(1,"Karan","Mumbai");
        ObjectMapper mapper = new ObjectMapper();
        String Jstudent = mapper.writeValueAsString(student);


        //RequestBuilder
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jstudent);
        ResultActions result = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = result.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        int a=response.getStatus();

        //Assertion

        assertEquals(200,a);
    }
}