package com.example.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class BlogController {

    private final BlogRepository projectRepository;

    @Autowired
    public BlogController(BlogRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Blog project) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(projectRepository.save(project));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("get-all")
    public ResponseEntity<?> get() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(projectRepository.findAll());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(projectRepository.findById(id).get());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody Blog project) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(projectRepository.save(project));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            projectRepository.deleteById(id);
            return ResponseEntity.ok().body("Project with id: " + id + " deleted");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
