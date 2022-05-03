package miu.edu.cs544.sirjana.jobsearch.controller;


import miu.edu.cs544.sirjana.jobsearch.entity.Address;
import miu.edu.cs544.sirjana.jobsearch.exception.Allexception;
import miu.edu.cs544.sirjana.jobsearch.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/addresss")
    public List<Address> getAll(){

        return addressService.getAllAddress();

    }


    @GetMapping("/address/{address_id}")
    public Address getOne(@PathVariable int address_id){
        Address address = addressService.getOneAddress(address_id);
        if (address == null) {
            throw new Allexception(address_id);
        }
        return address;

    }

    @DeleteMapping("/address/{address_id}")
    public void deleteOne(@PathVariable int address_id){
        Address address = addressService.getOneAddress(address_id);
        if (address != null) {
            addressService.deleteOneAddress(address_id);
        } else {
            throw new Allexception(address_id);
        }

    }

    @PostMapping("/address")
    public Address addOne(@RequestBody Address address){
        addressService.addOneAddress(address);

        return address;
    }

    @PutMapping("/address/{address_id}")
    public Address updateOne(@PathVariable int address_id,@RequestBody Address address){
        addressService.updateOneAddress(address_id, address);

        Address address1 = addressService.getOneAddress(address_id);
        return address1;
    }
}

