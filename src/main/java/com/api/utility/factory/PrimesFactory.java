package com.api.utility.factory;

import com.api.utility.producer.PrimesProducer;
import com.api.utility.producer.impl.PrimeParallelProducerImpl;
import com.api.utility.producer.impl.PrimeProducerImpl;

import java.util.Optional;

public class PrimesFactory {

    public static PrimesProducer getInstance(Optional<String> type) {
        switch (type.orElse("Default")) {
            case "sequential":
                return new PrimeProducerImpl();
            default:
                return new PrimeParallelProducerImpl();
        }
    }
}
