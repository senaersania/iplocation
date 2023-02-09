package com.example.demo.util.objectmapper;

import com.example.demo.models.objectmapper.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ObjectMapperService {
    public void mapper(){
        String json = "{ \"name\":\"David\", \"position\":\"SOFTWARE_ENGINEER\", \"skilltree\":[ \"Java\", \"Python\", \"JavaScript\" ], \"address\":{ \"street\":\"Street\", \"streetNo\":\"123\" } }";
        System.out.println("employee : "+ json);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Employee employee = objectMapper.readValue(json, Employee.class);
            System.out.println("DTO : " + employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
