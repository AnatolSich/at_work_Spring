package app.repository.impl;

import app.model.Bouquet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import app.repository.BouquetRepository;

import java.util.List;

@Repository
@Transactional
public class BouquetRepositoryImpl implements BouquetRepository {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory bouquetSessionFactory;

    @Override
    public Bouquet getBouquet(int id) {
        Session session = bouquetSessionFactory.getCurrentSession();
        return session.get(Bouquet.class, id);
    }

    @Override
    public List<Bouquet> geaAllBouquets() {
        Session session = bouquetSessionFactory.getCurrentSession();
        return (List<Bouquet>) session.createQuery("from model.Bouquet").list();
    }

    @Override
    public void addBouquet(Bouquet bouquet) {
        Session session = bouquetSessionFactory.getCurrentSession();
        session.persist("Bouquet", bouquet);
    }

    @Override
    public void deleteBouquet(int id) {
        Session session = bouquetSessionFactory.getCurrentSession();
        Bouquet existBouquet = session.get(Bouquet.class, id);
        if (existBouquet != null) {
            session.delete("Bouquet", existBouquet);
        } else throw new RuntimeException("No bouquet with defined id");
    }

    @Override
    public void updateBouquet(Bouquet bouquet) {
        Session session = bouquetSessionFactory.getCurrentSession();
        Bouquet existBouquet = session.get(Bouquet.class, bouquet.getId());
        if (existBouquet != null) {
            existBouquet.setBouquetName(bouquet.getBouquetName());
            existBouquet.setColor(bouquet.getColor());
            existBouquet.setCost(bouquet.getCost());
            session.saveOrUpdate("Bouquet", existBouquet);
        } else throw new RuntimeException("No bouquet with defined id");
    }
}
