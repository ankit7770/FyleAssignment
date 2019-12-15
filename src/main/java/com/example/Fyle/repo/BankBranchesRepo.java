package com.example.Fyle.repo;

import com.example.Fyle.entity.BankBrances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankBranchesRepo extends JpaRepository<BankBrances,String>{

    @Query(value = "Select * from bank_branches where ifsc=?1",nativeQuery = true)
    public BankBrances getBankDetails(String ifscCode);

    @Query(value = "Select * from bank_branches where bank_name=?1 and city=?2 ORDER BY ifsc offset ?3 limit ?4",nativeQuery = true)
    public List<BankBrances> getBranchDetails(String bankName, String city,int offset,int limit);
}
