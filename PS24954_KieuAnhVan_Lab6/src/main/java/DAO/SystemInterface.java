package DAO;

import java.util.List;

public interface  SystemInterface<E,K> {
	boolean insert(E entity);
	boolean update(E entity);
	boolean delete(E entity);
	List<E> getAll();
	E findById(K key);
}
