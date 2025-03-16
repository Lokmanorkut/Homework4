package presentation;

import entities.ProgrammingLanguage;
import entities.Technology;
import repositories.ProgrammingLanguageRepository;
import repositories.TechnologyRepository;
import services.ProgrammingLanguageService;
import services.TechnologyService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProgrammingLanguageRepository languageRepo = new ProgrammingLanguageRepository();
        ProgrammingLanguageService languageService = new ProgrammingLanguageService(languageRepo);
        TechnologyRepository techRepo = new TechnologyRepository();
        TechnologyService techService = new TechnologyService(techRepo);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Programming Language");
            System.out.println("2. List Programming Languages");
            System.out.println("3. Add Technology");
            System.out.println("4. List Technologies");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter programming language name: ");
                    String langName = scanner.nextLine();
                    languageService.addProgrammingLanguage(new ProgrammingLanguage(languageRepo.getAll().size() + 1, langName));
                    System.out.println("Programming language added successfully.");
                    break;
                case 2:
                    System.out.println("\nProgramming Languages:");
                    for (ProgrammingLanguage lang : languageService.getAllLanguages()) {
                        System.out.println(lang.getId() + " - " + lang.getName());
                    }
                    break;
                case 3:
                    System.out.print("Enter technology name: ");
                    String techName = scanner.nextLine();
                    System.out.println("Select a programming language:");
                    for (ProgrammingLanguage lang : languageService.getAllLanguages()) {
                        System.out.println(lang.getId() + " - " + lang.getName());
                    }
                    System.out.print("Enter programming language ID: ");
                    int langId = scanner.nextInt();
                    scanner.nextLine();
                    ProgrammingLanguage selectedLang = languageService.getAllLanguages().stream().filter(l -> l.getId() == langId).findFirst().orElse(null);
                    if (selectedLang != null) {
                        techService.addTechnology(new Technology(techRepo.getAll().size() + 1, techName, selectedLang));
                        System.out.println("Technology added successfully.");
                    } else {
                        System.out.println("Invalid programming language ID.");
                    }
                    break;
                case 4:
                    System.out.println("\nTechnologies:");
                    for (Technology tech : techService.getAllTechnologies()) {
                        System.out.println(tech.getId() + " - " + tech.getName() + " (Language: " + tech.getProgrammingLanguage().getName() + ")");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
