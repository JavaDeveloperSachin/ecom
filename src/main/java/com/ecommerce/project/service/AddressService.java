package com.ecommerce.project.service;

import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO, User user);


    List<AddressDTO> getAdresses();

    AddressDTO getAddressById(Integer addressId);

    List<AddressDTO> getUserAddress(User user);

    AddressDTO updateAddress(AddressDTO addressDTO, Integer addressId);

    String deleteAddress(Integer addressId);
}
