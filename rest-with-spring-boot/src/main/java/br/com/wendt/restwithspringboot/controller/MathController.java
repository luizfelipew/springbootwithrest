package br.com.wendt.restwithspringboot.controller;

import br.com.wendt.restwithspringboot.exception.UnsuportedMathOperationException;
import br.com.wendt.restwithspringboot.math.SimpleMath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static br.com.wendt.restwithspringboot.request.converters.NumberConverter.*;

@RestController
public class MathController {

    SimpleMath math = new SimpleMath();


    @GetMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }

        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));

    }

    @GetMapping(value = "/substraction/{numberOne}/{numberTwo}")
    public Double substraction(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.substraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.division(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.mean(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @GetMapping(value = "/squareRoot/{number}")
    public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
        if (!isNumber(number)){
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return math.squareRoot(convertToDouble(number));
    }

}
