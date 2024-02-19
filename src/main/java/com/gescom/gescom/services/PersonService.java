package com.gescom.gescom.services;

import com.gescom.gescom.entities.Client;
import com.gescom.gescom.entities.Person;
import com.gescom.gescom.entities.Provider;

import java.util.List;

public interface PersonService {
    void createProvider(Provider provider);
    List<Provider> findAllProviders();
    void createClient(Client client);
    List<Person> findAll();
    List<Client> findAllClients();
    void deletePerson(long  id);
    void editPerson(Provider provider, long id);
    void editPerson(Client client, long id);
    Person findOnePerson(long id);
    Provider findOneProviderById(long id);
    Client findOneClientById(long id);
    void deletePersonAll();
}
