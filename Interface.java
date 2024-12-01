import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Interface {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Formulário de Cadastro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470, 720);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode("#f0f0f0"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

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
        gbc.weightx = 0;
        gbc.weighty = 0;
        formContainer.add(labelTipoUsuario, gbc);

        String[] tiposUsuario = {"Escolha uma opção!!","Pessoa", "Instituição"};
        JComboBox<String> comboTipoUsuario = new JComboBox<>(tiposUsuario);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formContainer.add(comboTipoUsuario, gbc);

        JLabel labelTipoPessoa = new JLabel("Doador ou Necessitado:");
        JTextField textCPF = new JTextField(20);
        JComboBox<String> comboTipoPessoa = new JComboBox<>(new String[]{"Doador", "Necessitado"});
        JLabel labelCidadePessoa = new JLabel("Cidade");
        JTextField textCidadePessoa = new JTextField(20);
        JLabel labelBairroPessoa = new JLabel("Bairro");
        JTextField textBairroPessoa = new JTextField(20);
        JLabel labelRuaPessoa = new JLabel("Rua");
        JTextField textRuaPessoa = new JTextField(20);
        JLabel labelNumeroPessoa = new JLabel("Número");
        JTextField textNumeroPessoa = new JTextField(20);
        JLabel labelEmailPessoa = new JLabel("Email");
        JTextField textEmailPessoa = new JTextField(20);

        JTextField textCNPJ = new JTextField(20);
        JLabel labelCidadeInstituicao = new JLabel("Cidade");
        JTextField textCidadeInstituicao = new JTextField(20);
        JLabel labelBairroInstituicao = new JLabel("Bairro");
        JTextField textBairroInstituicao = new JTextField(20);
        JLabel labelRuaInstituicao = new JLabel("Rua:");
        JTextField textRuaInstituicao = new JTextField(20);
        JLabel labelNumeroInstituicao = new JLabel("Número");
        JTextField textNumeroInstituicao = new JTextField(20);
        JLabel labelItensInstituicao = new JLabel("Itens Necessitados");
        JTextField textItensInstituicao = new JTextField(20);
        JLabel labelEmailInstituicao = new JLabel("Email");
        JTextField textEmailInstituicao = new JTextField(20);

        comboTipoUsuario.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String tipoUsuario = (String) e.getItem();
                    formContainer.removeAll();
                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    gbc.weightx = 0;
                    gbc.weighty = 0;
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
                        formContainer.add(new JLabel("CPF"), gbc);
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

                        gbc.gridy = 16; 
                        JButton btnEnviarPessoa = new JButton("Enviar");
                        gbc.gridx = 0;
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
                                            {"Instituição 1", "Alimentos, Roupas"},
                                            {"Instituição 2", "Medicamentos, Livros"},
                                            {"Instituição 3", "Produtos de Higiene, Brinquedos"}
                                    };

                                    String[] colunas = {"Instituição", "Necessidades"};
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
                        formContainer.add(new JLabel("CNPJ"), gbc);
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

                        gbc.gridy = 16; 
                        JButton btnEnviarInstituicao = new JButton("Enviar");
                        gbc.gridx = 0;
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

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
