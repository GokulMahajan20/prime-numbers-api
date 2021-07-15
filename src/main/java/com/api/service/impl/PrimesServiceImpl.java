package com.api.service.impl;

import com.api.repository.PrimesRepository;
import com.api.service.PrimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrimesServiceImpl implements PrimesService {

    @Autowired
    private PrimesRepository primesRepository;

    @Override
    public List<Long> getPrimes(Long upperCircuit, Optional<String> executionType) {
        return primesRepository.getPrimes(upperCircuit, executionType);
    }
}
