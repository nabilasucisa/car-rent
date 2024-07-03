package enigma.car_rent.controller;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Rent;
import enigma.car_rent.service.RentService;
import enigma.car_rent.utils.DTO.RentDTO;
import enigma.car_rent.utils.DTO.RentReturnDTO;
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
@RequestMapping ("/rents")
@RequiredArgsConstructor

public class RentController {
    private final RentService rentService;
    @PostMapping
    public Rent create(@RequestBody RentDTO request) {
        return rentService.create(request);
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
