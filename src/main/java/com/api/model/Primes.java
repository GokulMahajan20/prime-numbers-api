package com.api.model;

import com.api.response.Response;

import java.util.List;

public class Primes extends Response {
    private Long initial;
    private List primes;

    public Long getInitial() {
        return initial;
    }

    public List getPrimes() {
        return primes;
    }

    public Primes(Long initials, List primes) {
        this.initial = initials;
        this.primes = primes;
    }

    public static class ResponseBuilder {
        private Long initials;
        private List primes;

        public ResponseBuilder() {
        }

        public ResponseBuilder setInitials(Long initials) {
            this.initials = initials;
            return this;
        }

        public ResponseBuilder setPrimes(List primes) {
            this.primes = primes;
            return this;
        }

        public Primes build() {
            return new Primes(initials, primes);
        }

    }

}
