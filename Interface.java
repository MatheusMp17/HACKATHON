import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface {
    public static void main(String[] args) {
        // Define o look and feel do sistema operacional (opcional)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
