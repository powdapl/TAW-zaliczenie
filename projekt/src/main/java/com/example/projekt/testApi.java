package com.example.projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
public class testApi {

    @Autowired
    private SubjectDatabase subjectDatabase;

    @GetMapping("v1")
    public String test(){return "test";}

    @PostMapping(value = "subjects",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addSubject(@RequestBody Subject subject){
        subjectDatabase.addSubject(subject);
    }

    @GetMapping(value = "subjects",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subject> getSubjects(
            @Nullable @RequestParam("ects") Integer ects,
            @Nullable @RequestParam("name") String name,
            @Nullable @RequestParam("sala") Integer sala,
            @Nullable @RequestParam("egzamin") String egzamin

            ){
        return subjectDatabase.getSubjectList(ects,name,sala,egzamin);
    }
     @GetMapping(value = "subjects/{id}",
     consumes=MediaType.APPLICATION_JSON_VALUE,
     produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSubjectsById(@PathVariable("id") Integer id) {
        Subject subject = subjectDatabase.getSubjectById(id);
        if (subject == null) {
            return ResponseEntity.notFound().build();
           // return ResponseEntity(HttpStatusCode.valueOf(code 404));
        }
        return ResponseEntity.ok(subject);
    }

    @DeleteMapping(value = "subjects",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSubjects(){
        subjectDatabase.deleteAll();
    }
@DeleteMapping(value="subjects/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        if (subjectDatabase.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
}
}
