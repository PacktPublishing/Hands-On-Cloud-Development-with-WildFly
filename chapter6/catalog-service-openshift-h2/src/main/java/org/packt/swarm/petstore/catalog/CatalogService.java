package org.packt.swarm.petstore.catalog;

import org.packt.swarm.petstore.catalog.model.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@ApplicationScoped
public class CatalogService {

    @PersistenceContext(unitName = "CatalogPU")
    private EntityManager em;

    public Item searchById(String itemId) {
        return em.createNamedQuery("Item.findById", Item.class).setParameter("itemId", itemId).getSingleResult();
    }

}
