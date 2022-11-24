package app.repositories;

import app.models.Offer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffersRepository {
    List<Offer> findAll();

    Offer findById(long id);

    Offer save(Offer offer);

    Offer deleteById(long id);
}
