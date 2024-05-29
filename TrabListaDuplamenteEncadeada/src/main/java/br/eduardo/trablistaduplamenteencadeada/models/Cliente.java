
package br.eduardo.trablistaduplamenteencadeada.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private int codigo;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;

    public Cliente(int codigo, String nome, LocalDate dataNascimento, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Código: " + codigo + "\nNome: " + nome + "\nData de Nascimento: " + dataNascimento.format(formatter) + "\nTelefone: " + telefone;
    }
}
