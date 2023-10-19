package DAO;

import Config.Database;
import Config.SessionFactoryProvider;
import DTO.DemandeCredit;
import Interfaces.IdemandeCredit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.Optional;

public class ImpDemandeCredit implements IdemandeCredit {

   final SessionFactory sessionFactory = SessionFactoryProvider.provideSessionFactory();
   final Session session = sessionFactory.openSession();
   final Transaction transaction = session.beginTransaction();


    @Override
    public Optional<DemandeCredit> add(DemandeCredit demandeCredit) {
        try {
            session.save(demandeCredit);
            transaction.commit();
            return Optional.of(demandeCredit);
        } catch (Exception e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<DemandeCredit> update(DemandeCredit demandeCredit) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {

        return false;
    }
}
