package enigma.car_rent.service;

import enigma.car_rent.model.User;

import java.util.List;

public interface UserService {
    User create(User requset);
    List<User> getAll();
    User getOne(Integer id);
    User update(User request);
    User topup(Integer id, User balance);
    void delete(Integer id);
}
