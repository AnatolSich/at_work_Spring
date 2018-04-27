package repository;

import model.Bouquet;

import java.util.List;

public interface BouquetRepository {
    Bouquet getBouquet(int id);
    List<Bouquet> geaAllBouquets();
    void addBouquet(Bouquet bouquet, int eventId);
    void deleteBouquet(int id);
    void updateBouquet(Bouquet bouquet);
}

