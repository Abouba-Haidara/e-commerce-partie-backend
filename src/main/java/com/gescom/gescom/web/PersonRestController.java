package com.gescom.gescom.web;

import com.gescom.gescom.entities.Client;
import com.gescom.gescom.entities.Person;
import com.gescom.gescom.entities.Provider;
import com.gescom.gescom.models.PersonModel;
import com.gescom.gescom.services.PersonService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PersonRestController {
    final PersonService personService;
    PersonRestController(final PersonService personService) {
        this.personService= personService;
    }

    @PostMapping("/persons")
    void create(@RequestBody @Validated PersonModel personModel){

        if(personModel.getAccountBank() != null && personModel.getRaisonSocial() !=null ) {

            Provider provider =  new Provider();
            provider.setAccountBank(personModel.getAccountBank());
            provider.setRaisonSocial(personModel.getRaisonSocial());
            provider.setName(personModel.getName());
            provider.setAddress(personModel.getAddress());
            provider.setTelephone(personModel.getTelephone());
            provider.setEmail(personModel.getEmail());

            this.personService.createProvider(provider);

        } else  {

            Client client  =  new Client();
            client.setName(personModel.getName());
            client.setCode(personModel.getCode());
            client.setTelephone(personModel.getTelephone());
            client.setBirthDay(personModel.getBirthDay());
            client.setEmail(personModel.getEmail());
            client.setAddress(personModel.getAddress());

            this.personService.createClient(client);
        }
    }
    @GetMapping("/persons")
    List<Person> findAllPersons() {
        return  this.personService.findAll();
    }

    @GetMapping("/persons/clients")
    List<Client> findAllClient() {
        return  this.personService.findAllClients();
    }
    @GetMapping("/persons/providers")
    List<Provider> findAllProviders() {
        return  this.personService.findAllProviders();
    }

    @GetMapping("/persons/{id}")
    Person findOneById(@PathVariable("id") long id) {
        return this.personService.findOnePerson(id);
    }

    @GetMapping("/persons/clients/{id}")
    Client findOneClientById(@PathVariable("id") long id) {
        return this.personService.findOneClientById(id);
    }

    @GetMapping("/persons/providers/{id}")
    Provider findOneProvider(@PathVariable("id") long id) {
        return  this.personService.findOneProviderById(id);
    }

    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable("id") long id) {
        this.personService.deletePerson(id);
    }

    @DeleteMapping("/persons")
    void deleteAll() {
        this.personService.deletePersonAll();
    }

}
