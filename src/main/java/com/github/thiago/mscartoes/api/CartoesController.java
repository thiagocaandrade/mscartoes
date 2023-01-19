package com.github.thiago.mscartoes.api;

import com.github.thiago.mscartoes.api.dto.CartaoSaveRequest;
import com.github.thiago.mscartoes.api.dto.CartoesPorClienteResponse;
import com.github.thiago.mscartoes.domain.Cartao;
import com.github.thiago.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartoesController {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "sucesso cartoes";
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){

        List<Cartao> cartoesRendaMaiorMenorIgual = cartaoService.getCartoesRendaMaiorMenorIgual(renda);

        return ResponseEntity.ok(cartoesRendaMaiorMenorIgual);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){

        List<ClienteCartao> clienteCartao = clienteCartaoService.listCartaoesByCpf(cpf);

        List<CartoesPorClienteResponse> resultList = clienteCartao.stream().map(CartoesPorClienteResponse::fromModel)
                .collect(Collectors.toList());


        return ResponseEntity.ok(resultList);

    }
}
