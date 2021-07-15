package com.api.service;

import java.util.List;
import java.util.Optional;

public interface PrimesService {
    List<Long> getPrimes(Long upperCircuit, Optional<String> executionType);
}
