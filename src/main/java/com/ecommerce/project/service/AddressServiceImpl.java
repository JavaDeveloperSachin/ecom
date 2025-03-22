package com.ecommerce.project.service;

import com.ecommerce.project.exception.ResourceNotFoundException;
import com.ecommerce.project.model.Address;
import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;
import com.ecommerce.project.repository.AddressRepository;
import com.ecommerce.project.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public AddressDTO createAddress(AddressDTO addressDTO, User user) {

        Address address = modelMapper.map(addressDTO, Address.class);
        List<Address> userAddresses = user.getAddresses();
        userAddresses.add(address);
        user.setAddresses(userAddresses);

        address.setUser(user);
        Address savedAddress = addressRepository.save(address);

        return modelMapper.map(savedAddress, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getAdresses() {
        List<Address> addressFromDB = addressRepository.findAll();
        List<AddressDTO> addressDTOS = addressFromDB.stream()
                .map(address -> modelMapper.map(address, AddressDTO.class)).toList();
        return addressDTOS;
    }

    @Override
    public AddressDTO getAddressById(Integer addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", addressId, "addressId"));
        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public List<AddressDTO> getUserAddress(User user) {

        List<Address> userAddresses = addressRepository.findAddressByUserId(user.getUserId());

        List<AddressDTO> addressDTOS = userAddresses.stream().map(address -> modelMapper.map(address, AddressDTO.class)).toList();
        return addressDTOS;
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO, Integer addressId) {

        Address userAddressFromDB = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", addressId, "addressId"));

        userAddressFromDB.setCity(addressDTO.getCity());
        userAddressFromDB.setCountry(addressDTO.getCountry());
        userAddressFromDB.setState(addressDTO.getState());
        userAddressFromDB.setPincode(addressDTO.getPincode());
        userAddressFromDB.setStreet(addressDTO.getStreet());
        userAddressFromDB.setBuildingName(addressDTO.getBuildingName());

        Address updatedAddress = addressRepository.save(userAddressFromDB);
        User user = userAddressFromDB.getUser();

        List<Address> userAddressListFromUser = user.getAddresses();
        userAddressListFromUser.removeIf(address -> address.getAddressId().equals(addressDTO.getAddressId()));
        userAddressListFromUser.add(updatedAddress);
        userRepository.save(user);
        return modelMapper.map(updatedAddress, AddressDTO.class);
    }

    @Override
    public String deleteAddress(Integer addressId) {
        Address addressFromDB = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", addressId, "addressId"));


        User user = addressFromDB.getUser();

        List<Address> addressesFromUser = user.getAddresses();

        addressesFromUser.removeIf(address -> address.getAddressId().equals(addressId));
        userRepository.save(user);
        addressRepository.delete(addressFromDB);

        return "Address deleted successfully with addressId" + addressId;
    }
}
