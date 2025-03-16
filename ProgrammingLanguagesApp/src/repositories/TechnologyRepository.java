package repositories;

import entities.ProgrammingLanguage;
import entities.Technology;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TechnologyRepository {
    private List<Technology> technologies = new ArrayList<>();

    public void add(Technology technology) {
        technologies.add(technology);
    }

    public List<Technology> getAll() {
        return technologies;
    }

    public void delete(int id) {
        Iterator<Technology> iterator = technologies.iterator();
        while (iterator.hasNext()) {
            Technology tech = iterator.next();
            if (tech.getId() == id) {
                iterator.remove();
                break;
            }

        }
    }

    public Technology getById(int id) {
        for (Technology tech : technologies) {
            if (tech.getId() == id) {
                return tech;
            }
        }
        return null;
    }
}
