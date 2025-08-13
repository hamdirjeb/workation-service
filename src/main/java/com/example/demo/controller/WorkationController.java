package com.example.demo.controller;

import com.example.demo.dto.WorkationDto;
import com.example.demo.service.WorkationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/workflex/workation")
public class WorkationController {


    private final WorkationService service;

    public WorkationController(WorkationService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<WorkationDto> save(@RequestBody WorkationDto workationDto) {
        return ResponseEntity.ok(service.save(workationDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<WorkationDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


}
