package com.api.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PrimesServiceImplTest {

    @Autowired
    private PrimesService primesService;

    @Test
    public void testPrimesResult() {
        List<Long> primes = this.primesService.getPrimes(10L, Optional.of("Parallel"));
        Assertions.assertThat(primes.size()).isEqualTo(4);
        Assertions.assertThat(primes).containsExactly(2l, 3l, 5l, 7l);
    }

}
