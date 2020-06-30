package com.guilherm.hearthstone.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Lob
    private String descricao;
    @Size(min = 0, max = 10, message
            = "Não pode passar de 10")
    private int ataque;
    @Size(min = 0, max = 10, message
            = "Não pode passar de 10")
    private int defesa;

    public Carta() {
    }

    public Carta(Long id, String nome, String descricao, int ataque, int defesa) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
