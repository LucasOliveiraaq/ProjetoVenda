package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuInicial extends JFrame {
	
	JMenuBar barra = new JMenuBar();
	JMenu menu1 = new JMenu("Cadastrar");
	JMenu menu2 = new JMenu("Sair");
	
	JMenuItem item1 = new JMenuItem("Categoria");
	
	public MenuInicial() {
		setJMenuBar(barra);
		barra.add(menu1);
		barra.add(menu2);
		menu1.add(item1);
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrameCategoriaProduto jFrameCategoriaProduto = new JFrameCategoriaProduto();
				jFrameCategoriaProduto.setVisible(true);
				jFrameCategoriaProduto.setLocationRelativeTo(null);

			}
		});
		setTitle("Menu inicial do sistema");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
	    try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
        				IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex  ) {
        	System.err.println(ex);
        }
		new MenuInicial();
	}

}
