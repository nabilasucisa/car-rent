package enigma.car_rent.controller;

import enigma.car_rent.model.User;
import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.PageResponseWrapper;
import enigma.car_rent.utils.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll(@PageableDefault(size = 10) Pageable pageable,
                                    @RequestParam(required = false) String name) {
        Page<User> res = userService.getAll(pageable, name);
        PageResponseWrapper<User> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "FOUND",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        return Res.renderJson(
                userService.getOne(id),
                "FOUND USER BY ID",
                HttpStatus.OK
        );
    }

    @PutMapping("/update")
    public User update(@RequestBody User request) {
        return userService.update(request);
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
