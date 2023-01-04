package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import Controller.CategoriaProdutoDAO;
import Controller.CategoriaProdutoDAOImpl;
import Controller.ProdutoDAO;
import Controller.ProdutoDAOImpl;
import Model.CategoriaProduto;
import Model.CategoriaProdutoEnum;
import Model.Produto;


public class JFrameProduto extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblProduto;
	private JLabel lblNome;
	private JTextField jTextFieldNome;
	private JLabel lblDescricao;
	private JTextArea jTextFieldDescricao;
	private JLabel lblQuantidade;
	private JFormattedTextField jTextFieldQuantidade;
	private JLabel lblCusto;
	private JFormattedTextField jTextFieldCusto;
	private JLabel lblVlrFinal;
	private JFormattedTextField jTextFieldVlrFinal;
	private JButton buttonIncluir;
	private Produto produto = new Produto();
	private JLabel lblCategoriaProduto;
	private JComboBox categoriaProduto;
	private CategoriaProduto categoriaProdutoModel = new CategoriaProduto();
	private CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAOImpl();
	
	private ProdutoDAO produtoDAO = new ProdutoDAOImpl();

	public JFrameProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getlblProdutos());
		contentPane.add(getNome());
		contentPane.add(getTextFieldNomeDoProduto());
		contentPane.add(getDescricao());
		contentPane.add(getTextFieldDescricao());
		contentPane.add(getQuantidade());
		contentPane.add(getTextFieldQuantidade());
		contentPane.add(getLblCusto());
		contentPane.add(getTextFieldCusto());
		contentPane.add(getLblVlrFinal());
		contentPane.add(getTextFieldVlrFinal());
		contentPane.add(getButtonIncluir());
		contentPane.add(getButtonCategoria());
		contentPane.add(getLblCategoriaProduto());
		
		JPanel panelLinha = new JPanel();
		panelLinha.setBounds(10, 181, 401, 10);
		panelLinha.setSize(419, 5);
		panelLinha.setPreferredSize(new Dimension(419, 5));
		panelLinha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		contentPane.add(panelLinha);
	}
	
	public JLabel getlblProdutos() {
		if(lblProduto == null) {
			lblProduto = new JLabel();
			lblProduto.setBounds(134, 10, 70, 22);
			lblProduto.setForeground(Color.BLACK);
			lblProduto.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblProduto.setHorizontalAlignment(SwingConstants.CENTER);
			lblProduto.setText("Produtos");
		}
		return lblProduto;
	}
	
	public JLabel getNome() {
		if(lblNome == null) {
			lblNome = new JLabel();			
			lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNome.setForeground(Color.BLACK);
			lblNome.setLocation(-14, 47);
			lblNome.setSize(132, 14); 
			lblNome.setText("Nome do produto: ");
		}
		return lblNome;
	}
	
	public JTextField getTextFieldNomeDoProduto() {
		if(jTextFieldNome == null) {
			jTextFieldNome = new JFormattedTextField();
			jTextFieldNome.setLocation(119, 43);
			jTextFieldNome.setSize(292, 22);
		}
		return jTextFieldNome;
	}
	
	public JLabel getDescricao() {
		if(lblDescricao == null) {
			lblDescricao = new JLabel();			
			lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDescricao.setForeground(Color.BLACK);
			lblDescricao.setLocation(-14, 85);
			lblDescricao.setSize(132, 14); 
			lblDescricao.setText("Descrição: ");
		}
		return lblDescricao;
	}
	
	public JTextArea getTextFieldDescricao() {
		if(jTextFieldDescricao == null) {
			jTextFieldDescricao = new JTextArea();
			jTextFieldDescricao.setLocation(119, 85);
			jTextFieldDescricao.setSize(292, 85);
			jTextFieldDescricao.setLineWrap(true);
		}
		return jTextFieldDescricao;
	}
	
	public JLabel getQuantidade() {
		if(lblQuantidade == null) {
			lblQuantidade = new JLabel();			
			lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
			lblQuantidade.setForeground(Color.BLACK);
			lblQuantidade.setLocation(-14, 190);
			lblQuantidade.setSize(132, 14); 
			lblQuantidade.setText("Quantidade: ");
		}
		return lblQuantidade;
	}
	
	public JFormattedTextField getTextFieldQuantidade() {
		if(jTextFieldQuantidade == null) {
			jTextFieldQuantidade = new JFormattedTextField();
			jTextFieldQuantidade.setLocation(120, 188);
			jTextFieldQuantidade.setSize(56, 22);
			jTextFieldQuantidade.setHorizontalAlignment(jTextFieldQuantidade.RIGHT);
		}
		return jTextFieldQuantidade;
	}
	
	public JLabel getLblCusto() {
		if(lblCusto == null) {
			lblCusto = new JLabel();			
			lblCusto.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCusto.setForeground(Color.BLACK);
			lblCusto.setLocation(-14, 220);
			lblCusto.setSize(132, 14); 
			lblCusto.setText("Custo: ");
		}
		return lblCusto;
	}
	
	public JFormattedTextField getTextFieldCusto() {
		if(jTextFieldCusto == null) {
			jTextFieldCusto = new JFormattedTextField();
			jTextFieldCusto.setLocation(120, 217);
			jTextFieldCusto.setSize(56, 22);
			jTextFieldCusto.setHorizontalAlignment(jTextFieldCusto.RIGHT);	
			jTextFieldCusto.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					if(jTextFieldCusto.getText().trim().isEmpty() ||
							jTextFieldCusto.getText().length() != 0) {
								calcularVlrFinal();
						
					}
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
				}
			});
