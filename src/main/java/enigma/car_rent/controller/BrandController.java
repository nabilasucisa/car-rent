package enigma.car_rent.controller;

import enigma.car_rent.model.Brand;
import enigma.car_rent.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public Brand create(@RequestBody Brand request) {
        return brandService.create(request);
    }

    @GetMapping
    public Page<Brand> getAll(Pageable pageable, String name) {
        return brandService.getAll(pageable, name);
    }

    @GetMapping("/{id}")
    public Brand getOne(@PathVariable Integer id) {
        return brandService.getOne(id);
    }

    @PutMapping
    public Brand update(@RequestBody Brand requset) {
        return brandService.update(requset);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        brandService.delete(id);
    }
}
