package com.guilherm.hearthstone.model;

import com.guilherm.hearthstone.exception.ExceptionError;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Lob
    private String descricao;

    private int ataque;
    @Size(min = 0, max = 10, message
            = "Não pode passar de 10")
    private int defesa;

    private Integer tipo;

    private Integer classe;

    @PrePersist
    public void prePersist(){
        if(ataque > 10){
            throw new ExceptionError("O valor maximo é 10");
        }else if (defesa > 10){
            throw new ExceptionError("O valor maximo é 10");
        }
    }
    public Carta() {
    }

    public Carta(Long id, String nome, String descricao, int ataque, int defesa, Tipo tipo, Classe classe) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ataque = ataque;
        this.defesa = defesa;
        setTipo(tipo);
        setClasse(classe);
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

    public Tipo getTipo() {
        return Tipo.valueOf(tipo);
    }

    public void setTipo(Tipo tipo) {
        if (tipo != null) {
            this.tipo = tipo.getCode();
        }
    }

    public Classe getClasse() {
        return Classe.valueOf(classe);
    }

    public void setClasse(Classe classe) {
        if (classe != null) {
            this.classe = classe.getCode();
        }
    }
}
