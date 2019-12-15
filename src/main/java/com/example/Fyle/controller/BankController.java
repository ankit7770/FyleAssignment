package com.example.Fyle.controller;

import com.example.Fyle.entity.BankBrances;
import com.example.Fyle.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BankController {

    @Autowired
    private BankService bankService;

    @RequestMapping(method = RequestMethod.GET, value = "home")
    public String homePage() {
        return "Welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "bankDetails")
    public BankBrances bankDetails(@RequestParam String ifscCode) {
        return bankService.getBankdetails(ifscCode);
    }

    @RequestMapping(method = RequestMethod.GET, value = "branchDetails")
    public List<BankBrances> branchDetails(@RequestParam String bankName, @RequestParam String city, @RequestParam int offset, @RequestParam int limit) {
        return bankService.getBranchDetails(bankName,city,offset,limit);
    }
}