//			jTextFieldCusto.setFormatterFactory(new AbstractFormatterFactory() {

		       //     @Override
		     //       public AbstractFormatter getFormatter(JFormattedTextField tf) {
		     //           DecimalFormat format = new DecimalFormat();
		        //        format.setMinimumFractionDigits(2);
		      //          format.setMaximumFractionDigits(2);
		      //          format.setRoundingMode(RoundingMode.HALF_UP);

		          //      DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(getLocale());
		            //    otherSymbols.setDecimalSeparator('.');

		              //  format.setDecimalFormatSymbols(otherSymbols);
		              //  NumberFormatter formatter = new NumberFormatter(format);
		              //  formatter.setAllowsInvalid(false);
		            //    formatter.setMinimum(0.00);
		           //     formatter.setMaximum(9.99);
		              //  return formatter;
		          //  }

		       // });			
		}
		return jTextFieldCusto;
	}
	
	public JLabel getLblVlrFinal() {
		if(lblVlrFinal == null) {
			lblVlrFinal = new JLabel();			
			lblVlrFinal.setHorizontalAlignment(SwingConstants.RIGHT);
			lblVlrFinal.setForeground(Color.BLACK);
			lblVlrFinal.setLocation(134, 222);
			lblVlrFinal.setSize(132, 14); 
			lblVlrFinal.setText("Valor final: ");
		}
		return lblVlrFinal;
	}
	
	public JFormattedTextField getTextFieldVlrFinal() {
		if(jTextFieldVlrFinal == null) {
			jTextFieldVlrFinal = new JFormattedTextField();
			jTextFieldVlrFinal.setLocation(269, 220);
			jTextFieldVlrFinal.setSize(95, 22);
			jTextFieldVlrFinal.setEditable(false);
			jTextFieldVlrFinal.setEnabled(false);
			jTextFieldVlrFinal.setHorizontalAlignment(jTextFieldVlrFinal.RIGHT);	
		}
		return jTextFieldVlrFinal;
	}
	
	private void calcularVlrFinal() {
		if(jTextFieldCusto.getText().trim().isEmpty() ||
				jTextFieldCusto.getText().length() != 0) {
			DecimalFormat df = new DecimalFormat("0.00");
			BigDecimal vlrCusto = new BigDecimal(Integer.parseInt(String.valueOf(jTextFieldCusto.getText())));
			BigDecimal porcentagem = new BigDecimal(1.0);
			jTextFieldVlrFinal.setText((vlrCusto.add(porcentagem).toString()));
		}
	}
	
	public JButton getButtonIncluir() {
		if(buttonIncluir == null) {
			buttonIncluir = new JButton();
			buttonIncluir.setBounds(115, 248, 82, 22);
			buttonIncluir.addActionListener(e -> salvarProduto());
			buttonIncluir.setText("Incluir");
		}
		return buttonIncluir;
	}
	
	public void salvarProduto() {
		DecimalFormat df = new DecimalFormat("0.00");
		BigDecimal vlrCusto = new BigDecimal(jTextFieldCusto.getText());
		BigDecimal vlrFinal = new BigDecimal(jTextFieldVlrFinal.getText());
		produto.setNome(jTextFieldNome.getText());
		produto.setDescricao(jTextFieldDescricao.getText());
		produto.setQuantidade(Integer.parseInt(jTextFieldQuantidade.getText()));
		produto.setCusto(vlrCusto);
		produto.setValor(vlrFinal);
		int categoria = categoriaProduto.getSelectedIndex();
		categoriaProdutoModel = categoriaProdutoDAO.load(categoria);
		produto.setCategoriaProduto(categoriaProdutoModel);
		produtoDAO.save(produto);
	}
	
	public JComboBox getButtonCategoria() {
		if(categoriaProduto == null) {
			categoriaProduto = new JComboBox();
			categoriaProduto.setModel(new DefaultComboBoxModel(CategoriaProdutoEnum.values()));
			categoriaProduto.setBounds(269, 188, 95, 22);
		}
		return categoriaProduto;
	}
	
	public JLabel getLblCategoriaProduto() {
		if(lblCategoriaProduto == null) {
			lblCategoriaProduto = new JLabel();			
			lblCategoriaProduto.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCategoriaProduto.setForeground(Color.BLACK);
			lblCategoriaProduto.setLocation(171, 193);
			lblCategoriaProduto.setSize(95, 14); 
			lblCategoriaProduto.setText("Categoria: ");
		}
		return lblCategoriaProduto;
	}
}
