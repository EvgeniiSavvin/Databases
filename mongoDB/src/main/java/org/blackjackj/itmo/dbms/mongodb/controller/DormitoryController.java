package org.blackjackj.itmo.dbms.mongodb.controller;

import org.blackjackj.itmo.dbms.mongodb.entity.Dormitory;
import org.blackjackj.itmo.dbms.mongodb.service.DAOService;
import org.blackjackj.itmo.dbms.mongodb.service.DormitoryGenerator;
import org.blackjackj.itmo.dbms.mongodb.transport.DormitoryTO;
import org.blackjackj.itmo.dbms.mongodb.transport.builder.DormitoryTOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryGenerator dormitoryGenerator;

    @Autowired
    private DAOService daoService;

    @Autowired
    private DormitoryTOBuilder dormitoryTOBuilder;

    @ResponseBody
    @PostMapping("/generate")
    public ResponseEntity<List<DormitoryTO>> generateDormitories() {
        return ResponseEntity.ok(getTOsFromEntities(dormitoryGenerator.generateDormitories()));
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<DormitoryTO>> getDormitories() {
        return ResponseEntity.ok(getTOsFromEntities(daoService.getDormitories()));
    }

    private List<DormitoryTO> getTOsFromEntities(List<Dormitory> dormitories) {
        return dormitories.stream().map(dormitoryTOBuilder::buildTOFromEntity).collect(Collectors.toList());
    }

}
