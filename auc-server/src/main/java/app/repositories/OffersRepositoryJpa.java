package app.repositories;

import app.models.Offer;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("OFFER.JPA")
@Primary
@Transactional
public class OffersRepositoryJpa implements EntityRepository<Offer> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Offer> findAll() {
        TypedQuery<Offer> query = entityManager.createQuery(
                "SELECT o FROM Offer o", Offer.class);
        return query.getResultList();
    }

    @Override
    public Offer findById(long id) {
    return this.entityManager.find(Offer.class, id);
    }

    @Override
    public Offer save(Offer offer) {
        return this.entityManager.merge(offer);
    }

    @Override
    public Offer deleteById(long id) {
        Offer offer = this.findById(id);
        this.entityManager.remove(offer);
        return offer;
    }

    @Override
    public List<Offer> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Offer> query = entityManager.createNamedQuery(jpqlName, Offer.class);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }
}
