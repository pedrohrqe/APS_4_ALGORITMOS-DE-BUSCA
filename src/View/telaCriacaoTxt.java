package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Model.CapturaDeTxt;
import Model.GeradorDeTxt;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class telaCriacaoTxt extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField valor1;
	private JTextField valor2;

	public telaCriacaoTxt() {

		//texto no botão do JOptionPane	
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");  
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");

		//opções na seleção do botão X
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int ret = JOptionPane.showConfirmDialog (telaCriacaoTxt.this, "Deseja encerrar o programa?");
				if (ret == JOptionPane.YES_OPTION) System.exit(0);
			}
		});

		//propriedades do frame
		setTitle("SAPA");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 258);
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
		JLabel localDeSalvamento = new JLabel("Selecione o local para salvar o arquivo");
		localDeSalvamento.setBackground(new Color(255, 255, 255));
		localDeSalvamento.setOpaque(true);
		localDeSalvamento.setBorder(new LineBorder(new Color(0, 0, 0)));
		localDeSalvamento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		localDeSalvamento.setHorizontalTextPosition(SwingConstants.CENTER);
		localDeSalvamento.setHorizontalAlignment(SwingConstants.LEFT);
		localDeSalvamento.setBounds(25, 175, 387, 33);
		panel.add(localDeSalvamento);

		//label informativa
		JLabel lblInformeDoisValores = new JLabel("Informe dois valores inteiros, o tamanho limite dos inteiros e quantos inteiros respectivamente:");
		lblInformeDoisValores.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInformeDoisValores.setFont(new Font("Times new Roman", Font.ITALIC, 16));
		lblInformeDoisValores.setBounds(37, 36, 619, 20);
		panel.add(lblInformeDoisValores);

		//limite de valor dos inteiros
		valor1 = new JTextField();
		valor1.setHorizontalAlignment(SwingConstants.CENTER);
		valor1.setBounds(152, 77, 111, 33);
		panel.add(valor1);
		valor1.setColumns(10);

		//quantos inteiros
		valor2 = new JTextField();
		valor2.setHorizontalAlignment(SwingConstants.CENTER);
		valor2.setBounds(152, 121, 111, 33);
		panel.add(valor2);
		valor2.setColumns(10);

		//log com informações da tela
		JLabel log = new JLabel("");
		log.setBackground(new Color(211, 211, 211));
		log.setOpaque(true);
		log.setBorder(new LineBorder(new Color(0, 0, 0)));
		log.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		log.setHorizontalTextPosition(SwingConstants.CENTER);
		log.setHorizontalAlignment(SwingConstants.CENTER);
		log.setBounds(321, 98, 284, 33);
		panel.add(log);

		//procurar local de salvamento
		JButton destino = new JButton("...");
		destino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser sel = new JFileChooser();
				sel.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				sel.setDialogTitle("Selecione o destino");
				sel.setVisible(true);

				int resposta = sel.showOpenDialog(new JDialog());

				if (resposta == JFileChooser.APPROVE_OPTION) {
					File file = sel.getSelectedFile();
					localDeSalvamento.setText(file.getPath()+"\\");
					JOptionPane.showMessageDialog(null, "Selecionado Local");
				}
				else if (resposta == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Cancelado");
				}	
			}
		});
		destino.setBackground(new Color(210, 180, 140));
		destino.setFont(new Font("Times New Roman", Font.BOLD, 12));
		destino.setBounds(422, 175, 63, 33);
		panel.add(destino);

		//botão para gerar o arquivo no local indicado
		JButton gerar = new JButton("Gerar Arquivo");
		gerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (localDeSalvamento.getText() != "Selecione o local para salvar o arquivo") {
					if (valor1.getText().isEmpty() || valor2.getText().isEmpty()) {
						log.setText("Valores Incorretos, informe novamente!");
					}
					else if (!valor1.getText().isEmpty() && !valor2.getText().isEmpty()) {
						if (Integer.parseInt(valor1.getText()) > (int)0 && Integer.parseInt(valor2.getText()) > (int)0) {
							Thread t = new Thread() {
								@Override
								public void run() {
									File file1 = new File(localDeSalvamento.getText()+"Valores aleatórios.txt");
									GeradorDeTxt.geradorTxt(file1.getPath(),Integer.parseInt(valor1.getText()),Integer.parseInt(valor2.getText()));
									log.setText("Arquivo Gerado!");
									log.setText("Preparando arquivo para ordenação...");
									String aux = CapturaDeTxt.leitorTxt(file1.getPath());
									escolhaAlgoritmo next = new escolhaAlgoritmo(aux, (file1.getParent()+"\\Valores Ordenados.txt"),"...");
									next.setVisible(true);
									next.setLocationRelativeTo(null);
									dispose();
								};
							};
							log.setText("Gerando arquivo...");
							t.start();
						}
						else {
							log.setText("Valores Incorretos, informe novamente!");
						}
					}
				}
				else {
					log.setText("Local de salvamento não selecionado!");
				}
			}
		});
		gerar.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		gerar.setBounds(495, 175, 164, 33);
		gerar.setBackground(new Color(210, 180, 140));
		panel.add(gerar);
	}
}
