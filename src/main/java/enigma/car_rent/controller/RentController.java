package enigma.car_rent.controller;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Car;
import enigma.car_rent.model.Rent;
import enigma.car_rent.service.RentService;
import enigma.car_rent.utils.DTO.CarDTO;
import enigma.car_rent.utils.DTO.RentDTO;
import enigma.car_rent.utils.DTO.RentReturnDTO;
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
@RequestMapping ("/rents")
@RequiredArgsConstructor

public class RentController {
    private final RentService rentService;
    @PostMapping
    @Validated
    public ResponseEntity<?> create(@Valid @RequestBody RentDTO request, Errors errors) {
        if (errors.hasErrors()) {
            ErrorResponse<Car> responseData = new ErrorResponse<>();
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setStatus(HttpStatus.BAD_REQUEST);

            return ResponseEntity.status(responseData.getStatus()).body(responseData);
        }

        return ResponseEntity.ok(rentService.create(request));
    }

    @GetMapping
    public ResponseEntity<?> getAll(@PageableDefault(size=10) Pageable pageable) {
        Page<Rent> res = rentService.getAll(pageable);
        PageResponseWrapper<Rent> result = new PageResponseWrapper<>(res);
        return Res.renderJson(
                result,
                "FOUND",
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public Rent getOne(@PathVariable Integer id) {
        return rentService.getOne(id);
    }

    @PutMapping("/update/{id}")
    public Rent update(@PathVariable Integer id, @RequestBody RentDTO request) {
        return rentService.update(id, request);
    }

    @PutMapping("/return")
    public Rent returned(@RequestBody RentReturnDTO completed) {
        return rentService.returned(completed);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        rentService.delete(id);
    }

}
