package com.example.Fyle.service;

import com.example.Fyle.entity.BankBrances;
import com.example.Fyle.repo.BankBranchesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    @Autowired
    private BankBranchesRepo bankBranchesRepo;

    public BankBrances getBankdetails(String ifscCode){
        BankBrances bankBrances = bankBranchesRepo.getBankDetails(ifscCode);
        System.out.println(bankBrances.toString());
        return bankBrances;
    }

    public List<BankBrances> getBranchDetails(String bankName, String city,int offset,int limit){
        List<BankBrances> bankBrances = bankBranchesRepo.getBranchDetails(bankName,city,offset,limit);
        System.out.println(bankBrances.toArray());
        return bankBrances;
    }
}
