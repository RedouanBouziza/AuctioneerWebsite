package app.repositories;

import app.models.Bid;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository("BID.JPA")
@Primary
@Transactional
public class BidRepositoryJpa implements EntityRepository<Bid> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Bid> findAll() {
        TypedQuery<Bid> query = entityManager.createQuery("SELECT b FROM Bid b", Bid.class);
        return query.getResultList();
    }

    @Override
    public Bid findById(long id) {
        return this.entityManager.find(Bid.class, id);
    }

    @Override
    public Bid save(Bid bid) {
        return this.entityManager.merge(bid);
    }

    @Override
    public Bid deleteById(long id) {
        Bid bid = this.findById(id);
        this.entityManager.remove(bid);
        return bid;
    }

    @Override
    public List<Bid> findByQuery(String jpqlName, Object... params) {
        TypedQuery<Bid> query = entityManager.createNamedQuery(jpqlName, Bid.class);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }
}
