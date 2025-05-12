package org.cg.greetingappdevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class GreetingAppDevelopmentApplication {
    private final GreetingsRepository greetingsRepository;
    public GreetingAppDevelopmentApplication(GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    @PostMapping
    public Greetings greet(@RequestBody User user) {
        Greetings greetings = new Greetings();
        greetings.setMessage(user.getFirstName(),user.getLastName());
        return greetingsRepository.save(greetings);
    }

    @GetMapping
    public List<Greetings> getAllGreetings() {
        return greetingsRepository.findAll();
    }

    @PutMapping("/{id}")
    public Greetings updateGreetings(@PathVariable long id, @RequestBody User updatedGreetings) {
        return greetingsRepository.findById(id).map(Greetings ->{
            Greetings.setMessage(updatedGreetings.getFirstName(),updatedGreetings.getLastName());
            greetingsRepository.save(Greetings);
            return ResponseEntity.ok(Greetings);
        }).orElseGet(() -> ResponseEntity.notFound().build()).getBody();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGreetings(@PathVariable long id) {
        if(greetingsRepository.existsById(id)) {
            greetingsRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        greetingsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllGreetings() {
        if (greetingsRepository.count() == 0) {
            return ResponseEntity.ok("No greetings to delete.");
        }
        greetingsRepository.deleteAll();
        return ResponseEntity.ok("Deleted all greetings");
    }

    @GetMapping("/countRows")
    public ResponseEntity<Long> countRows() {
        return ResponseEntity.ok(greetingsRepository.count());
    }

    public static void main(String[] args) {
        SpringApplication.run(GreetingAppDevelopmentApplication.class, args);
    }

}
