package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import Model.CapturaDeTxt;
import Model.methods;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class escolhaInicial extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	public escolhaInicial() {

		//texto no botão do JOptionPane	
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");  
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");

		//opções na seleção do botão X
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int ret = JOptionPane.showConfirmDialog (escolhaInicial.this, "Deseja encerrar o programa?");
				if (ret == JOptionPane.YES_OPTION) System.exit(0);
			}
		});

		//layout frame
		setTitle("SAPA");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

		//label de orientação 1
		JLabel label = new JLabel("Para que possamos seguir, é necessário um arquivo para análise. Você pode optar por");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font("Times new Roman", Font.ITALIC, 16));
		label.setBounds(50, 50, 580, 20);
		panel.add(label);

		//label de orientação 2
		JLabel label1 = new JLabel("criar ou selecionar um arquivo (o arquivo precisa ser de inteiros, seperados por ';').");
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label1.setFont(new Font("Times new Roman", Font.ITALIC, 16));
		label1.setBounds(50, 80, 580, 20);
		panel.add(label1);

		//botão para gerar arquivo txt
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCriacaoTxt next = new telaCriacaoTxt();
				next.setVisible(true);
				next.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(80, 150, 245, 50);
		btnNewButton.setBackground(new Color(210, 180, 140));
		panel.add(btnNewButton);

		//botão para selecionar arquivo para análise
		JButton btnNewButton1 = new JButton("Selecionar");
		btnNewButton1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser sel = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivo de texto .txt","txt");
				sel.setFileFilter(filtro);
				sel.setDialogTitle("Selecione o arquivo .txt");
				sel.setVisible(true);
				File file = new File("");
				String texto  =""; 
				String caminho = "";

				int resposta = sel.showOpenDialog(new JDialog());

				if (resposta == JFileChooser.APPROVE_OPTION) {
					file = sel.getSelectedFile();
					caminho = file.getParent()+"\\Valores Ordenados.txt";
					texto = CapturaDeTxt.leitorTxt(file.getPath());
					JOptionPane.showMessageDialog(null, "Arquivo carregado com sucesso");

					if(methods.stringToInt(texto) == null) {
						JOptionPane.showMessageDialog(null, "Arquivo Inválido! Selecione novamente ou gere um novo");
					}
					else {
						escolhaAlgoritmo next = new escolhaAlgoritmo(texto, caminho, "...");
						next.setLocationRelativeTo(null);
						next.setVisible(true);
						dispose();
					}

				}
				else if (resposta == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Cancelado! Selecione a opção novamente");
				}

			}
		});
		btnNewButton1.setBounds(350, 150, 245, 50);
		btnNewButton1.setBackground(new Color(210, 180, 140));
		panel.add(btnNewButton1);
	}

}
