
package br.eduardo.trablistaduplamenteencadeada;

import br.eduardo.trablistaduplamenteencadeada.models.Cliente;
import br.eduardo.trablistaduplamenteencadeada.models.ListaClientes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class TrabListaDuplamenteEncadeada {
    public static void main(String[] args) {
        ListaClientes listaClientes = new ListaClientes();
        DateTimeFormatter dateFormatter = 
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            String escolha = JOptionPane.showInputDialog(
                    "Escolha uma opção:\n"
                    + "1 - Cadastrar cliente\n"
                    + "2 - Excluir cliente\n"
                    + "3 - Alterar dados do cliente\n"
                    + "4 - Recuperar dados do cliente\n"
                    + "5 - Exibir todos os clientes\n"
                    + "0 - Sair"
            );

            if (escolha == null) {
                break;
            }

            switch (escolha) {
                case "1":
                    try {
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Informe o código do cliente:"));
                    String nome = JOptionPane.showInputDialog(
                            "Informe o nome do cliente:");
                    LocalDate dataNascimento = LocalDate.parse(
                            JOptionPane.showInputDialog(
                                    "Informe a data de nascimento "
                                    + "(dd/mm/aaaa):"), dateFormatter);
                    String telefone = JOptionPane.showInputDialog(
                            "Informe o telefone do cliente:");
                    listaClientes.cadastrarCliente(codigo, nome, dataNascimento,
                            telefone);
                } catch (NumberFormatException | DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null, 
                        "Dados inválidos. Por favor, tente novamente.");
                }
                break;

                case "2":
                    try {
                    int codigoExclusao = Integer.parseInt(
                            JOptionPane.showInputDialog("Informe o "
                                    + "código do cliente a ser excluído:"));
                    listaClientes.excluirCliente(codigoExclusao);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, 
                        "Código inválido. Por favor, tente novamente.");
                }
                break;

                case "3":
                    try {
                    int codigoAlteracao = Integer.parseInt(
                            JOptionPane.showInputDialog("Informe o"
                               + " código do cliente a ser alterado:"));
                    Cliente cliente = listaClientes.recuperarCliente(
                            codigoAlteracao);
                    if (cliente != null) {
                        String nome = JOptionPane.showInputDialog(
                            "Informe o novo nome do cliente:",
                            cliente.getNome());
                            LocalDate dataNascimento = LocalDate.parse(
                            JOptionPane.showInputDialog(
                            "Informe a nova data de nascimento"
                            + " (dd/MM/yyyy):", 
                        cliente.getDataNascimento().
                        format(dateFormatter)), dateFormatter);
                        String telefone = JOptionPane.showInputDialog(
                                "Informe o novo telefone do cliente:",
                                cliente.getTelefone());
                        listaClientes.alterarCliente(codigoAlteracao,
                                nome, dataNascimento, telefone);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Cliente não encontrado.");
                    }
                } catch (NumberFormatException | DateTimeParseException e) {
                    JOptionPane.showMessageDialog(null,
                        "Dados inválidos. Por favor, tente novamente.");
                }
                break;

                case "4":
                    try {
                    int codigoRecuperacao = Integer.parseInt(
                            JOptionPane.showInputDialog("Informe o "
                                    + "código do cliente:"));
                    Cliente cliente = listaClientes.recuperarCliente(
                            codigoRecuperacao);
                    if (cliente != null) {
                        JOptionPane.showMessageDialog(null,
                                cliente.toString());
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Cliente não encontrado.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                        "Código inválido. Por favor, tente novamente.");
                }
                break;

                case "5":
                    JOptionPane.showMessageDialog(null, 
                            listaClientes.exibirTodosClientes());
                    break;

                case "0":
                    JOptionPane.showMessageDialog(null,
                            "Saindo do aplicativo.");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                        "Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }
    }
}
