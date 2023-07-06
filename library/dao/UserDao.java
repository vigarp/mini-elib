package library.dao;

import java.util.ArrayList;
import java.util.List;

import library.model.User;
import library.service.BaseDao;

public class UserDao implements BaseDao<User, Integer> {
  List<User> users = new ArrayList<>();

  @Override
  public void save(User data) {
    users.add(data);
  }

  @Override
  public void update(Integer id, User data) {
    users.set(id - 1, data);
  }

  @Override
  public void remove(Integer id) {
    users.remove(id - 1);
  }

  @Override
  public List<User> findAll() {
    return this.users;
  }

  @Override
  public User findById(Integer id) {
    return users.get(id - 1);
  }

}
