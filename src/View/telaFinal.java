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

public class telaFinal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public telaFinal() {

		//texto no botão do JOptionPane	
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");  
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");

		//opções na seleção do botão X
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int ret = JOptionPane.showConfirmDialog (telaFinal.this, "Deseja encerrar o programa?");
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

		//label informativa salvamento
		JLabel lb1 = new JLabel("Esta aplica\u00E7\u00E3o foi desenvolvida para teste de tempo de resposta de algoritmos de ordena\u00E7\u00E3o, com");
		lb1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lb1.setFont(new Font("Times new Roman", Font.ITALIC, 16));
		lb1.setBounds(20, 11, 639, 32);
		panel.add(lb1);

		//botão para sair da aplicação
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar a aplicação!");
				System.exit(0);
			}
		});
		btSair.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btSair.setBounds(519, 191, 155, 39);
		btSair.setBackground(new Color(210, 180, 140));
		panel.add(btSair);

		//informações1
		JLabel lb2 = new JLabel("ela podemos verificar um pouco da diferen\u00E7a do tempo de resposta dentre alguns algoritmos dos\r\n");
		lb2.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lb2.setBounds(20, 34, 639, 32);
		panel.add(lb2);

		//informações2
		JLabel lb3 = new JLabel("quais selecionamos.");
		lb3.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lb3.setBounds(20, 64, 487, 20);
		panel.add(lb3);

		//informações3
		JLabel lb4 = new JLabel("Aplica\u00E7\u00E3o desenvolvida para atividade pr\u00E1tica supervisionada / C.C. 4\u00B0 semestre/ Feito por:");
		lb4.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lb4.setBounds(20, 137, 639, 25);
		panel.add(lb4);

		//informações4
		JLabel lb5 = new JLabel("Pedro Henrique (F037711 - CC4P07) e Luis Guilherme (N6323G1 - CC4Q07) / UNIP 2021");
		lb5.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lb5.setBounds(20, 162, 597, 20);
		panel.add(lb5);
	}

}
