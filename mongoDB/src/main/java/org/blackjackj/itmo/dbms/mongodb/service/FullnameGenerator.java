package org.blackjackj.itmo.dbms.mongodb.service;

import org.blackjackj.itmo.dbms.mongodb.config.StudentsProperties;
import org.blackjackj.itmo.dbms.mongodb.entity.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FullnameGenerator {

    @Autowired
    private StudentsProperties studentsProperties;

    public String generateFullname(Sex sex) {
        List<String> names;
        List<String> sureNames;
        List<String> middleNames;
        switch (sex) {
            case MALE: {
                names = studentsProperties.getMaleNames();
                sureNames = studentsProperties.getMaleSurenames();
                middleNames = studentsProperties.getMaleMiddlenames();
                break;
            }
            case FEMALE: {
                names = studentsProperties.getFemaleNames();
                sureNames = studentsProperties.getFemaleSurenames();
                middleNames = studentsProperties.getFemaleMiddlenames();
                break;
            }
            default: {
                throw new IllegalStateException("UNKNOWN SEX");
            }
        }
        Random rand = new Random();
        String name = names.get(rand.nextInt(names.size()));
        String surename = sureNames.get(rand.nextInt(sureNames.size()));
        String middleName = middleNames.get(rand.nextInt(middleNames.size()));
        return String.format("%s %s %s", surename, name, middleName);
    }

}
