package cadastro.animais.rest.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID animalID;

    private String nome;

    private int idade;

    private String cor;

    private String especie;

    public Animal() {
    }

    public Animal(UUID animalID, String nome, int idade, String cor, String especie) {
        this.animalID = animalID;
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.especie = especie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getAnimalID() {
        return animalID;
    }

    public void setAnimalID(UUID animalID) {
        this.animalID = animalID;
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

