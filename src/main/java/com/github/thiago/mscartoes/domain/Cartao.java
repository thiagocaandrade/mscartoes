package com.github.thiago.mscartoes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private BandeiraCartao cartao;
    private String bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;


    public Cartao(String nome, BandeiraCartao cartao, BigDecimal renda, BigDecimal limiteBasico) {
        this.nome = nome;
        this.cartao = cartao;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }
}
