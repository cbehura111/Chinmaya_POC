package com.chinmaya.code.test;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition
@RequestMapping("/person-mgmt")
@RestController
@Slf4j
public class PersonController {

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Integer id) {
        Person rsesult = new Person(1,"");
        return ResponseEntity.ok(rsesult).status(HttpStatus.OK).build();
    }
}
