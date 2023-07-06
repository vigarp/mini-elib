package library.service;

import java.util.List;

public interface BaseDao<E, ID> {
  void save(E data);

  void update(ID id, E data);

  void remove(ID id);

  List<E> findAll();

  E findById(ID id);
}
