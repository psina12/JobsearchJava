package miu.edu.cs544.sirjana.jobsearch.service;

import miu.edu.cs544.sirjana.jobsearch.entity.Address;
import miu.edu.cs544.sirjana.jobsearch.entity.Job;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.repository.AddressRepository;
        ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> getAllAddress()
    {
        return addressRepository.findAll();

    }


    public Address getOneAddress(int id){
        if(!addressRepository.findById(id).isEmpty()){
            return addressRepository.findById(id).get();
        }else{
            throw new Allexception(id);
        }
    }

    public Address updateOneAddress(int id, Address address){
        if(!addressRepository.findById(id).isEmpty()) {
            addressRepository.save(address);
            Address address1 = addressRepository.getById(id);
            return address1;
        }else{
            throw new Allexception(id);
        }
    }

    public String addOneAddress(Address address){
        addressRepository.save(address);
        return "Address added";
    }

    public Address deleteOneAddress(int id){
        if(!addressRepository.findById(id).isEmpty()) {
            Address address = addressRepository.findById(id).get();
            addressRepository.deleteById(id);
            return address;
        }else{
            throw new Allexception(id);
        }
    }
}
