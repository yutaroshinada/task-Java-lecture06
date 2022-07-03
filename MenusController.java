package com.raisetech.helloworld;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class MenusController {

    @GetMapping("/menus")
    public List<String> getMenus() {
        return List.of("POP CORN", "DRINK");
    }

    @PostMapping("/menus")
    public ResponseEntity<String> createMenu(@RequestBody CreateForm form) {
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/menus/id")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("menu successfully created");
    }

    @PatchMapping("/menus/{id}")
    public ResponseEntity<Map<String, String>> updateMenu(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "menu successfully updated"));
    }

    @DeleteMapping("/menus/{id}")
    public ResponseEntity<Map<String, String>> deleteMenu(@PathVariable("id") int id, @RequestBody DeleteForm form) {
        return ResponseEntity.ok(Map.of("message", "menu successfully deleted"));
    }
}
