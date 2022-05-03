package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.entity.Client;
import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientrepository;

    public List<Client> getAllClients()
    {
        return clientrepository.findAll();

    }


    public Client getOneClient(int id){
        if(!clientrepository.findById(id).isEmpty()){
            return clientrepository.findById(id).get();
        }else{
            throw new Allexception(id);
        }
    }

    public Client updateOneClient(int id, Client client){
        if(!clientrepository.findById(id).isEmpty()) {
            clientrepository.save(client);
            Client client1 = clientrepository.getById(id);
            return client1;
        }else{
            throw new Allexception(id);
        }
    }

    public String addOneClient(Client client){
        clientrepository.save(client);
        return "Client added";
    }

    public Client deleteOneClient(int id){
        if(!clientrepository.findById(id).isEmpty()) {
            Client client = clientrepository.findById(id).get();
            clientrepository.deleteById(id);
            return client;
        }else{
            throw new Allexception(id);
        }
    }

    public Client updateJobsFromClient(int client_id, List<Job> jobs) {
        Optional<Client> optionalClient= clientrepository.findById(client_id);
        if(!optionalClient.isEmpty()){
            Client client=optionalClient.get();
            client.setJobs(jobs);
            return   clientrepository.save(client);
        }else{
            throw new Allexception(client_id);
        }
}

}

