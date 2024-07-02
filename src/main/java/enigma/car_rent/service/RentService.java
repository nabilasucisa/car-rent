package enigma.car_rent.service;

import enigma.car_rent.model.Car;
import enigma.car_rent.model.Rent;
import enigma.car_rent.utils.DTO.CarDTO;
import enigma.car_rent.utils.DTO.RentDTO;

import java.util.List;

public interface RentService {
    Rent create(RentDTO request);
    List<Rent> getAll();
    Rent getOne(Integer id);
    Rent update(Integer id, RentDTO request);
    Rent returned(Integer id, Rent completed);
    void delete(Integer id);
}
