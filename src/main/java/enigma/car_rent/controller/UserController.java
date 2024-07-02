package enigma.car_rent.controller;

import enigma.car_rent.model.User;
import enigma.car_rent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User create(@RequestBody User request) {
        return userService.create(request);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Integer id) {
        return userService.getOne(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User requset) {
        return userService.update(requset);
    }

    @PutMapping("/topup/{id}")
    public User topup(@PathVariable Integer id, @RequestBody User balance) {
        return userService.topup(id, balance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}
