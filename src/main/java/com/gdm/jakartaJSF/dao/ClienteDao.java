package com.gdm.jakartaJSF.dao;

import com.gdm.jakartaJSF.models.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class ClienteDao {

    @PersistenceContext(unitName = "jakartaPU")
    private EntityManager entityManager;

    public void add(Cliente cliente) throws Exception {
        entityManager.persist(cliente);
    }

    public void delete(Cliente cliente) throws Exception {
        entityManager.remove(cliente);
    }

    public List<Cliente> getClientes() throws Exception {
        Query query = entityManager.createQuery("SELECT m from Cliente as m");
        return query.getResultList();
    }
}
