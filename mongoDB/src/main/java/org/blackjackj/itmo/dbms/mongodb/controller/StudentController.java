package org.blackjackj.itmo.dbms.mongodb.controller;

import org.blackjackj.itmo.dbms.mongodb.service.DAOService;
import org.blackjackj.itmo.dbms.mongodb.service.StudentsGenerator;
import org.blackjackj.itmo.dbms.mongodb.transport.StudentTO;
import org.blackjackj.itmo.dbms.mongodb.transport.builder.StudentTOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentsGenerator generatorService;
    private final StudentTOBuilder studentTOBuilder;
    private final DAOService daoService;

    @Autowired
    public StudentController(StudentsGenerator generatorService,
                             StudentTOBuilder studentTOBuilder,
                             DAOService daoService) {
        this.generatorService = generatorService;
        this.studentTOBuilder = studentTOBuilder;
        this.daoService = daoService;
    }

    @ResponseBody
    @PostMapping("/empty/generate")
    public ResponseEntity<StudentTO> generateEmpty() {
        return ResponseEntity.ok(
                studentTOBuilder.buildTOFromEntity(generatorService.generateAndSaveEmptyStudent())
        );
    }

    @ResponseBody
    @PostMapping("/generate")
    public ResponseEntity<StudentTO> generate() {
        return ResponseEntity.ok(
                studentTOBuilder.buildTOFromEntity(generatorService.generateAndSaveStudent())
        );
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<StudentTO>> getStudents() {
        return ResponseEntity.ok(
                daoService.getStudents().stream().map(studentTOBuilder::buildTOFromEntity).collect(Collectors.toList())
        );
    }

}
