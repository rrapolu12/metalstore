package lme.controller;

import lme.model.Metal;
import lme.repository.MetalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/warehouses")
class MetalCollectionController {
  @Autowired
  private MetalRepository repository;

  @GetMapping()
  ResponseEntity<List<Metal>> getMetals() {
    final List<Metal> metalList = new ArrayList<>();
    final Iterable<Metal> all = repository.findAll();
    all.forEach(metalList::add);
    return ResponseEntity.ok().body(metalList);
  }
}
