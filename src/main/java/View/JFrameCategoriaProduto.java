package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.CategoriaProdutoController;
import Model.CategoriaProduto;


public class JFrameCategoriaProduto extends JFrame {

	private JPanel contentPane;
	private JLabel lblCategoriaDeProduto;
	private JLabel lblNome;
	private JTextField jTextFieldNome;
	private JLabel lblDescricao;
	private JTextArea jTextFieldDescricao;
	private JButton buttonSalvarCategoria;
	private CategoriaProdutoController categoriaProdutoController = new CategoriaProdutoController();
	private CategoriaProduto categoriaProduto = new CategoriaProduto();
	private JButton buttonDeletar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameCategoriaProduto frame = new JFrameCategoriaProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameCategoriaProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(getlblCategoriaDeProdutos());
		contentPane.add(getNome());
		contentPane.add(getTextFieldCodigoProduto());
		contentPane.add(getDescricao());
		contentPane.add(getTextFieldDescricao());
		contentPane.add(getButtonSalvarCategoria());
		contentPane.add(getButtonDeletar());
	}
	
	public JLabel getlblCategoriaDeProdutos() {
		if(lblCategoriaDeProduto == null) {
			lblCategoriaDeProduto = new JLabel();
			lblCategoriaDeProduto.setBounds(110, 10, 175, 22);
			lblCategoriaDeProduto.setForeground(Color.BLACK);
			lblCategoriaDeProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblCategoriaDeProduto.setHorizontalAlignment(SwingConstants.CENTER);
			lblCategoriaDeProduto.setText("Categoria de produtos");
		}
		return lblCategoriaDeProduto;
	}
	
	public JLabel getNome() {
		if(lblNome == null) {
			lblNome = new JLabel();			
			lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNome.setForeground(Color.BLACK);
			lblNome.setLocation(52, 50);
			lblNome.setSize(52, 14); 
			lblNome.setText("Nome: ");
		}
		return lblNome;
	}
	
	public JTextField getTextFieldCodigoProduto() {
		if(jTextFieldNome == null) {
			jTextFieldNome = new JFormattedTextField();
			jTextFieldNome.setLocation(110, 48);
			jTextFieldNome.setSize(260, 22);
		}
		return jTextFieldNome;
	}
	
	public JLabel getDescricao() {
		if(lblDescricao == null) {
			lblDescricao = new JLabel();			
			lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDescricao.setForeground(Color.BLACK);
			lblDescricao.setLocation(27, 100);
			lblDescricao.setSize(77, 14); 
			lblDescricao.setText("Descrição: ");
		}
		return lblDescricao;
	}
	
	public JTextArea getTextFieldDescricao() {
		if(jTextFieldDescricao == null) {
			jTextFieldDescricao = new JTextArea();
			jTextFieldDescricao.setLocation(110, 98);
			jTextFieldDescricao.setSize(260, 85);
			jTextFieldDescricao.setLineWrap(true);
		}
		return jTextFieldDescricao;
	}
	
	public JButton getButtonSalvarCategoria() {
		if(buttonSalvarCategoria == null) {
			buttonSalvarCategoria = new JButton();
			buttonSalvarCategoria.setBounds(110, 200, 129, 22);
			buttonSalvarCategoria.addActionListener(e -> salvarCategoriaProduto());
			buttonSalvarCategoria.setText("Salvar Categoria");
		}
		return buttonSalvarCategoria;
	}
	
	public JButton getButtonDeletar() {
		if(buttonDeletar == null) {
			buttonDeletar = new JButton();
			buttonDeletar.setBounds(240, 200, 129, 22);
			buttonDeletar.addActionListener(e -> deletarCategoriaProduto());
			buttonDeletar.setText("Deletar");
		}
		return buttonDeletar;
	}
	
	public void salvarCategoriaProduto() {
		categoriaProduto.setNome(jTextFieldNome.getText());
		categoriaProduto.setDescricao(jTextFieldDescricao.getText());
		categoriaProdutoController.save(categoriaProduto);
	}
	
	public void deletarCategoriaProduto() {
		categoriaProduto.setNome(jTextFieldNome.getText());
		categoriaProdutoController.remover(categoriaProduto);
	}
}
