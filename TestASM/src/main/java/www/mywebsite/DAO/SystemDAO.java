package www.mywebsite.DAO;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import www.mywebsite.Utils.JpaUtils;

public class SystemDAO<T>{
	public static  EntityManager ENTITY_MANAGER = JpaUtils.getManagerFactory();
	
	@Override
	protected void finalize() throws Throwable {
		ENTITY_MANAGER.close();
		super.finalize();
	}
	
	public T findById(Class<T> clazz ,Long id) {
		return ENTITY_MANAGER.find(clazz, id);
	}
	
	public List<T> FindAll(Class<T> clazz , Boolean isActive){
		String entityName = clazz.getSimpleName();
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT o FROM ").append(entityName).append("  o ");
		if(isActive) {
			sql.append("  WHERE isActive = 1 ");
		}
		TypedQuery<T> query = ENTITY_MANAGER.createQuery(sql.toString() , clazz);
		return query.getResultList();
	}
	
	
	
	public List<T> FindAll(Class<T> clazz , Boolean isActive, int pageNumber , int pageSize){
		String entityName = clazz.getSimpleName();
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT o FROM ").append(entityName).append("  o ");
		if(isActive) {
			sql.append("  WHERE isActive = 1 ");
		}
		TypedQuery<T> query = ENTITY_MANAGER.createQuery(sql.toString() , clazz);
		query.setMaxResults(pageSize);
		query.setFirstResult((pageNumber - 1) * pageSize);
		return query.getResultList();
	}
	
	public T findOne(Class<T> clazz , String sql , Object...objects ) {
		TypedQuery<T> query = ENTITY_MANAGER.createQuery(sql , clazz);
		for(int i = 0 ; i < objects.length ; i++) {
			query.setParameter(i, objects[i]);
		}
		List<T> result = query.getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}
	
	
	public List<T> findMany(Class<T> clazz , String sql , Object...objects ) {
		try {
			TypedQuery<T> query = ENTITY_MANAGER.createQuery(sql , clazz);
			for(int i = 0 ; i < objects.length ; i++) {
				query.setParameter(i, objects[i]);
			}
			List<T> result = query.getResultList();
			if(result.isEmpty()) {
				return null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public List<Object[]> findManyByNativeQuery( String sql , Object...objects ) {
		Query query = ENTITY_MANAGER.createNativeQuery(sql);
		for(int i = 0 ; i < objects.length ; i++) {
			query.setParameter(i, objects[i]);
		}
		List<Object[]> result = query.getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return result;
	}
	
	public T create(T entity) {
		try {
			ENTITY_MANAGER.getTransaction().begin(); // Bắt đầu Transaction
			ENTITY_MANAGER.persist(entity);
			ENTITY_MANAGER.getTransaction().commit(); // Chấp nhận kết quả thao tác
	
			return entity;
		} catch (Exception e) {
			ENTITY_MANAGER.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	
	public T update(T entity) {
		try {
			ENTITY_MANAGER.getTransaction().begin(); // Bắt đầu Transaction
			ENTITY_MANAGER.merge(entity);
			ENTITY_MANAGER.getTransaction().commit(); // Chấp nhận kết quả thao tác
			System.out.println("update success");
			return entity;
		} catch (Exception e) {
			ENTITY_MANAGER.getTransaction().rollback();
			System.out.println("Failed to update " + entity.getClass().getSimpleName() + "to db");
			throw new RuntimeException(e);
		}
		
	}
	
	public T delete(T entity) {
		try {
			ENTITY_MANAGER.getTransaction().begin(); // Bắt đầu Transaction
			ENTITY_MANAGER.remove(ENTITY_MANAGER.contains(entity) ? entity : ENTITY_MANAGER.merge(entity));
			ENTITY_MANAGER.getTransaction().commit(); // Chấp nhận kết quả thao tác
			System.out.println("remove success");
			return entity;
		} catch (Exception e) {
			ENTITY_MANAGER.getTransaction().rollback();
			System.out.println("Failed to remove " + entity.getClass().getSimpleName() + "to db");
			throw new RuntimeException(e);
		}
	}
	
	public List<T> procedureGetMany(String procName,Map<String, Object> data){
		StoredProcedureQuery query = ENTITY_MANAGER.createNamedStoredProcedureQuery(procName);
		data.forEach((key , value) -> query.setParameter(key , value));
		return (List<T>) query.getResultList();
	}
	
	
}
