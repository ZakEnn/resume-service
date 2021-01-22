package com.zakenn.resume.controller;

import com.zakenn.resume.dto.ResumeDto;
import com.zakenn.resume.repository.Resume;
import com.zakenn.resume.repository.ResumeRepository;
import com.zakenn.resume.service.ResumeService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CommonsLog
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @GetMapping("/resumes")
    private ResponseEntity<Flux<Resume>> getAllResumes() {
        Flux<Resume> resumes = resumeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(resumes);
    }

    @GetMapping("/resumes/{id}")
    private ResponseEntity<Mono<Resume>> getAllResumes(@PathVariable  String id) {
        Mono<Resume> resume = resumeService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(resume);
    }
    @PostMapping("/store-cv")
    private ResponseEntity<Mono<Resume>> storeResume(@RequestBody ResumeDto resumeDto) {
        log.info(resumeDto);
        Mono<Resume> storedResume = resumeService.storeResume(resumeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(storedResume);
    }
}
