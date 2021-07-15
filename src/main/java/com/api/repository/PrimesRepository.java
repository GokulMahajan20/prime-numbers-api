package com.api.repository;

import java.util.List;
import java.util.Optional;

public interface PrimesRepository {
    List<Long> getPrimes(Long upperCircuit, Optional<String> executionType);
}
