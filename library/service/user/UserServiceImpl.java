package library.service.user;

import java.util.List;

import library.dao.UserDao;
import library.model.User;

public class UserServiceImpl implements UserService {
  UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public void createUser(User user) {
    if (user.getEmail() == "" || user.getPassword() == "") {
      throw new IllegalArgumentException("Email or password is required!");
    }
    // save ke db
    userDao.save(user);
  }

  @Override
  public List<User> getUsers() {
    List<User> users = userDao.findAll();
    if (users.size() == 0) {
      System.out.println("User is empty!");
      return null;
    } else {
      return users;
    }
  }

  @Override
  public void updateUser(Integer id, User user) {
    User userFind = userDao.findById(id);
    if (userFind == null) {
      throw new NullPointerException("ID is not found!");
    }

    // update
    if (user.getEmail() != "") {
      userFind.setEmail(user.getEmail());
    }
    if (user.getFullname() != "") {
      userFind.setFullname(user.getFullname());
    }
    if (user.getPassword() != "") {
      userFind.setPassword(user.getPassword());
    }

    // save ke db
    userDao.update(id, userFind);
  }

}
