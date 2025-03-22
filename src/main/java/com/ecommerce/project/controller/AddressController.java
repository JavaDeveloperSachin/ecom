package com.ecommerce.project.controller;

import com.ecommerce.project.model.Address;
import com.ecommerce.project.model.User;
import com.ecommerce.project.payload.AddressDTO;
import com.ecommerce.project.service.AddressService;
import com.ecommerce.project.util.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AuthUtil authUtil;

    @Autowired
    AddressService addressService;

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO) {
        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO, user);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAdresses() {
        List<AddressDTO> addressDTO = addressService.getAdresses();
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable Integer addressId) {
        AddressDTO addressDTO = addressService.getAddressById(addressId);
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @GetMapping("/user/address")
    public ResponseEntity<List<AddressDTO>> getUserAddresss() {
        User user = authUtil.loggedInUser();
        List<AddressDTO> userAddresses = addressService.getUserAddress(user);
        return new ResponseEntity<>(userAddresses, HttpStatus.OK);

    }


    @PutMapping("/address/{addressId}")
    public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO addressDTO, @PathVariable Integer addressId) {
        AddressDTO updatedAddressFromDB = addressService.updateAddress(addressDTO, addressId);
        return new ResponseEntity<>(updatedAddressFromDB, HttpStatus.OK);
    }

    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer addressId) {
        String deleteAddressMsg = addressService.deleteAddress(addressId);
        return new ResponseEntity<>(deleteAddressMsg, HttpStatus.OK);
    }
}
