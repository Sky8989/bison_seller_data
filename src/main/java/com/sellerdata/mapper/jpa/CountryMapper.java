package com.sellerdata.mapper.jpa;

import com.sellerdata.pojo.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryMapper extends JpaRepository<Country, Integer> {
}
