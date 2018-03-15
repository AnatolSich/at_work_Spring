package repository.impl;

import model.Bouquet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.BouquetRepository;

import java.util.List;

@Repository
@Transactional
public class BouquetRepositoryImpl implements BouquetRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Bouquet getBouquet(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Bouquet.class, id);
    }

    @Override
    public List<Bouquet> geaAllBouquets() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Bouquet>) session.createQuery("from Bouquet").list();
    }

    @Override
    public void addBouquet(Bouquet bouquet) {
        Session session = sessionFactory.getCurrentSession();
        session.save("Bouquet", bouquet);
    }

    @Override
    public void deleteBouquet(int id) {
        Session session = sessionFactory.getCurrentSession();
        Bouquet existBouquet = session.get(Bouquet.class, id);
        if (existBouquet != null) {
            session.delete("Bouquet", existBouquet);
        } else throw new RuntimeException("No bouquet with defined id");
    }

    @Override
    public void updateBouquet(Bouquet bouquet) {
        Session session = sessionFactory.getCurrentSession();
        Bouquet existBouquet = session.get(Bouquet.class, bouquet.getId());
        if (existBouquet != null) {
            existBouquet.setColor(bouquet.getColor());
            existBouquet.setCost(bouquet.getCost());
            existBouquet.setEvent(bouquet.getEvent());
            session.saveOrUpdate("Bouquet", existBouquet);
        } else throw new RuntimeException("No bouquet with defined id");

    }
}
