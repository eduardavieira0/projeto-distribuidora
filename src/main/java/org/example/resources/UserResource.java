package org.example.resources;

import org.example.entities.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> findByID(@PathVariable Long id){
        return userService.findID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public User create(@RequestBody User user){
        return userService.insert(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        return userService.findID(id)
                .map(existingUser -> {
                    user.setIdUser((existingUser.getIdUser()));
                    return ResponseEntity.ok(userService.insert(user));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return userService.findID(id)
                .map(existingUser -> {
                    userService.deleteID(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
