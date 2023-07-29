package com.example.projekt;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")

public class SubjectDatabase {
    private List<Subject> subjectList = new ArrayList<>();
    private int SubjectCounter=1;
    public void addSubject(Subject subject){
        subject.setId(SubjectCounter);
        subjectList.add(subject);
        SubjectCounter++;
    }
    public List<Subject> getSubjectList (Integer ects, String name, Integer sala, String egzamin) {
        if (ects == null && name == null && sala == null && egzamin ==null) {
            return subjectList;
        }
            List<Subject> filteredSubjects = new ArrayList<>();
            for (Subject subject : subjectList) {
                if (sala == null && subject.getEgzamin().equals(egzamin)) {
                    filteredSubjects.add(subject);
                } else if (egzamin==null && subject.getSala().equals(sala)) {
                    filteredSubjects.add(subject);
                } else if (subject.getSala().equals(sala) && subject.getEgzamin().equals(egzamin)) {
                    filteredSubjects.add(subject);
                }
            }
            return filteredSubjects;
    }
    public void deleteAll() {
        subjectList.clear();
    }
    public Subject getSubjectById(Integer id) {
        for (Subject element:subjectList) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }
    public boolean deleteById(Integer id) {
        Subject subjectToDelete= null;
        for (Subject element:subjectList) {
            if (element.getId().equals(id)) {
                subjectToDelete=element;
            }
        }
        if (subjectToDelete == null) {
            return false;
        }
        subjectList.remove(subjectToDelete);
            return true;
    }
}
