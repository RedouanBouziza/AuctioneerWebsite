package app.repositories;

import app.models.Offer;
import app.models.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("USER.JPA")
@Primary
@Transactional
public class UsersRepositoryJPA implements EntityRepository<User> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT o FROM User o", User.class);
        return query.getResultList();
    }

    @Override
    public User findById(long id) {
        return this.entityManager.find(User.class, id);
    }

    @Override
    public User save(User user) {
        return this.entityManager.merge(user);
    }


    @Override
    public User deleteById(long id) {
        User user = this.findById(id);
        this.entityManager.remove(user);
        return user;
    }

    @Override
    public List<User> findByQuery(String jpqlName, Object... params) {
        TypedQuery<User> query = entityManager.createNamedQuery(jpqlName, User.class);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }
}

