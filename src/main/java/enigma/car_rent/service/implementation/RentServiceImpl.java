package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Car;
import enigma.car_rent.model.Rent;
import enigma.car_rent.model.User;
import enigma.car_rent.repository.RentRepository;
import enigma.car_rent.service.CarService;
import enigma.car_rent.service.RentService;
import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.DTO.RentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;
    private final CarService carService;
    private final UserService userService;

    @Override
    public Rent create(RentDTO request) {
        Car car = carService.getOne(request.getCar_id());
        User user = userService.getOne(request.getUser_id());
        Rent newRent = new Rent();
        newRent.setCar(car);
        newRent.setUser(user);
        newRent.setCompleted(false);
        newRent.setStarted_at(request.getStarted_at());
        newRent.setEnds_at(request.getEnds_at());
        newRent.setPrice((int) (car.getPrice() * (request.getEnds_at().getTime() - request.getStarted_at().getTime())));
        car.setAvailable(false);
        Rent result = rentRepository.save(newRent);
        return result;
    }

    @Override
    public List<Rent> getAll() {
        return List.of();
    }

    @Override
    public Rent getOne(Integer id) {
        return null;
    }

    @Override
    public Rent update(RentDTO request) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
