package com.api.utility.producer.impl;

import com.api.utility.producer.PrimesProducer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PrimeParallelProducerImpl implements PrimesProducer {

    @Override
    public List<Long> producePrimes(Long upperCircuit) {
        return LongStream.rangeClosed(2, upperCircuit).parallel()
                .filter(n -> isPrime(n)).boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(Long item) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(item))).parallel()
                .allMatch(n -> item % n != 0);
    }
}
