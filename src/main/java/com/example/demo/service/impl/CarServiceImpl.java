package com.example.demo.service.impl;

import com.example.demo.controller.resources.CarResource;
import com.example.demo.mapper.CarMapper.CAR_MAPPER;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class CarServiceImpl implements CarService{
    private final CarRepository subjectRepository;
    //private final TeacherRepository teacherRepository;

    @Override
    public List<CarResource> findAll() {
        return CAR_MAPPER.toSubjectResources(subjectRepository.findAll());
    }

    @Override
    public CarResource getById(long id) {
        return CAR_MAPPER.toSubjectResource(subjectRepository.getReferenceById(id));
    }

    @Override
    public SubjectResource save(SubjectResource resource) {
        Subject subject = SUBJECT_MAPPER.fromSubjectResource(resource);
        subject.setTeachers(null);

        return SUBJECT_MAPPER.toSubjectResource(subjectRepository.save(subject));
    }

    @Override
    public SubjectResource update(SubjectResource resource, long id) {
        Subject toUpdate = subjectRepository.getReferenceById(id);
        toUpdate.setName(resource.getName());

        return SUBJECT_MAPPER.toSubjectResource(subjectRepository.save(toUpdate));
    }

    @Override
    public Optional<Subject> getSubjectByName(String name) {
        return subjectRepository.getSubjectsByName(name);
    }

    @Override
    public void delete(long id) {
        teacherRepository.findAllBySubject_Id(id).forEach(this::removeSubject);
        subjectRepository.deleteById(id);
    }

    private void removeSubject(Teacher teacher) {
        teacher.setSubject(null);
        teacherRepository.save(teacher);
    }
}
