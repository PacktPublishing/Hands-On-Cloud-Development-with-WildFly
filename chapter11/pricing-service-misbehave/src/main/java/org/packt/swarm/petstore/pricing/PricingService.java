package org.packt.swarm.petstore.pricing;

import org.packt.swarm.petstore.pricing.model.Price;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@ApplicationScoped
public class PricingService {

    @PersistenceContext(unitName = "PricingPU")
    private EntityManager em;

    public Price findByItemId(String itemId) {
        LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(10));
        List<Price> result = em.createNamedQuery("Price.findByItemId", Price.class).setParameter("itemId", itemId).getResultList();
        return result.get(0);
    }
}
