package DAO;

import DTO.DemandeCredit;
import Interfaces.IdemandeCredit;

import java.util.Optional;

public class ImpDemandeCredit implements IdemandeCredit {

    @Override
    public Optional<DemandeCredit> add(DemandeCredit demandeCredit) {
        return Optional.empty();
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
