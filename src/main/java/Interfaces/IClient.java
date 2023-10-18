package Interfaces;

import DTO.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public interface IClient extends IData<Client,String>{
    ArrayList<Client> getAll();
    Optional<Client> getClientbyId(String code);
}
