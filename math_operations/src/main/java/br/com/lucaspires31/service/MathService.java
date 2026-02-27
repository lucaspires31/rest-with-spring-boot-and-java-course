package br.com.lucaspires31.service;

import br.com.lucaspires31.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class  MathService {

    public Double sum(Double n1, Double n2) {
        return n1 + n2;
    }

    public Double sub(Double n1, Double n2) {
        return n1 - n2;
    }

    public Double mult(Double n1, Double n2) {
        return n1 * n2;
    }

    public Double div(Double n1, Double n2) {
        if (n2 == 0) {
            throw new UnsupportedMathOperationException("Cannot divide by zero");
        }
        return n1 / n2;
    }

    public Double med(Double n1, Double n2) {
        return (n1 + n2) / 2;
    }
}