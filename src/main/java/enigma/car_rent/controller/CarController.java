package enigma.car_rent.controller;

import enigma.car_rent.model.Car;
import enigma.car_rent.model.User;
import enigma.car_rent.service.CarService;
import enigma.car_rent.utils.DTO.CarDTO;
import enigma.car_rent.utils.ErrorResponse;
import enigma.car_rent.utils.PageResponseWrapper;
import enigma.car_rent.utils.Res;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor

public class CarController {
    private final CarService carService;

    @PostMapping
    @Validated
    public ResponseEntity<?> create(@Valid @RequestBody CarDTO request, Errors errors) {
        if (errors.hasErrors()) {
            ErrorResponse<Car> responseData = new ErrorResponse<>();
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(HttpStatus.BAD_REQUEST);

            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        }

        return ResponseEntity.ok(carService.create(request));
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault(size=10) Pageable pageable,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) Boolean available) {
        Page<Car> res = carService.getAll(pageable, name, available);
        PageResponseWrapper<Car> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "FOUND",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Car getOne(@PathVariable Integer id) {
        return carService.getOne(id);
    }

    @PutMapping("/update/{id}")
    public Car update(@PathVariable Integer id, @RequestBody CarDTO request) {
        return carService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        carService.delete(id);
    }
}
