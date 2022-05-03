package miu.edu.cs544.sirjana.jobsearch.controller;
import miu.edu.cs544.sirjana.jobsearch.entity.Client;
import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAll(){

        return clientService.getAllClients();

    }


    @GetMapping("/client/{client_id}")
    public Client getOne(@PathVariable int client_id){
        Client client = clientService.getOneClient(client_id);
        if (client == null) {
            throw new Allexception(client_id);
        }
        return client;

    }

    @DeleteMapping("/client/{client_id}")
    public void deleteOne(@PathVariable int client_id){
        Client client = clientService.getOneClient(client_id);
        if (client != null) {
            clientService.deleteOneClient(client_id);
        } else {
            throw new Allexception(client_id);
        }

    }

    @PostMapping("/clients")
    public Client addOne(@RequestBody Client client){
        clientService.addOneClient(client);

        return client;
    }

    @PutMapping("/client/{client_id}")
    public Client updateOne(@PathVariable int client_id,@RequestBody Client client){
        clientService.updateOneClient(client_id, client);

        Client client1 = clientService.getOneClient(client_id);
        return client1;
    }

//    @PutMapping("/client/{client_id}")
//    public Client updateclientByJobs(@PathVariable int client_id,@RequestBody Client client){
//        clientService.updateOneClient(client_id, client);
//
//        Client client1 = clientService.getOneClient(client_id);
//        return client1;
//    }

    @PutMapping("/client/{client_id}/jobs")
    public Client updateJobsFromClient(@PathVariable int client_id, @RequestBody List<Job> jobs){
        Client client=clientService.updateJobsFromClient(client_id,jobs);
        return client;

//        @DeleteMapping("/client/{client_id}/jobs")
//        public Client updateJobsFromClient(@PathVariable int client_id, @RequestBody List<Job> jobs){
//            Client client=clientService.updateJobsFromClient(client_id,jobs);
//            return client;
//
//

}

}


