package cadastro.animais.rest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table(name = "tb_animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Min(value = 0, message = "A idade não pode ser negativa")
    private int idade;

    @NotBlank(message = "A cor é obrigatória")
    private String cor;

    @NotBlank(message = "A espécie é obrigatória")
    private String especie;

    public Animal() {
    }

    public Animal(UUID id, String nome, int idade, String cor, String especie) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.especie = especie;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}