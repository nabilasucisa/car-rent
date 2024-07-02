package enigma.car_rent.service.implementation;

import enigma.car_rent.model.Brand;
import enigma.car_rent.model.User;
import enigma.car_rent.repository.UserRepository;
import enigma.car_rent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User requset) {
        return userRepository.save(requset);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User update(User request) {
        User user = this.getOne(request.getId());
        user.setName(request.getName());
        user.setBalance(request.getBalance());
        return userRepository.save(user);
    }

    @Override
    public User topup(Integer id, User balance) {
        User user = this.getOne(id);
        user.setBalance(user.getBalance() + balance.getBalance());
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
