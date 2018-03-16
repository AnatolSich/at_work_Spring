package service.impl;

import model.Bouquet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BouquetRepository;
import service.BouquetService;

import java.util.List;

@Service
public class BouquetServiceImpl implements BouquetService {

    @Autowired
    private BouquetRepository bouquetRepository;

    @Override
    public Bouquet getBouquet(int id) {
        if (id != 0)
            return bouquetRepository.getBouquet(id);
        else throw new RuntimeException("Invalid value id=0");
    }

    @Override
    public List<Bouquet> geaAllBouquets() {
        return bouquetRepository.geaAllBouquets();
    }

    @Override
    public void addBouquet(Bouquet bouquet) {
        if (bouquet != null)
            bouquetRepository.addBouquet(bouquet);
        else throw new RuntimeException("Adding bouquet is null");
    }

    @Override
    public void deleteBouquet(int id) {
        if (id != 0)
            bouquetRepository.deleteBouquet(id);
        else throw new RuntimeException("Invalid value id=0");
    }

    @Override
    public void updateBouquet(Bouquet bouquet) {
        if (bouquet != null)
            bouquetRepository.updateBouquet(bouquet);
        else throw new RuntimeException("Updating bouquet is null");
    }
}
