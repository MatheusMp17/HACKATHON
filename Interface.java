import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Interface {
    private static ArrayList<Item> doadores = new ArrayList<>();
    private static ArrayList<Item> receptores = new ArrayList<>();

    private static JFrame frame;
    private static JPanel mainPanel;
    private static DoacaoScreen showDoacaoScreen;

    
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
        JOptionPane.showMessageDialog(frame, "Cada vez mais, na atualidade, faz-se presente a problemática relativa às catástrofes climáticas e suas \n" +
"implicações, sejam elas econômicas ou sociais. A exemplo disso, levantamentos do Banco Interamericano de \n" +
"Desenvolvimento (BID) estimam que o prejuízo acarretado pelas enchentes no Rio Grande do Sul, em maio de \n" +
"2024, ultrapassaram R$ 88 bilhões. Paralelamente, dados do Sebrae RS, em parceria com a Secretaria de Es-\n" +
"tado e Desenvolvimento Econômico (Sedec), revelam a falência de 35,71% dos negócios no estado, incluindo \n" +
"micro e pequenas empresas. Ao todo, o fenômeno provocou a morte de 183 pessoas e desaparecimento de 27.\n" +
"Portanto, a fim de amenizar  situação de vulnerabilidade de grande parcela da população gaúcha, bem como \n" +
"a sobrecarga logística do Estado, torna-se imprescindível a ação de um mecanismo de assistência às neces-\n" +
"sidades públicas e privadas provenientes de tais eventos.\n" +
"Nesse sentido, este programa visa à implementação de um sistema operacional de controle de dados voltado\n" +
"ao auxílio das prefeituras dos respectivos municípios afetados pelas enchentes ou qualquer outra futura \n" +
"catástrofe natural. Através dele, será possível determinar, automaticamente, a quantidade necessária de\n" +
"bens para cada instituição de caridade, de modo a facilitar o processo de direcionamento de pedidos e doa-\n" +
"ções entre doadores e destinatários.\n" +
"\n" +
"FUNCIONAMENTO DO SISTEMA OPERACIONAL:\n" +
"A partir do cadastro da pessoa - física (CPF) ou jurídica (CNPJ) - será determinado o intuito do agente\n" +
"em utilizar o sistema, seja ele doar, ou receber. Em seguida, será especificado o tipo de artigo que o a-\n" +
"gente deseja doar ou receber (alimentos, produtos de limpeza, produtos para higiene etc), sendo cada tipo \n" +
"correspondente a um número inteiro predeterminado.\n" +
"Após, serão criadas duas listas, uma para doações e outra para recepções, baseadas nas necessidades espe-\n" +
"cificadas pelos usuários. \n" +
"Por fim, serão estabelecidas as relações lógicas de doação e recebimento entre \n" +
"as duas listas, considerando a quantidade disponível ou não de cada artigo, bem como as localidades que \n" +
"os requisitam.");
        
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
                                showHomeScreen(textCNPJ.getText());
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
        JButton btnDoar = new JButton("Doar");
        gbc.gridx = 0;
        gbc.gridy = 1;
        homePanel.add(btnDoar, gbc);

        JButton btnVerItens = new JButton("Solicitar item");
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
                showDoacaoScreen = new DoacaoScreen(receptores, doadores, Integer.parseInt(tipoUsuario), true);
                 homePanel.removeAll();
                 JScrollPane scrollPaneDoacao = new JScrollPane(showDoacaoScreen); // Usa o painel dentro de um JScrollPane
                 frame.setSize(580, 380);
                 frame.setContentPane(scrollPaneDoacao); // Atualiza o conteúdo da tela com o novo painel
                 frame.revalidate();  // Revalida o layout
                 frame.repaint();  // Redesenha o JFrame
                
                
            }
        });

        btnVerItens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Exibindo itens necessários!");
                showDoacaoScreen = new DoacaoScreen(receptores, doadores, Integer.parseInt(tipoUsuario), false);
                homePanel.removeAll();
                 JScrollPane scrollPaneDoacao = new JScrollPane(showDoacaoScreen); // Usa o painel dentro de um JScrollPane
                 frame.setSize(580, 380);
                 frame.setContentPane(scrollPaneDoacao); // Atualiza o conteúdo da tela com o novo painel
                 frame.revalidate();  // Revalida o layout
                 frame.repaint();  // Redesenha o JFrame

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