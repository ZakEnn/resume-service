package com.zakenn.resume.service;

import com.zakenn.resume.dto.ResumeDto;
import com.zakenn.resume.repository.Resume;
import com.zakenn.resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ResumeService {
    @Autowired
    ResumeRepository resumeRepository;

    public Flux<Resume> getAll() {
        Flux<Resume> resumes = resumeRepository.findAll();
        resumes.subscribe();
        return resumes;
    }

    public Mono<Resume> getById(String id) {
        Mono<Resume> resume =  resumeRepository.findById(id);
        resume.subscribe();
        return resume;
    }

    public Mono<Resume> storeResume(ResumeDto resumeDto) {
        Resume resume =  new Resume();
        resume.setId(resumeDto.getResumeId());
        resume.setResume(resumeDto.getResumeB64());
        Mono<Resume> resumeSaved = resumeRepository.save(resume);
        resumeSaved.subscribe();
        return resumeSaved;
    }
}
