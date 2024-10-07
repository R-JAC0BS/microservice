package br.edu.atitus.paradigma.cambioservice.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "cambio")
public class CambioEntity {


    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ou GenerationType.AUTO
    private Long id;
    private String origem;



    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getFator() {
        return fator;
    }

    public void setFator(double fator) {
        this.fator = fator;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    private String destino;
    private double fator;
    @Transient
    private String ambiente;
    @Transient private double valorConvertido;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
