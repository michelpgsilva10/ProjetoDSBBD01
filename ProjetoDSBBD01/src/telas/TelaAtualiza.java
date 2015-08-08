package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.GrupoProduto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextPane;

public class TelaAtualiza extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane textPane;

	/**
	 * Create the dialog.
	 */
	public TelaAtualiza(Connection conexao, GrupoProduto produto) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textPane = new JTextPane();
		contentPanel.add(textPane);
		textPane.setText(produto.getNome());

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				okButton_actionPerformed(e, conexao);

			}
		});

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);	

	}

	protected void okButton_actionPerformed(ActionEvent e, Connection conexao) {
		// TODO Auto-generated method stub
		PreparedStatement comando = null;
		String nome = textPane.getText();

		try {
			comando = conexao
					.prepareStatement("UPDATE GRUPOPRODUTO" + " SET NOME=?");
			System.out.println(comando.getWarnings());

			comando.setString(1, nome);

			JOptionPane.showMessageDialog(this, "Registro atualizado com sucesso");

			// this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			this.dispose();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Não foi possível atualizar");
		}

	}

}
