package services;

import entities.Technology;
import repositories.TechnologyRepository;

import java.util.List;

public class TechnologyService {
    private TechnologyRepository repository;

    public TechnologyService(TechnologyRepository repository) {
        this.repository = repository;
    }

    public void addTechnology(Technology technology) {
        repository.add(technology);
    }

    public List<Technology> getAllTechnologies() {
        return repository.getAll();
    }
}