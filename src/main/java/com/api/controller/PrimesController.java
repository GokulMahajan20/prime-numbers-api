package com.api.controller;

import com.api.model.Primes;
import com.api.response.Response;
import com.api.service.PrimesService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@EnableCircuitBreaker
public class PrimesController {

    @Autowired
    private PrimesService primesService;

    @ResponseBody
    @GetMapping("/primes/{upperCircuit}")
    @HystrixCommand(fallbackMethod = "defaultPrimesList", commandKey = "getPrimes", groupKey = "PrimesController", threadPoolKey = "PrimesThreadPool", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "3000")})
    Response getPrimes(@PathVariable Long upperCircuit, @RequestParam Optional<String> executionType) {
        return buildResponse(upperCircuit, primesService.getPrimes(upperCircuit, executionType));
    }

    private Response buildResponse(Long upperCircuit, List<Long> primes) {
        return new Primes.ResponseBuilder()
                .setInitials(upperCircuit)
                .setPrimes(primes)
                .build();
    }

    public Response defaultPrimesList(Long upperCircuit, Optional<String> executionType) {
        List defaultResponse = new ArrayList(1);
        defaultResponse.add("Timeout : System is not responding or slow, please try again after sometime or try with a lower number.");
        return new Primes.ResponseBuilder()
                .setInitials(upperCircuit)
                .setPrimes(defaultResponse)
                .build();
    }

}
