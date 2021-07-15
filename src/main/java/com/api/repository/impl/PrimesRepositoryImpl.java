package com.api.repository.impl;

import com.api.repository.PrimesRepository;
import com.api.utility.factory.PrimesFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrimesRepositoryImpl implements PrimesRepository {
    @Override
    public List<Long> getPrimes(Long upperCircuit, Optional<String> executionType) {
        return PrimesFactory.getInstance(executionType).producePrimes(upperCircuit);
    }
}
