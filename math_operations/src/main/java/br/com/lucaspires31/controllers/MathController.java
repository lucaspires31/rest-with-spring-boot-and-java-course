package br.com.lucaspires31.controllers;

import br.com.lucaspires31.exception.UnsupportedMathOperationException;

import br.com.lucaspires31.service.MathService;
import br.com.lucaspires31.util.Numberutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/math")


public class MathController {

    @Autowired
    private MathService service;


    @RequestMapping("/som/{numberOne}/{numberTwo}")
    public Double som (

            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numbertwo
    ) throws Exception {
        if (!Numberutil.isNumeric(numberOne) || !Numberutil.isNumeric(numbertwo))
            throw new UnsupportedMathOperationException("Please set a numeric value");
        Double n1 = Numberutil.convertToDouble(numberOne);
        Double n2 = Numberutil.convertToDouble(numbertwo);

        return service.sum(n1, n2);
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub (

            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numbertwo
    ) throws Exception {
        if (!Numberutil.isNumeric(numberOne) || !Numberutil.isNumeric(numbertwo))  throw new UnsupportedMathOperationException("Please set a numeric value");
        Double n1 = Numberutil.convertToDouble(numberOne);
        Double n2 = Numberutil.convertToDouble(numbertwo);

        return service.sub(n1, n2);
    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult (

            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numbertwo
    ) throws Exception {
        if (!Numberutil.isNumeric(numberOne) || !Numberutil.isNumeric(numbertwo))  throw new UnsupportedMathOperationException("Please set a numeric value");
        Double n1 = Numberutil.convertToDouble(numberOne);
        Double n2 = Numberutil.convertToDouble(numbertwo);

        return service.mult(n1, n2);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div (

            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numbertwo
    ) throws Exception {
        if (!Numberutil.isNumeric(numberOne) || !Numberutil.isNumeric(numbertwo))  throw new UnsupportedMathOperationException("Please set a numeric value");
        Double n1 = Numberutil.convertToDouble(numberOne);
        Double n2 = Numberutil.convertToDouble(numbertwo);

        return service.div(n1, n2);
    }

    @RequestMapping("/raiz/{number}")
    public Double raiz (

            @PathVariable("number") String number

    ) throws Exception {
        if (!Numberutil.isNumeric(number))  throw new UnsupportedMathOperationException("Please set a numeric value");
        return Math.sqrt(Numberutil.convertToDouble(number));
    }

    @RequestMapping("/med/{numberOne}/{numberTwo}")
    public Double med (

            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numbertwo
    ) throws Exception {
        if (!Numberutil.isNumeric(numberOne) || !Numberutil.isNumeric(numbertwo))  throw new UnsupportedMathOperationException("Please set a numeric value");
        Double n1 = Numberutil.convertToDouble(numberOne);
        Double n2 = Numberutil.convertToDouble(numbertwo);

        return service.med(n1, n2);
    }


































}
