
package br.eduardo.trablistaduplamenteencadeada.models;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class ListaClientes {
    private Map<Integer, Cliente> clientes;

    public ListaClientes() {
        this.clientes = new HashMap<>();
    }

    public void cadastrarCliente(int codigo, String nome, 
            LocalDate dataNascimento, String telefone) {
        if (clientes.containsKey(codigo)) {
            JOptionPane.showMessageDialog(null,
                    "Já existe um cliente com esse código.");
            return;
        }

        Cliente cliente = new Cliente(codigo, nome, dataNascimento, telefone);
        clientes.put(codigo, cliente);
        JOptionPane.showMessageDialog(null,
                "Cliente cadastrado com sucesso.");
    }

    public void excluirCliente(int codigo) {
        Cliente clienteRemovido = clientes.remove(codigo);
        if (clienteRemovido == null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente não encontrado.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Cliente removido:\n" + clienteRemovido.toString());
        }
    }

    public void alterarCliente(int codigo, String nome,
            LocalDate dataNascimento, String telefone) {
        Cliente cliente = clientes.get(codigo);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente não encontrado.");
        } else {
            cliente.setNome(nome);
            cliente.setDataNascimento(dataNascimento);
            cliente.setTelefone(telefone);
            JOptionPane.showMessageDialog(null,
                    "Cliente alterado com sucesso.");
        }
    }

    public Cliente recuperarCliente(int codigo) {
        return clientes.get(codigo);
    }

    public String exibirTodosClientes() {
        if (clientes.isEmpty()) {
            return "Nenhum cliente cadastrado.";
        }
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : clientes.values()) {
            sb.append(cliente.toString()).append("\n\n");
        }
        return sb.toString();
    }

}
