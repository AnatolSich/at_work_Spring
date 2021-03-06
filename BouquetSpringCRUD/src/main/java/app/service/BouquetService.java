package app.service;

import app.model.Bouquet;

import java.util.List;

public interface BouquetService {
    Bouquet getBouquet(int id);
    List<Bouquet> geaAllBouquets();
    void addBouquet(Bouquet bouquet, int eventId);
    void deleteBouquet(int id);
    void updateBouquet(Bouquet bouquet);
}
