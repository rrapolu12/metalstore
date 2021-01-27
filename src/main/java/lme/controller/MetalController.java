package lme.controller;

import lme.model.Metal;
import lme.repository.MetalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/metal")
class MetalController {
  @Autowired
  private MetalRepository repository;

  @GetMapping("/{id}")
  ResponseEntity<Metal> getMetal(@PathVariable Long id) {
    Metal metal = repository.findOne(id);
      if (metal == null) {
        return ResponseEntity.notFound().build();
      }

      return ResponseEntity.ok().body(metal);
  }

  @PostMapping()
  ResponseEntity<?> createMetal(@RequestBody Metal metal) {
    if (metal == null) {
      return ResponseEntity.badRequest().body(null);
    }

    Metal result = repository.save(
            new Metal(
                    metal.getWarehouse(),
                    metal.getRegion(),
                    metal.getLocation(),
                    metal.getFacility(),
                    metal.getStatus()));
    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest().path("/{id}")
      .buildAndExpand(result.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/{id}")
  ResponseEntity<?> deleteMetal(@PathVariable Long id) {
    Metal metal = repository.findOne(id);
    if (metal == null) {
      return ResponseEntity.notFound().build();
    }

    repository.delete(metal);

    return ResponseEntity.ok().build();
  }
}
