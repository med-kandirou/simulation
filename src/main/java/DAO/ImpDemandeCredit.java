package DAO;

import Config.SessionFactoryProvider;
import DTO.DemandeCredit;
import DTO.Historique;
import Interfaces.IdemandeCredit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

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
            transaction=session.beginTransaction();
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

    public List<DemandeCredit> getbydate(LocalDate date) {
        Query query = session.createQuery("FROM DemandeCredit d WHERE d.date = :date", DemandeCredit.class);
        query.setParameter("date", date);
        return query.list();
    }

    @Override
    public List<DemandeCredit> getbyetat(String etat) {
        Query query = session.createQuery("FROM DemandeCredit d WHERE d.etat = :etat", DemandeCredit.class);
        query.setParameter("etat",etat);
        return query.list();
    }



    @Override
    public List<DemandeCredit> gatAll() {
        Query query = session.createQuery("FROM DemandeCredit ",DemandeCredit.class);
        return query.list();
    }

    @Override
    public Optional<DemandeCredit> updateStatus(int demandeNum, String newStatus) {
        try {
            transaction = session.beginTransaction();
            DemandeCredit demandeCredit = session.get(DemandeCredit.class, demandeNum);
            if (demandeCredit != null) {
                demandeCredit.setEtat(newStatus);
                session.update(demandeCredit);
                transaction.commit();
                return Optional.of(demandeCredit);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Historique> getHistorique(int numDemande) {
        Query query = session.createQuery("FROM Historique h WHERE h.demande_id = :demande_id", Historique.class);
        query.setParameter("demande_id",numDemande);
        return query.list();
    }


    @Override
    public boolean delete(Integer id) {

        return false;
    }
}
