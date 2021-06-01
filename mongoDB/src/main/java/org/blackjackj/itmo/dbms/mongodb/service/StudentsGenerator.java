package org.blackjackj.itmo.dbms.mongodb.service;

import org.blackjackj.itmo.dbms.mongodb.entity.EducationForm;
import org.blackjackj.itmo.dbms.mongodb.entity.Sex;
import org.blackjackj.itmo.dbms.mongodb.entity.Student;
import org.blackjackj.itmo.dbms.mongodb.repository.*;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StudentsGenerator {

    private final AttendanceLogRepository attendanceLogRepository;
    private final DormitoryRepository dormitoryRepository;
    private final RoomBookingRepository roomBookingRepository;
    private final RoomRepository roomRepository;
    private final StudentRepository studentRepository;
    private final FullnameGenerator fullnameGenerator;


    public StudentsGenerator(AttendanceLogRepository attendanceLogRepository,
                             DormitoryRepository dormitoryRepository,
                             RoomBookingRepository roomBookingRepository,
                             RoomRepository roomRepository,
                             StudentRepository studentRepository,
                             FullnameGenerator fullnameGenerator) {
        this.attendanceLogRepository = attendanceLogRepository;
        this.dormitoryRepository = dormitoryRepository;
        this.roomBookingRepository = roomBookingRepository;
        this.roomRepository = roomRepository;
        this.studentRepository = studentRepository;
        this.fullnameGenerator = fullnameGenerator;
    }

    public Student generateAndSaveEmptyStudent() {
        return studentRepository.save(new Student());
    }

    public Student generateAndSaveStudent() {
        Student student = new Student();
        student.setFullname(fullnameGenerator.generateFullname(getRandomSex()));
        student.setEducationForm(getRandomEducationForm());
        student.setHasPrivileges(getRandomPrivilege());
        return studentRepository.save(student);
    }

    private final static Random rand = new Random();

    private Sex getRandomSex() {
        return Sex.values()[rand.nextInt(Sex.values().length)];
    }

    private EducationForm getRandomEducationForm() {
        return EducationForm.values()[rand.nextInt(EducationForm.values().length)];
    }

    private boolean getRandomPrivilege() {
        return rand.nextBoolean();
    }

}
