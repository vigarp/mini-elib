package library.service.user;

import java.util.List;

import library.model.User;

public interface UserService {
  void createUser(User user);

  List<User> getUsers();

  void updateUser(Integer id, User user);
}
