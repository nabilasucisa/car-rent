package enigma.car_rent.service.implementation;

import enigma.car_rent.model.User;
import enigma.car_rent.repository.UserRepository;
import enigma.car_rent.service.UserService;
import enigma.car_rent.utils.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User requset) {
        return userRepository.save(requset);
    }

    @Override
    public Page<User> getAll(Pageable pageable, String name) {
        Specification<User> spec = UserSpecification.getSpecification(name);
        return userRepository.findAll(spec, pageable);
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user with id " + id + " not found"));
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
