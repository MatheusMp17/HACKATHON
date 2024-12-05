import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Interface {
    private static ArrayList<Item> doadores = new ArrayList<>();
    private static ArrayList<Item> receptores = new ArrayList<>();

    private static JFrame frame;
    private static JPanel mainPanel;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        frame = getFrame();
        showLoginScreen();
    }

    // Tela de Login ou Cadastro
    private static void showLoginScreen() {
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.decode("#f0f0f0"));
        GridBagConstraints gbc = getGbc();

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

        JComboBox<String> comboTipoUsuario = cobTipoUsuario(gbc, formContainer);
        comboTipoUsuario.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String tipoUsuario = (String) e.getItem();
                    formContainer.removeAll(); // Remove todos os componentes antes de adicionar novos

                    gbc.gridx = 0;
                    gbc.gridy = 0;
                    formContainer.add(labelTipoUsuario, gbc);
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    formContainer.add(comboTipoUsuario, gbc);

                    JLabel labelTipoPessoa = new JLabel("Doador ou Necessitado:");
                    JComboBox<String> comboTipoPessoa = new JComboBox<>(new String[]{"Informe seu estado", "Doador", "Necessitado"});
                    JComboBox<String> comboItensNecessitados = new JComboBox<>(new String[] {
                        TipoDoacao.itensDeHigiene.getNome(),
                        TipoDoacao.Alimentos.getNome(),
                        TipoDoacao.Roupas.getNome(),
                        TipoDoacao.conforto.getNome(),
                        TipoDoacao.moveis.getNome(), TipoDoacao.voluntariado.getNome(),
                        TipoDoacao.dinheiro.getNome()});
                comboItensNecessitados.setVisible(true);  // Inicialmente visível
                JComboBox<String> comboItensDoacao = new JComboBox<>(new String[] {
                    TipoDoacao.itensDeHigiene.getNome(),
                    TipoDoacao.Alimentos.getNome(),
                    TipoDoacao.Roupas.getNome(),
                    TipoDoacao.conforto.getNome(),
                    TipoDoacao.moveis.getNome(), TipoDoacao.voluntariado.getNome(),
                    TipoDoacao.dinheiro.getNome()});
            comboItensDoacao.setVisible(true);  // Inicialmente invisível
                    JTextField textCPF = new JTextField(20);
                    JTextField textCidadePessoa = new JTextField(20);
                    JTextField textBairroPessoa = new JTextField(20);
                    JTextField textRuaPessoa = new JTextField(20);
                    JTextField textNumeroPessoa = new JTextField(20);
                    JTextField textEmailPessoa = new JTextField(20);
                   
                    SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 99999, 1);
                    JSpinner spinnerQtdPessoa = new JSpinner(model);
                    
                    

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
                        formContainer.add(new JLabel("Cidade"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 7;
                        formContainer.add(textCidadePessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 8;
                        formContainer.add(new JLabel("Bairro"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 9;
                        formContainer.add(textBairroPessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 10;
                        formContainer.add(new JLabel("Rua"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 11;
                        formContainer.add(textRuaPessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 12;
                        formContainer.add(new JLabel("Número"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 13;
                        formContainer.add(textNumeroPessoa, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 14;
                        formContainer.add(new JLabel("Email"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 15;
                        formContainer.add(textEmailPessoa, gbc);
                        


                        // Mostrar a categoria "Itens de doação" somente se o tipo de pessoa for "Doador"
                        comboTipoPessoa.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent e) {
                                    comboItensDoacao.setVisible(true);
                                    gbc.gridx = 0;
                                    gbc.gridy = 16;
                                    formContainer.add(new JLabel("Itens de doação:"), gbc);
                                    gbc.gridx = 0;
                                    gbc.gridy = 17;
                                    formContainer.add(comboItensDoacao, gbc);
                                    
                                    gbc.gridx = 10;
                                    gbc.gridy = 17;
                                    spinnerQtdPessoa.setPreferredSize(new Dimension(55, 25));
                                    formContainer.add(spinnerQtdPessoa, gbc);

                                formContainer.revalidate();
                                formContainer.repaint();
                            }
                        });

                        JButton btnEnviarPessoa = new JButton("Cadastrar");
                        gbc.gridx = 0;
                        gbc.gridy = 18;
                        formContainer.add(btnEnviarPessoa, gbc);

                        btnEnviarPessoa.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Boolean estaDoando;
                                if(comboTipoPessoa.getSelectedItem().equals("Doador")){
                                    estaDoando = true;
                                }
                                else if(comboTipoPessoa.getSelectedItem().equals("Necessitado")){
                                    estaDoando = false;
                                }
                                else {
                                    estaDoando = null;
                                }
                                Endereco endereco = new Endereco(textCidadePessoa.getText(), textBairroPessoa.getText(), textRuaPessoa.getText(), Integer.parseInt(textNumeroPessoa.getText().toString()));
                                Item doacao = new Item(Integer.parseInt(textCPF.getText().toString()), textEmailPessoa.getText().toString(), TipoDoacao.testeTipoDoacao(comboItensDoacao.getSelectedItem().toString()), Integer.parseInt(spinnerQtdPessoa.getValue().toString()), estaDoando); 
                                

                                if (doacao.getDoacao()){
                                    doadores.add(doacao);
                                    PessoaDoador usuario = new PessoaDoador(Integer.parseInt(textCPF.getText().toString()), endereco, textEmailPessoa.getText().toString(), doacao);
                                }
                                else if(!doacao.getDoacao()){
                                    receptores.add(doacao);
                                    PessoaVitima usuario = new PessoaVitima(Integer.parseInt(textCPF.getText().toString()), endereco, textEmailPessoa.getText().toString(), doacao);
                                }
                            }
                        });

                    } else if (tipoUsuario.equals("Instituição")) {
                        JTextField textCNPJ = new JTextField(20);
                        JTextField textCidadeInstituicao = new JTextField(20);
                        JTextField textBairroInstituicao = new JTextField(20);
                        JTextField textRuaInstituicao = new JTextField(20);
                        JTextField textNumeroInstituicao = new JTextField(20);
                        JTextField textEmailInstituicao = new JTextField(20);

                        gbc.gridx = 0;
                        gbc.gridy = 2;
                        formContainer.add(new JLabel("CNPJ"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 3;
                        formContainer.add(textCNPJ, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 4;
                        formContainer.add(new JLabel("Cidade"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 5;
                        formContainer.add(textCidadeInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 6;
                        formContainer.add(new JLabel("Bairro"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 7;
                        formContainer.add(textBairroInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 8;
                        formContainer.add(new JLabel("Rua"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 9;
                        formContainer.add(textRuaInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 10;
                        formContainer.add(new JLabel("Número"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 11;
                        formContainer.add(textNumeroInstituicao, gbc);

                        gbc.gridx = 0;
                        gbc.gridy = 12;
                        formContainer.add(new JLabel("Email"), gbc);
                        gbc.gridx = 0;
                        gbc.gridy = 13;
                        formContainer.add(textEmailInstituicao, gbc);
                
                        
                        JButton btnEnviarInstituicao = new JButton("Cadastrar");
                        gbc.gridx = 0;
                        gbc.gridy = 16;
                        formContainer.add(btnEnviarInstituicao, gbc);
                        btnEnviarInstituicao.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                
                                Endereco endereco = new Endereco(textCidadeInstituicao.getText(), textBairroInstituicao.getText(), textRuaInstituicao.getText(), Integer.parseInt(textNumeroInstituicao.getText().toString()));
                                Pessoa usuario = new Pessoa(Integer.parseInt(textCNPJ.getText().toString()), endereco, textEmailInstituicao.getText());
                                showHomeScreen("Instituição");
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

    private static JComboBox<String> cobTipoUsuario(GridBagConstraints gbc, JPanel formContainer) {
        String[] tiposUsuario = {"Escolha uma opção!!", "Pessoa", "Instituição"};
        JComboBox<String> comboTipoUsuario = new JComboBox<>(tiposUsuario);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formContainer.add(comboTipoUsuario, gbc);
        return comboTipoUsuario;
    }

    private static void showHomeScreen(String tipoUsuario) {
        mainPanel.removeAll();
        
        GridBagConstraints gbc = getGbc();
        JPanel homePanel = new JPanel(new GridBagLayout());
        homePanel.setBackground(Color.decode("#f0f0f0"));

        JLabel welcomeLabel = new JLabel("Bem-vindo, " + tipoUsuario + "!");
        gbc.gridx = 0;
        gbc.gridy = 0;
        homePanel.add(welcomeLabel, gbc);

        // Opções de doação ou visualização de itens
        JButton btnDoar = new JButton("Doar para Instituições");
        gbc.gridx = 0;
        gbc.gridy = 1;
        homePanel.add(btnDoar, gbc);

        JButton btnVerItens = new JButton("Ver itens necessários das Instituições");
        gbc.gridx = 0;
        gbc.gridy = 2;
        homePanel.add(btnVerItens, gbc);

        JButton btnSair = new JButton("Sair da conta");
        gbc.gridx = 0;
        gbc.gridy = 3;
        homePanel.add(btnSair, gbc);

        // Ações
        btnDoar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Opção de Doar selecionada!");
            }
        });

        btnVerItens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Exibindo itens necessários!");
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove todos os componentes do painel atual e exibe a tela de login novamente
                frame.getContentPane().removeAll(); // Remove todos os componentes
                frame.revalidate();  // Revalida o layout
                frame.repaint();  // Redesenha a tela
                showLoginScreen();  // Chama a tela de login
                System.exit(0);
            }
        });

        JScrollPane scrollPane = new JScrollPane(homePanel);
        frame.setContentPane(scrollPane);
        frame.revalidate();
        frame.repaint();
    }

    private static GridBagConstraints getGbc() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        return gbc;
    }

    private static JFrame getFrame() {
        JFrame frame = new JFrame("Sistema de Doações");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(470, 720);
        return frame;
    }
}
