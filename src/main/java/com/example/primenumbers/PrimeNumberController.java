package com.example.primenumbers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PrimeNumberController {

    @PostMapping("/calculate-prime-numbers")
    public List<Integer> calculatePrimeNumbers(@RequestBody int upperBoundary) {
        List<Integer> primes = new ArrayList<>();

        // Perform the Sieve of Eratosthenes algorithm
        boolean[] isComposite = new boolean[upperBoundary + 1];
        for (int i = 2; i * i <= upperBoundary; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= upperBoundary; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        // Collect the prime numbers
        for (int i = 2; i <= upperBoundary; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}