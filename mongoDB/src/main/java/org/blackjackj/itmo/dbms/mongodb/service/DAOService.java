package org.blackjackj.itmo.dbms.mongodb.service;

import org.blackjackj.itmo.dbms.mongodb.entity.Dormitory;
import org.blackjackj.itmo.dbms.mongodb.entity.Student;
import org.blackjackj.itmo.dbms.mongodb.repository.DormitoryRepository;
import org.blackjackj.itmo.dbms.mongodb.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DAOService {

    private final StudentRepository studentRepository;

    private final DormitoryRepository dormitoryRepository;

    public DAOService(StudentRepository studentRepository,
                      DormitoryRepository dormitoryRepository) {
        this.studentRepository = studentRepository;
        this.dormitoryRepository = dormitoryRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<Dormitory> getDormitories() {
        return dormitoryRepository.findAll();
    }

}
