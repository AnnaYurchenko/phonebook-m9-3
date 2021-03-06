package com.telran.phonebookapi.controller;

import com.telran.phonebookapi.dto.AddressDto;
import com.telran.phonebookapi.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/address")
public class AddressController {

    AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("")
    public void addAddress(@RequestBody @Valid AddressDto addressDto) {
        addressService.add(addressDto);
    }

    @PutMapping("")
    public void editAddress(@RequestBody @Valid AddressDto addressDto) {
        addressService.editAllFields(addressDto);
    }

    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable int id) {
        addressService.removeById(id);
    }

    @GetMapping("/{contactId}/all")
    public List<AddressDto> getAllAddresses(@PathVariable int contactId) {
        return addressService.getAllAddressesByContactId(contactId);
    }
}
