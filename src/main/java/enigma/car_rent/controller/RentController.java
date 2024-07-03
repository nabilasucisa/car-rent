package enigma.car_rent.controller;

import enigma.car_rent.model.Rent;
import enigma.car_rent.service.RentService;
import enigma.car_rent.utils.DTO.RentDTO;
import enigma.car_rent.utils.DTO.RentReturnDTO;
import lombok.RequiredArgsConstructor;
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
    public List<Rent> getAll() {
        return rentService.getAll();
    }

    @GetMapping("/{id}")
    public Rent getOne(@PathVariable Integer id) {
        return rentService.getOne(id);
    }

    @PutMapping("/update/{id}")
    public Rent update(@PathVariable Integer id, @RequestBody RentDTO request) {
        return rentService.update(id, request);
    }

    @PutMapping("/return/{id}")
    public Rent returned(@PathVariable Integer id, @RequestBody RentReturnDTO completed) {
        return rentService.returned(id, completed);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        rentService.delete(id);
    }

}
