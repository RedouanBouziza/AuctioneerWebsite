package app.repositories;

import app.models.Offer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffersRepository {
    public List<Offer> findAll();
}
