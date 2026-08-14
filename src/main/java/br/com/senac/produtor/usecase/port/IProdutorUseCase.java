package br.com.senac.produtor.usecase.port;

import br.com.senac.produtor.ProdutorDTO.ProdutorDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IProdutorUseCase {
    ProdutorDTO calcularDescontoDoSalario(List<BigDecimal> salario);
}