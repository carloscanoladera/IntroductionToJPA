package mislugares.jpa.servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mislugares.jpa.modelo.Lugar;

public class MisLugaresServicioImpl implements MisLugaresServicio {

	EntityManager entityManager;

	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LugarUnit");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	public MisLugaresServicioImpl() {

		entityManager = getEntityManager();
	}

	@Override
	public Lugar createLugar(Lugar lugar) {
		// TODO Auto-generated method stub

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(lugar);

		transaction.commit();
		return lugar;
	}
	
	@Override
	public int borrarLugar(int id) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("DELETE FROM Lugar l WHERE l.id = :id");
		
		query.setParameter("id", id);
		int rowsDeleted = query.executeUpdate();
		transaction.commit();
		return rowsDeleted;

	}


	@Override
	public Lugar updateLugar(Lugar lugar) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(lugar);
		transaction.commit();
		return lugar;
	}

	@Override
	public Lugar findLugarById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Lugar.class, id);
	}

	@Override
	public Lugar findLugarByName(String name) {
		// TODO Auto-generated method stub
		return entityManager.createQuery("Select l from Lugar l where l.nombre LIKE '%" + name + "%'", Lugar.class)
				.getSingleResult();

	}

	@Override
	public List<Lugar> getLugares() {
		// TODO Auto-generated method stub

		return entityManager.createQuery("Select l from Lugar l", Lugar.class).getResultList();

		// return entityManager.createNativeQuery("Select * from lugares",
		// Lugar.class).getResultList();

	}


}
