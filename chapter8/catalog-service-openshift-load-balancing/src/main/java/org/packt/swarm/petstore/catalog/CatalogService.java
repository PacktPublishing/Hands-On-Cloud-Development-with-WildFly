package org.packt.swarm.petstore.catalog;

import org.packt.swarm.petstore.catalog.model.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@ApplicationScoped
public class CatalogService {

    @PersistenceContext(unitName = "CatalogPU")
    private EntityManager em;

    public Item searchById(String itemId) {
        return em.createNamedQuery("Item.findById", Item.class).setParameter("itemId", itemId).getSingleResult();
    }

    public List<Item> getAll() {
        return em.createNamedQuery("Item.findAll", Item.class).getResultList();
    }

    @Transactional
    public void add(Item item){
        item.setItemId(UUID.randomUUID().toString());
        em.persist(item);
    }

}
