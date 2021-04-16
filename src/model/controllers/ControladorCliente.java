package model.controllers;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Cliente;


public class ControladorCliente {

	private static ControladorCliente instance = null;
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("TutorialJavaCochesJPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorCliente getInstance () {
		if (instance == null) {
			instance = new ControladorCliente();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorCliente() {
	}
	
	
	public Cliente find(int id) {
		Cliente c = null;
		EntityManager em = factory.createEntityManager();
		c = (Cliente) em.find(Cliente.class, id);
		em.close();
		return c;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Cliente findPrimero () {
		Cliente c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id limit 1", Cliente.class);
		c = (Cliente) q.getSingleResult();
		em.close();
		
		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findUltimo () {
		Cliente c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente order by id desc limit 1", Cliente.class);
		c = (Cliente) q.getSingleResult();
		em.close();
		
		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findSiguiente (int idActual) {
		Cliente c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id > ? order by id limit 1", Cliente.class);
		q.setParameter(1, idActual);
		c = (Cliente) q.getSingleResult();
		em.close();
		
		return c;
	}
	

	/**
	 * 
	 * @return
	 */
	public Cliente findAnterior (int idActual) {
		Cliente c = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from tutorialjavacoches.cliente where id < ? order by id desc limit 1", Cliente.class);
		q.setParameter(1, idActual);
		c = (Cliente) q.getSingleResult();
		em.close();
		
		return c;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Cliente c) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (c.getId() == 0) {
				em.persist(c);
			}
			else {
				em.merge(c);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Cliente c) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		if (!em.contains(c)) {
		    c = em.merge(c);
		}
		em.remove(c);
		em.getTransaction().commit();
		em.close();
	}

	
	/**
	 * 
	 * @return
	 */
	public List<Cliente> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM cliente", Cliente.class);
		
		List<Cliente> list = (List<Cliente>) q.getResultList();
		em.close();
		return list;
	}
	

}
