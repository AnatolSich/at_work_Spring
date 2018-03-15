package service;

import model.Bouquet;

import java.util.List;

public interface BouquetService {
    Bouquet getBouquet(int id);
    List<Bouquet> geaAllBouquets();
    void addBouquet(Bouquet bouquet);
    void deleteBouquet(int id);
    void updateBouquet(Bouquet bouquet);
}
