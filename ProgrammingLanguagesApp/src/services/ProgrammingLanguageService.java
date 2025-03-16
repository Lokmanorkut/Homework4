package services;

import entities.ProgrammingLanguage;
import repositories.ProgrammingLanguageRepository;

import java.util.List;

public class ProgrammingLanguageService {
    private ProgrammingLanguageRepository repository;

    public ProgrammingLanguageService(ProgrammingLanguageRepository repository) {
        this.repository = repository;
    }

    public void addProgrammingLanguage(ProgrammingLanguage language) {
        repository.add(language);
    }

    public List<ProgrammingLanguage> getAllLanguages() {
        return repository.getAll();
    }
}