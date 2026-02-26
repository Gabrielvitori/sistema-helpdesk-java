package application;

import dao.ChamadoDAO;
import model.Chamado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import com.formdev.flatlaf.FlatLightLaf;

public class TelaSuporte extends JFrame {

    private JLabel labelPC;
    private JComboBox<String> comboProblema;
    private JTextArea textoDescricao;

    public TelaSuporte() {
        setTitle("Abrir chamado para o Suporte");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        JLabel titulo = new JLabel("SOLICITAR AJUDA DO TI");
        titulo.setBounds(110, 10, 200, 20);
        add(titulo);

        String nomeComputador = "Desconhecido";
        try {
            nomeComputador = InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }

        labelPC = new JLabel("Computador: " + nomeComputador);
        labelPC.setBounds(20, 40, 300, 20);
        add(labelPC);

        String[] opcoes = {"Internet Caiu", "Computador Travando", "Impressora", "Software/Sistema", "Outros"};
        comboProblema = new JComboBox<>(opcoes);
        comboProblema.setBounds(20, 95, 340, 30);
        add(comboProblema);

        JLabel labelDesc = new JLabel("Detalhes (Opcional):");
        labelDesc.setBounds(20, 135, 200, 20);
        add(labelDesc);

        textoDescricao = new JTextArea();
        textoDescricao.setBorder(BorderFactory.createEtchedBorder());
        textoDescricao.setBounds(20, 160, 340, 80);
        add(textoDescricao);

        JButton btnEnviar = new JButton("CHAMAR TÉCNICO");
        btnEnviar.setBounds(100, 260, 180, 40);
        add(btnEnviar);

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarNoBanco();
            }
        });
    }
    private void salvarNoBanco() {
        try {
            String pc = labelPC.getText().replace("Computador: ", "");
            String problema = (String) comboProblema.getSelectedItem();
            String descricao = textoDescricao.getText();

            Chamado novoChamado = new Chamado(pc, problema, descricao);

            ChamadoDAO dao = new ChamadoDAO();
            dao.salvar(novoChamado);

            JOptionPane.showMessageDialog(TelaSuporte.this, "Chamado aberto com sucesso!");
            textoDescricao.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            FlatLightLaf.setup();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new TelaSuporte().setVisible(true);
    }
}