import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Define o look and feel do sistema operacional (opcional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFimport javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Formulário de Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode("#f0f0f0"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel formContainer = new JPanel(new GridBagLayout());
        formContainer.setBackground(Color.WHITE);
        formContainer.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)));
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(formContainer, gbc);

        JLabel labelTipoUsuario = new JLabel("Tipo de Usuário:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        formContainer.add(labelTipoUsuario, gbc);

        String[] tiposUsuario = { "Pessoa", "Instituição" };
        JComboBox<String> comboTipoUsuario = new JComboBox<>(tiposUsuario);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formContainer.add(comboTipoUsuario, gbc);

        JLabel labelTipoPessoa = new JLabel("Doador ou Necessitado:");
        JTextField textCPF = new JTextField(20);
        JComboBox<String> comboTipoPessoa = new JComboBox<>(new String[] { "Doador", "Necessitado" });
        JLabel labelCidadePessoa = new JLabel("Cidade:");
        JTextField textCidadePessoa = new JTextField(20);
        JLabel labelBairroPessoa = new JLabel("Bairro:");
        JTextField textBairroPessoa = new JTextField(20);
        JLabel labelRuaPessoa = new JLabel("Rua:");
        JTextField textRuaPessoa = new JTextField(20);
        JLabel labelNumeroPessoa = new JLabel("Número:");
        JTextField textNumeroPessoa = new JTextField(20);
        JLabel labelEmailPessoa = new JLabel("Email:");
        JTextField textEmailPessoa = new JTextField(20);

        JTextField textCNPJ = new JTextField(20);
        JLabel labelCidadeInstituicao = new JLabel("Cidade:");
        JTextField textCidadeInstituicao = new JTextField(20);
        JLabel labelBairroInstituicao = new JLabel("Bairro:");
        JTextField textBairroInstituicao = new JTextField(20);
        JLabel labelRuaInstituicao = new JLabel("Rua:");
        JTextField textRuaInstituicao = new JTextField(20);
        JLabel labelNumeroInstituicao = new JLabel("Número:");
        JTextField textNumeroInstituicao = new JTextField(20);
        JLabel labelItensInstituicao = new JLabel("Itens Necessitados:");
        JTextField textItensInstituicao = new JTextField(20);
        JLabel labelEmailInstituicao = new JLabel("Email:");
        JTextField textEmailInstituicao = new JTextField(20);

        comboTipoUsuario.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String tipoUsuario = (String) e.getItem();
                    formContainer.removeAll();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    formContainer.add(labelTipoUsuario, gbc);
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    formContainer.add(comboTipoUsuario, gbc);

                    if (tipoUsuario.equals("Pessoa")) {
                        gbc.gridx = 0;
                        gbc.gridy = 2;
                        formContainer.add(labelTipoPessoa, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 3;
                        formContainer.add(comboTipoPessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 4;
                        formContainer.add(new JLabel("CPF:"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 5;
                        formContainer.add(textCPF, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 6;
                        formContainer.add(labelCidadePessoa, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 7;
                        formContainer.add(textCidadePessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 8;
                        formContainer.add(labelBairroPessoa, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 9;
                        formContainer.add(textBairroPessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 10;
                        formContainer.add(labelRuaPessoa, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 11;
                        formContainer.add(textRuaPessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 12;
                        formContainer.add(labelNumeroPessoa, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 13;
                        formContainer.add(textNumeroPessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 14;
                        formContainer.add(labelEmailPessoa, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 15;
                        formContainer.add(textEmailPessoa, gbc);

                        JButton btnEnviarPessoa = new JButton("Enviar");
                        gbc.gridx = 0;
                        gbc.gridy = 16;
                        formContainer.add(btnEnviarPessoa, gbc);

                        btnEnviarPessoa.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String tipoPessoa = (String) comboTipoPessoa.getSelectedItem();
                                if (tipoPessoa.equals("Doador")) {
                                    JFrame instituicoesFrame = new JFrame("Instituições e Suprimentos");
                                    instituicoesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    instituicoesFrame.setSize(500, 600);

                                    String[][] instituicoesDados = {
                                            { "Instituição 1", "Alimentos, Roupas" },
                                            { "Instituição 2", "Medicamentos, Livros" },
                                            { "Instituição 3", "Produtos de Higiene, Brinquedos" }
                                    };

                                    String[] colunas = { "Instituição", "Necessidades" };
                                    JTable tabelaInstituicoes = new JTable(instituicoesDados, colunas);
                                    JScrollPane scrollPane = new JScrollPane(tabelaInstituicoes);

                                    instituicoesFrame.add(scrollPane);
                                    instituicoesFrame.setVisible(true);
                                    frame.dispose();
                                } else {
                                    JOptionPane.showMessageDialog(frame, "Cadastro concluído com sucesso!");
                                }
                            }
                        });

                    } else if (tipoUsuario.equals("Instituição")) {
                        gbc.gridx = 0;
                        gbc.gridy = 2;
                        formContainer.add(new JLabel("CNPJ:"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 3;
                        formContainer.add(textCNPJ, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 4;
                        formContainer.add(labelCidadeInstituicao, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 5;
                        formContainer.add(textCidadeInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 6;
                        formContainer.add(labelBairroInstituicao, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 7;
                        formContainer.add(textBairroInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 8;
                        formContainer.add(labelRuaInstituicao, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 9;
                        formContainer.add(textRuaInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 10;
                        formContainer.add(labelNumeroInstituicao, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 11;
                        formContainer.add(textNumeroInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 12;
                        formContainer.add(labelItensInstituicao, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 13;
                        formContainer.add(textItensInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 14;
                        formContainer.add(labelEmailInstituicao, gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 15;
                        formContainer.add(textEmailInstituicao, gbc);

                        JButton btnEnviarInstituicao = new JButton("Enviar");
                        gbc.gridx = 0;
                        gbc.gridy = 16;
                        formContainer.add(btnEnviarInstituicao, gbc);

                        btnEnviarInstituicao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(frame, "Cadastro de instituição concluído com sucesso!");
                            }
                        });
                    }

                    formContainer.revalidate();
                    formContainer.repaint();
                }
            }
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
eelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cria o frame (janela)
        JFrame frame = new JFrame("Formulário de Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        // Cria um painel principal com layout GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode("#f0f0f0"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Container do formulário
        JPanel formContainer = new JPanel(new GridBagLayout());
        formContainer.setBackground(Color.WHITE);
        formContainer.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20),
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)
        ));
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(formContainer, gbc);

        // Grupo 1: Doador ou Necessitado
        JLabel labelTipo = new JLabel("Necessitado ou Doador:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        formContainer.add(labelTipo, gbc);

        String[] tipos = {"Necessitado", "Doador"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formContainer.add(comboTipo, gbc);

        // Grupo 2: Pessoa ou Instituição de Caridade
        JLabel labelCategoria = new JLabel("Pessoa ou Instituição de Caridade:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        formContainer.add(labelCategoria, gbc);

        String[] categorias = {"Pessoa", "Instituição de Caridade"};
        JComboBox<String> comboCategoria = new JComboBox<>(categorias);
        gbc.gridx = 0;
        gbc.gridy = 3;
        formContainer.add(comboCategoria, gbc);

        // Grupo 3: CPF ou CNPJ
        JLabel labelCPF = new JLabel("CPF:");
        JTextField textCPF = new JTextField(20);
        JLabel labelCNPJ = new JLabel("CNPJ:");
        JTextField textCNPJ = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 4;
        formContainer.add(labelCPF, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        formContainer.add(textCPF, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        formContainer.add(labelCNPJ, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        formContainer.add(textCNPJ, gbc);

        comboCategoria.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().equals("Pessoa")) {
                        labelCPF.setVisible(true);
                        textCPF.setVisible(true);
                        labelCNPJ.setVisible(false);
                        textCNPJ.setVisible(false);
                    } else {
                        labelCPF.setVisible(false);
                        textCPF.setVisible(false);
                        labelCNPJ.setVisible(true);
                        textCNPJ.setVisible(true);
                    }
                    formContainer.revalidate();
                    formContainer.repaint();
                }
            }
        });
        labelCNPJ.setVisible(false);
        textCNPJ.setVisible(false);

        // Grupo 4: Cidade (caso seja pessoa)
        JLabel labelCidade = new JLabel("Cidade:");
        JTextField textCidade = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 8;
        formContainer.add(labelCidade, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        formContainer.add(textCidade, gbc);

        // Grupo 5: Bairro (caso seja pessoa)
        JLabel labelBairro = new JLabel("Bairro:");
        JTextField textBairro = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 10;
        formContainer.add(labelBairro, gbc);
        gbc.gridx = 0;
        gbc.gridy = 11;
        formContainer.add(textBairro, gbc);

        // Grupo 6: Rua (caso seja pessoa)
        JLabel labelRua = new JLabel("Rua:");
        JTextField textRua = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 12;
        formContainer.add(labelRua, gbc);
        gbc.gridx = 0;
        gbc.gridy = 13;
        formContainer.add(textRua, gbc);

        // Grupo 7: Número (caso seja pessoa)
        JLabel labelNumero = new JLabel("Número:");
        JTextField textNumero = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 14;
        formContainer.add(labelNumero, gbc);
        gbc.gridx = 0;
        gbc.gridy = 15;
        formContainer.add(textNumero, gbc);

        // Grupo 8: Email
        JLabel labelEmail = new JLabel("Email:");
        JTextField textEmail = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 16;
        formContainer.add(labelEmail, gbc);
        gbc.gridx = 0;
        gbc.gridy = 17;
        formContainer.add(textEmail, gbc);

        // Botão de Envio
        JButton btnEnviar = new JButton("Enviar");
        gbc.gridx = 0;
        gbc.gridy = 18;
        formContainer.add(btnEnviar, gbc);

        // Ação para o botão de envio para processar o formulário
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) comboTipo.getSelectedItem();

                if (tipo.equals("Doador")) {
                    // Exibir lista de instituições e suprimentos necessários
                    JFrame instituicoesFrame = new JFrame("Instituições e Suprimentos");
                    instituicoesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    instituicoesFrame.setSize(500, 600);

                    String[][] instituicoesDados = {
                        {"Instituição 1", "Alimentos, Roupas"},
                        {"Instituição 2", "Medicamentos, Livros"},
                        {"Instituição 3", "Produtos de Higiene, Brinquedos"}
                    };

                    String[] colunas = {"Instituição", "Necessidades"};
                    JTable tabelaInstituicoes = new JTable(instituicoesDados, colunas);
                    JScrollPane scrollPane = new JScrollPane(tabelaInstituicoes);

                    instituicoesFrame.add(scrollPane);
                    instituicoesFrame.setVisible(true);
                    frame.dispose(); // Fecha a janela atual
                } else {
                    // Exibir mensagem de cadastro concluído para necessitados
                    JOptionPane.showMessageDialog(frame, "Cadastro concluído com sucesso!");
                }
            }
        });

        // Adiciona o painel principal ao frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
