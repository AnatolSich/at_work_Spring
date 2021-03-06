package app.service.impl;

import app.model.Bouquet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.BouquetRepository;
import app.service.BouquetService;

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
    public void addBouquet(Bouquet bouquet, int eventId) {
        if (bouquet == null)
            throw new RuntimeException("Adding bouquet is null");
        else if (eventId < 0) throw new RuntimeException("Adding bouquet is impossible, invalid value eventId<=0");
        else bouquetRepository.addBouquet(bouquet);

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
