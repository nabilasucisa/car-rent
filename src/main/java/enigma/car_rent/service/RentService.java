package enigma.car_rent.service;

import enigma.car_rent.model.Rent;
import enigma.car_rent.utils.DTO.RentDTO;
import enigma.car_rent.utils.DTO.RentReturnDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RentService {
    Rent create(RentDTO request);
    Page<Rent> getAll(Pageable pageable);
    Rent getOne(Integer id);
    Rent update(Integer id, RentDTO request);
    Rent returned(RentReturnDTO completed);
    void delete(Integer id);
}
