package br.com.senac.produtor.controller;

import br.com.senac.produtor.ProdutorDTO.ProdutorDTO;
import br.com.senac.produtor.controller.request.ProdutorRequest;
import br.com.senac.produtor.controller.response.ProdutorResponse;
import br.com.senac.produtor.usecase.port.IProdutorUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtor")
public class ProdutorController {

    private final IProdutorUseCase produtorUseCase;

    public ProdutorController(IProdutorUseCase produtorUseCase){
        this.produtorUseCase = produtorUseCase;
    }

    @PostMapping("/criar-folha-pagamento")
    public ResponseEntity<ProdutorResponse> criarFolhaDePagamento(@RequestBody ProdutorRequest request){
        var salario = request.getSalario();
        ProdutorDTO produtorDTO = produtorUseCase.calcularDescontoDoSalario(salario);
        ProdutorResponse produtorResponse = ProdutorResponse.builder()
                .salarioDescontado(produtorDTO.getSalarioDescontado())
                .build();
        return ResponseEntity.ok().body(produtorResponse);
    }
}