package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.entity.Client;
import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.entity.Recruiter;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
    @Autowired
    RecruiterRepository recruiterrepository;

    public List<Recruiter> getAllRecruiter()
    {
        return recruiterrepository.findAll();

    }


    public Recruiter getOneRecruiter(int id){
        if(!recruiterrepository.findById(id).isEmpty()){
            return recruiterrepository.findById(id).get();
        }else{
            throw new Allexception(id);
        }
    }

    public Recruiter updateOneRecruiter(int id, Recruiter recruiter){
        if(!recruiterrepository.findById(id).isEmpty()) {
            recruiterrepository.save(recruiter);
            Recruiter recruiter1 = recruiterrepository.getById(id);
            return recruiter1;
        }else{
            throw new Allexception(id);
        }
    }

    public String addOneRecruiter(Recruiter recruiter){
        recruiterrepository.save(recruiter);
        return "Recruiter added";
    }

    public Recruiter deleteOneRecruiter(int id){
        if(!recruiterrepository.findById(id).isEmpty()) {
            Recruiter recruiter = recruiterrepository.findById(id).get();
            recruiterrepository.deleteById(id);
            return recruiter;
        }else{
            throw new Allexception(id);
        }
    }

     public Recruiter updateClientFromRecruiter(int id, List<Client> clients){

         Optional<Recruiter> recruiter = recruiterrepository.findById(id);
          if(!recruiter.isEmpty()){

              recruiter.get().setClients(clients);
              Recruiter recruiter1 = recruiterrepository.save((recruiter.get()));
              return recruiter1;
          }
          else {
              throw new Allexception(id);
          }
    }


//    public Client updateJobsFromClient(int client_id, List<Job> jobs) {
//        Optional<Client> optionalClient= clientrepository.findById(client_id);
//        if(!optionalClient.isEmpty()){
//            Client client=optionalClient.get();
//            client.setJobs(jobs);
//            return   clientrepository.save(client);
//        }else{
//            throw new Allexception(client_id);
//        }
//    }

    public Recruiter updateJobsFromRecruiter(int recruiter_id, List<Job> jobs) {

        Optional<Recruiter> recruiter= recruiterrepository.findById(recruiter_id);
        if(!recruiter.isEmpty()){
            Recruiter recruiter1=recruiter.get();
            recruiter1.setJobs(jobs);
            return  recruiterrepository.save(recruiter1);
        }else{
            throw new Allexception(recruiter_id);
        }
    }




}
