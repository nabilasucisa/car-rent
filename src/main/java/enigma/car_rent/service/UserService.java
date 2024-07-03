package enigma.car_rent.service;

import enigma.car_rent.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    User create(User requset);
    Page<User> getAll(Pageable pageable, String name);
    User getOne(Integer id);
    User update(User request);
    User topup(Integer id, User balance);
    void delete(Integer id);
}
