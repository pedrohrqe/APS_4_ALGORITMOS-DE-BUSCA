package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.JButton;

public class telaInicial extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public telaInicial() {

		//texto no botão do JOptionPane	
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");  
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");

		//opções na seleção do botão X
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int ret = JOptionPane.showConfirmDialog (telaInicial.this, "Deseja encerrar o programa?");
				if (ret == JOptionPane.YES_OPTION) System.exit(0);
			}
		});

		//propriedades do frame
		setTitle("SAPA");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 280);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//painel principal
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 248, 220));
		contentPane.add(panel, BorderLayout.CENTER);

		//label informativa
		JLabel label = new JLabel("Bem vindo ao sistema para an\u00E1lise de performance de algoritmos de ordena\u00E7\u00E3o de dados ");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font("Times new Roman", Font.ITALIC, 16));
		label.setBounds(50, 50, 580, 20);
		panel.add(label);

		//botão para inciar a aplicação
		JButton iniciar = new JButton("Iniciar");
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escolhaInicial next = new escolhaInicial();
				next.setVisible(true);
				next.setLocationRelativeTo(null);
				dispose();
			}
		});
		iniciar.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		iniciar.setBackground(new Color(210, 180, 140));
		iniciar.setBounds(80, 150, 245, 50);
		panel.add(iniciar);
		
		//botão sair para encerrar a aplicação
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		sair.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		sair.setBackground(new Color(210, 180, 140));
		sair.setBounds(350, 150, 245, 50);
		panel.add(sair);
	}
}
