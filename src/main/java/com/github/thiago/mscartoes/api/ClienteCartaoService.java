package com.github.thiago.mscartoes.api;

import com.github.thiago.mscartoes.domain.ClienteCartao;
import com.github.thiago.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartao> listCartaoesByCpf(String cpf){

        return clienteCartaoRepository.findByCpf(cpf);
    }

}
