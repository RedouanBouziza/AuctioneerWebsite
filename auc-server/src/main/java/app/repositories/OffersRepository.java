package app.repositories;

import app.models.Offer;

import java.util.List;

public interface OffersRepository {
    public List<Offer> findAll();
}
