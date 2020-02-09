package edu.northeastern.cs5200.controllers;


import edu.northeastern.cs5200.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    HelloRepository helloRepository;

    @RequestMapping("/api/hello/insert")
    public HelloObject insertHelloObject() {
        HelloObject obj = new HelloObject("Hello Attinder!");
        helloRepository.save(obj);
        return obj;
    }


    @RequestMapping("/api/hello/insert/{msg}")
    public HelloObject insertMessage(@PathVariable("msg") String message) {
        HelloObject obj = new HelloObject(message);
        helloRepository.save(obj);
        return obj;
    }


    @RequestMapping("/api/hello/select/all")
    public List<HelloObject> selectAllHelloObjects() {
        List<HelloObject> hellos = helloRepository.findAll();
        return hellos;
    }


}

