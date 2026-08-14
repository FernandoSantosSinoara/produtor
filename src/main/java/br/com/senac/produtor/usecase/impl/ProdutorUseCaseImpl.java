package br.com.senac.produtor.usecase.impl;

import br.com.senac.produtor.ProdutorDTO.ProdutorDTO;
import br.com.senac.produtor.usecase.port.IProdutorUseCase;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.stream;

@Service
public class ProdutorUseCaseImpl implements IProdutorUseCase {
    public ProdutorDTO calcularDescontoDoSalario(List<BigDecimal> listaSalario){
        BigDecimal threshold = new BigDecimal("5000");
        BigDecimal totalSalarios = new BigDecimal(0);
        BigDecimal salarioDescontado;
        for (BigDecimal salario : listaSalario){
            if (salario.compareTo(threshold) == 0 || salario.compareTo(threshold) <= 0){
                salarioDescontado = salario.multiply(new BigDecimal("0.015"));
            } else{
                salarioDescontado = salario.multiply(new BigDecimal("0.075"));
            }
            totalSalarios = totalSalarios.add(salarioDescontado);
        }


        return ProdutorDTO.builder()
                .salarioDescontado(totalSalarios)
                .build();
    }
}