package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import Model.GeradorDeTxt;
import Model.methods;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

//frame de escolha do algoritmo para ordenação
public class escolhaAlgoritmo extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	//entrada com os dados da tela anterior
	public escolhaAlgoritmo(String texto, String caminho, String tempoDeExecucao) {

		int[] aux = methods.stringToInt(texto);

		//texto no botão do JOptionPane	
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.noButtonText", "Não");  
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");

		//opções na seleção do botão X
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int ret = JOptionPane.showConfirmDialog (escolhaAlgoritmo.this, "Deseja encerrar o programa?");
				if (ret == JOptionPane.YES_OPTION) System.exit(0);
			}
		});

		//layout frame
		setTitle("SAPA");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 325);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//layout do painel principal
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(new Color(255, 248, 220));
		contentPane.add(panel, BorderLayout.CENTER);

		//label de informação principal
		JLabel label = new JLabel("Selecione o método que deseja aplicar para ordenação: ");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font("Times new Roman", Font.ITALIC, 16));
		label.setBounds(160, 20, 360, 20);
		panel.add(label);

		//painel com as informações de ordenação
		JPanel tempoDeOrdPanel = new JPanel();
		tempoDeOrdPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tempoDeOrdPanel.setLayout(null);
		tempoDeOrdPanel.setBounds(246, 61, 193, 121);
		panel.add(tempoDeOrdPanel);

		//label com descrição da box
		JLabel tempoDeOrdText = new JLabel("Tempo de ordena\u00E7\u00E3o em ms:");
		tempoDeOrdText.setBorder(new LineBorder(new Color(0, 0, 0)));
		tempoDeOrdText.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		tempoDeOrdText.setBackground(new Color(210, 180, 140));
		tempoDeOrdText.setOpaque(true);
		tempoDeOrdText.setHorizontalAlignment(SwingConstants.CENTER);
		tempoDeOrdText.setHorizontalTextPosition(SwingConstants.CENTER);
		tempoDeOrdText.setBounds(0, 0, 193, 62);
		tempoDeOrdPanel.add(tempoDeOrdText);

		//box com o tempo de ordenação em milessegundos
		JLabel tempoDeOrdBox = new JLabel(tempoDeExecucao);
		tempoDeOrdBox.setHorizontalTextPosition(SwingConstants.CENTER);
		tempoDeOrdBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		tempoDeOrdBox.setHorizontalAlignment(SwingConstants.CENTER);
		tempoDeOrdBox.setBounds(0, 62, 193, 59);
		tempoDeOrdPanel.add(tempoDeOrdBox);

		//botão para ordenação quicksort
		JButton btQuickSort = new JButton("QuickSort");
		btQuickSort.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {

				Thread t = new Thread() {
					@Override
					public void run() {
						String tempo = "";
						long tmpQ = System.currentTimeMillis();
						methods.quick_sort(aux);
						tempo += (System.currentTimeMillis()-tmpQ);
						GeradorDeTxt.geradorTxt(caminho, methods.intToString(aux));
						escolhaAlgoritmo next = new escolhaAlgoritmo(texto, caminho, tempo);
						next.setLocationRelativeTo(null);
						next.setVisible(true);
						dispose();
					}
				};

				tempoDeOrdBox.setText("Carregando...");
				t.start();
			}
		});
		btQuickSort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btQuickSort.setBounds(29, 61, 193, 55);
		btQuickSort.setBackground(new Color(255, 228, 181));
		panel.add(btQuickSort);

		//botão para ordenação bubblesort
		JButton btBubbleSort = new JButton("BubbleSort");
		btBubbleSort.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread() {
					@Override
					public void run() {
						String tempo = "";
						long tmpQ = System.currentTimeMillis();
						methods.bubble_sort(aux);
						tempo += (System.currentTimeMillis()-tmpQ);
						GeradorDeTxt.geradorTxt(caminho, methods.intToString(aux));
						escolhaAlgoritmo next = new escolhaAlgoritmo(texto, caminho, tempo);
						next.setLocationRelativeTo(null);
						next.setVisible(true);
						dispose();
					}
				};

				tempoDeOrdBox.setText("Carregando...");
				t.start();
			}
		});
		btBubbleSort.setBounds(29, 127, 193, 55);
		btBubbleSort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btBubbleSort.setBackground(new Color(255, 228, 181));
		panel.add(btBubbleSort);

		//botão para ordenação insertionsort
		JButton btInsertionSort = new JButton("InsertionSort");
		btInsertionSort.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread() {
					@Override
					public void run() {
						String tempo = "";
						long tmpQ = System.currentTimeMillis();
						methods.insertion_sort(aux);
						tempo += (System.currentTimeMillis()-tmpQ);
						GeradorDeTxt.geradorTxt(caminho, methods.intToString(aux));
						escolhaAlgoritmo next = new escolhaAlgoritmo(texto, caminho, tempo);
						next.setLocationRelativeTo(null);
						next.setVisible(true);
						dispose();
					}
				};

				tempoDeOrdBox.setText("Carregando...");
				t.start();
			}
		});
		btInsertionSort.setBackground(new Color(255, 228, 181));
		btInsertionSort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btInsertionSort.setBounds(464, 61, 193, 55);
		panel.add(btInsertionSort);

		//botão para ordenação heapsort
		JButton btHeapSort = new JButton("HeapSort");
		btHeapSort.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread() {
					@Override
					public void run() {
						String tempo = "";
						long tmpQ = System.currentTimeMillis();
						methods.heap_sort(aux);
						tempo += (System.currentTimeMillis()-tmpQ);
						GeradorDeTxt.geradorTxt(caminho, methods.intToString(aux));
						escolhaAlgoritmo next = new escolhaAlgoritmo(texto, caminho, tempo);
						next.setLocationRelativeTo(null);
						next.setVisible(true);
						dispose();
					}
				};

				tempoDeOrdBox.setText("Carregando...");
				t.start();
			}
		});
		btHeapSort.setBackground(new Color(255, 228, 181));
		btHeapSort.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btHeapSort.setBounds(464, 127, 193, 55);
		panel.add(btHeapSort);

		//label de informação
		JLabel obs = new JLabel("Ap\u00F3s a ordena\u00E7\u00E3o, ser\u00E1 gerado um novo arquivo no local de origem, e o arquivo utilizado como base ser\u00E1 mantido!");
		obs.setForeground(new Color(0, 0, 128));
		obs.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		obs.setBounds(29, 205, 636, 20);
		panel.add(obs);

		//botão para finalizar aplicação
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaFinal next = new telaFinal();
				next.setVisible(true);
				next.setLocationRelativeTo(null);
				dispose();				
			}
		});
		btnNewButton.setBackground(new Color(210, 180, 140));
		btnNewButton.setBounds(464, 236, 195, 32);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		panel.add(btnNewButton);

		//botão para ordenar usando novo arquivo
		JButton btnNovoArquivo = new JButton("Usar novo arquivo para teste");
		btnNovoArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escolhaInicial next = new escolhaInicial();
				next.setVisible(true);
				next.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNovoArquivo.setBackground(new Color(210, 180, 140));
		btnNovoArquivo.setBounds(29, 236, 205, 32);
		btnNovoArquivo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		panel.add(btnNovoArquivo);
	}
}
