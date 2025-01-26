package com.api.heroes;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    public static void main(String[] args) {
        // Nombre de la clase base
        String className = "Reservation"; // Cambia esto por el nombre de la entidad que necesites

        // Generar los archivos en las carpetas correspondientes
        try {
            generateModel(className);
            generateRepository(className);
            generateService(className);
            generateController(className);
            System.out.println("Archivos generados exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al generar los archivos: " + e.getMessage());
        }
    }

    private static void generateModel(String className) throws IOException {
        String folder = "src/main/java/com/api/heroes/models";
        String content = """
                package com.api.heroes.models;

                import jakarta.persistence.Entity;
                import jakarta.persistence.Table;
                import jakarta.persistence.Id;
                import jakarta.persistence.GeneratedValue;
                import jakarta.persistence.GenerationType;
                import lombok.Getter;
                import lombok.Setter;
                
                @Setter
                @Getter
                @Entity
                @Table(name = "%s")
                public class %sModel {
                    @Id
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    private Long id;
                }
                """.formatted(className.toLowerCase(), className);

        writeFile(folder, className + "Model.java", content);
    }

    private static void generateRepository(String className) throws IOException {
        String folder = "src/main/java/com/api/heroes/repositories";
        String content = """
                package com.api.heroes.repositories;

                import com.api.heroes.models.%s;
                import org.springframework.data.jpa.repository.JpaRepository;

                public interface I%sRepository extends JpaRepository<%sModel, Long> {
                }
                """.formatted(className+"Model", className, className);

        writeFile(folder, "I" + className + "Repository.java", content);
    }

    private static void generateService(String className) throws IOException {
        String folder = "src/main/java/com/api/heroes/services";
        String content = """
                package com.api.heroes.services;

                import com.api.heroes.models.%s;
                import com.api.heroes.repositories.I%sRepository;
                import org.springframework.beans.factory.annotation.Autowired;
                import org.springframework.stereotype.Service;

                import java.util.List;
                import java.util.Optional;

                @Service
                public class %sService {
                    @Autowired
                    private I%sRepository repository;

                    public List<%sModel> getAll() {
                        return repository.findAll();
                    }

                    public Optional<%sModel> getById(Long id) {
                        return repository.findById(id);
                    }

                    public %sModel create(%sModel entity) {
                        return repository.save(entity);
                    }

                    public void delete(Long id) {
                        repository.deleteById(id);
                    }

                    public %sModel update(Long id, %sModel entity) {
                        entity.setId(id);
                        return repository.save(entity);
                    }
                }
                """.formatted(className+"Model", className, className, className, className, className, className, className, className, className);

        writeFile(folder, className + "Service.java", content);
    }

    private static void generateController(String className) throws IOException {
        String folder = "src/main/java/com/api/heroes/controllers";
        String content = """
                package com.api.heroes.controllers;

                import com.api.heroes.models.%sModel;
                import com.api.heroes.services.%sService;
                import org.springframework.beans.factory.annotation.Autowired;
                import org.springframework.web.bind.annotation.*;

                import java.util.List;
                import java.util.Optional;

                @RestController
                @RequestMapping("/%s")
                public class %sController {
                    @Autowired
                    private %sService service;

                    @GetMapping
                    public List<%sModel> getAll() {
                        return service.getAll();
                    }

                    @GetMapping("/{id}")
                    public Optional<%sModel> getById(@PathVariable Long id) {
                        return service.getById(id);
                    }

                    @PostMapping
                    public %sModel create(@RequestBody %sModel entity) {
                        return service.create(entity);
                    }

                    @DeleteMapping("/{id}")
                    public void delete(@PathVariable Long id) {
                        service.delete(id);
                    }

                    @PutMapping("/{id}")
                    public %sModel update(@PathVariable Long id, @RequestBody %sModel entity) {
                        return service.update(id, entity);
                    }
                }
                """.formatted(className, className, className.toLowerCase(), className, className, className, className, className, className, className, className);

        writeFile(folder, className + "Controller.java", content);
    }

    private static void writeFile(String folder, String fileName, String content) throws IOException {
        File dir = new File(folder);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir, fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
    }
}