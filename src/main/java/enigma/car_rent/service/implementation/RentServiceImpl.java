package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.Car;
import enigma.car_rent.model.Rent;
import enigma.car_rent.model.User;
import enigma.car_rent.repository.RentRepository;
import enigma.car_rent.service.CarService;
import enigma.car_rent.service.RentService;
import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.DTO.RentDTO;
import enigma.car_rent.utils.DTO.RentReturnDTO;
import enigma.car_rent.utils.specification.BrandSpecification;
import enigma.car_rent.utils.specification.RentSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;


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
        Integer diff = Math.toIntExact(request.getEnds_at().getTime() - request.getStarted_at().getTime());
        diff = diff / 86400000;
        newRent.setPrice(diff * car.getPrice());
        car.setAvailable(false);
        return rentRepository.save(newRent);
    }

    @Override
    public Page<Rent> getAll(Pageable pageable, Boolean completed) {
        Specification<Rent> spec = RentSpecification.getSpecification(completed);
        return rentRepository.findAll(spec, pageable);
    }

    @Override
    public Rent getOne(Integer id) {
        return rentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("rent with id " + id + " not found"));
    }

    @Override
    public Rent update(Integer id, RentDTO request) {
        Rent updateRent = this.getOne(id);
        Car car = carService.getOne(request.getCar_id());
        User user = userService.getOne(request.getUser_id());
        updateRent.setCar(car);
        updateRent.getCar().setAvailable(false);
        updateRent.setUser(user);
        updateRent.setStarted_at(request.getStarted_at());
        updateRent.setEnds_at(request.getEnds_at());
        Integer diff = Math.toIntExact(request.getEnds_at().getTime() - request.getStarted_at().getTime());
        diff = diff / 86400000;
        updateRent.setPrice(diff * car.getPrice());
        return rentRepository.save(updateRent);
    }

    @Override
    public Rent returned(RentReturnDTO completed) {
        Rent returnRent = this.getOne(completed.getId());
        User user = returnRent.getUser();
        Integer diff = Math.toIntExact(completed.getReturn_at().getTime() - returnRent.getEnds_at().getTime());
        diff = diff / 86400000;
        if (diff > 0) {
            System.out.println(user.getBalance());
            Integer penalty = (int) ((returnRent.getCar().getPrice() * diff)
                                + (0.1 * diff * returnRent.getPrice()));
            Integer finalBalance = (int) (user.getBalance()
                    - returnRent.getPrice()
                    - penalty);
            returnRent.getUser().setBalance(finalBalance);
            System.out.println(user.getBalance());
            System.out.println(returnRent.getPrice());
            System.out.println(penalty);
            System.out.println(diff);
        } else if (diff <= 0){
            Integer finalBalance = (int) (user.getBalance() - returnRent.getPrice());
            returnRent.getUser().setBalance(finalBalance);
        }
        returnRent.setCompleted(true);
        returnRent.getCar().setAvailable(true);
        return rentRepository.save(returnRent);
    }

    @Override
    public void delete(Integer id) {
        rentRepository.deleteById(id);
    }
}
