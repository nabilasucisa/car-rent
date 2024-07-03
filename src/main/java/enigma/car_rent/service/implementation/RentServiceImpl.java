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

import java.time.Duration;
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

        if (car.getAvailable()) {
            newRent.setCar(car);
            newRent.setUser(user);
            newRent.setCompleted(false);
            newRent.setStarted_at(request.getStarted_at());
            newRent.setEnds_at(request.getEnds_at());
            // Calculate the time difference in milliseconds
            long diffInMillis = request.getEnds_at().getTime() - request.getStarted_at().getTime();
            // Convert the difference to days
            long diffInDays = diffInMillis / 86400000;
            // Set the price based on the number of days
            newRent.setPrice((int) (diffInDays * car.getPrice()));
            car.setAvailable(false);
            return rentRepository.save(newRent);
        } else {
            throw new RuntimeException("Car not Available");
        }
    }

    @Override
    public List<Rent> getAll() {
        return rentRepository.findAll();
    }

    @Override
    public Rent getOne(Integer id) {
        return rentRepository.findById(id).orElse(null);
    }

    @Override
    public Rent update(Integer id, RentDTO request) {
        Rent updateRent = this.getOne(id);
        Car car = carService.getOne(request.getCar_id());
        updateRent.setStarted_at(request.getStarted_at());
        updateRent.setEnds_at(request.getEnds_at());
        int diff = Math.toIntExact(request.getEnds_at().getTime() - request.getStarted_at().getTime());
        diff = diff / 86400000;
        updateRent.setPrice(diff * car.getPrice());
        return rentRepository.save(updateRent);
    }

    @Override
    public Rent returned(Integer id) {
        Rent rent = this.getOne(id);
        Date now = new Date();
        long diffInMillis = now.getTime() - rent.getEnds_at().getTime();
        int diffInDays = Math.toIntExact(diffInMillis / 86400000);

        if (now.after(rent.getEnds_at())) {
            Integer balanceNow = rent.getPrice();
            Integer penalty = balanceNow * diffInDays * 10 / 100;
            Integer balanceReturned = balanceNow + penalty;
            rent.setPrice(balanceReturned);
            rent.getCar().setAvailable(true);
            rent.setCompleted(true);
            return rentRepository.save(rent);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        rentRepository.deleteById(id);
    }
}
