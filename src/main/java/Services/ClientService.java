package Services;

import DAO.ImpClient;
import DTO.Client;
import jakarta.validation.OverridesAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientService {
    ImpClient impClient;
    public ClientService(ImpClient impClient){
        this.impClient=impClient;
    }

    public Boolean add(Client client){
        Optional<Client> optClient= impClient.add(client);
        return optClient.isPresent();
    }

    public boolean update(Client client){
        return impClient.update(client).isPresent();
    }

    public List<Client> getAll(){
        return impClient.getAll();
    }

    public Optional<Client> getClientbyId(String code){
        Optional<Client> client= impClient.getClientbyId(code);
        return client;
    }

    public ArrayList search(String param){
        ArrayList<Client> clients= impClient.search(param);
        return clients;
    }

    public boolean delete(String id){
        return impClient.delete(id);
    }


}
