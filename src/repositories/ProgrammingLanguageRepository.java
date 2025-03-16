package repositories;

import entities.ProgrammingLanguage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProgrammingLanguageRepository {
    private List<ProgrammingLanguage> languages = new ArrayList<>();

    public void add(ProgrammingLanguage language) {
        languages.add(language);
    }

    public List<ProgrammingLanguage> getAll() {
        return languages;
    }

    public void delete(int id) {
        Iterator<ProgrammingLanguage> iterator = languages.iterator();
        while (iterator.hasNext()) {
            ProgrammingLanguage language = iterator.next();
            if (language.getId() == id) {
                iterator.remove();
                break;
            }

        }
    }


    public ProgrammingLanguage getById(int id) {
        for (ProgrammingLanguage lang : languages) {
            if (lang.getId() == id) {
                return lang;
            }
        }
        return null;
    }
}