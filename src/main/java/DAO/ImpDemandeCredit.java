package DAO;

import Config.SessionFactoryProvider;
import DTO.DemandeCredit;
import Interfaces.IdemandeCredit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ImpDemandeCredit implements IdemandeCredit {
   private SessionFactory sessionFactory;
   private Session session;
   private Transaction transaction;

   public ImpDemandeCredit(){
       this.sessionFactory = SessionFactoryProvider.provideSessionFactory();
       this.session = sessionFactory.openSession();
   }

    @Override
    public Optional<DemandeCredit> add(DemandeCredit demandeCredit) {
        try {
            session.beginTransaction();
            session.save(demandeCredit);
            transaction.commit();
            return Optional.of(demandeCredit);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<DemandeCredit> getbydate(LocalDate date) {
        Query query = session.createQuery("FROM demandecredit WHERE date like :date");
        query.setParameter("date", date);
        return query.list();
    }

    @Override
    public List<DemandeCredit> getbyetat(String etat) {
        Query query = session.createQuery("FROM demandecredit WHERE etat like :etat");
        query.setParameter("etat", etat);
        return query.list();
    }

    @Override
    public List<DemandeCredit> gatAll() {
        Query query = session.createQuery("FROM demandecredit");
        return query.list();
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
