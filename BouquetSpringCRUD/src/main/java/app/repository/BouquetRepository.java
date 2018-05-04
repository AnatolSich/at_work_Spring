package app.repository;

import app.model.Bouquet;

import java.util.List;

public interface BouquetRepository {
    Bouquet getBouquet(int id);
    List<Bouquet> geaAllBouquets();
    void addBouquet(Bouquet bouquet);
    void deleteBouquet(int id);
    void updateBouquet(Bouquet bouquet);
}

