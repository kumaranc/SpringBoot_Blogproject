package com.blogproject.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(AddressDTO addressDTO) {

        Address address = mapAddressDTOToAddress.apply(addressDTO);
        Address address1 = addressRepository.save(address);
        return address1;
    }

    Function<AddressDTO, Address> mapAddressDTOToAddress = (addressDTO) -> {

        Address address = new Address(addressDTO.getStreetaddress(), addressDTO.getZip(), addressDTO.getLandmark());
        return address;
    };
}
