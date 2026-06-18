package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DialogoPrestamos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEmailPersona;
	private JTextField txtCodigoItem;
	private JTextField txtDiasPlazo;
	private JTable tablePrestamos;

	public static void main(String[] args) {
		try {
			DialogoPrestamos dialog = new DialogoPrestamos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoPrestamos() {
		setTitle("Registro de Préstamos");
		setBounds(100, 100, 480, 380); 
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblEmail = new JLabel("Email persona:");
		lblEmail.setBounds(10, 15, 90, 14);
		contentPanel.add(lblEmail);
		
		txtEmailPersona = new JTextField();
		txtEmailPersona.setBounds(110, 12, 330, 20);
		contentPanel.add(txtEmailPersona);
		
		JLabel lblCodigo = new JLabel("Código Ítem:");
		lblCodigo.setBounds(10, 45, 90, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigoItem = new JTextField();
		txtCodigoItem.setBounds(110, 42, 330, 20);
		contentPanel.add(txtCodigoItem);
		
		JLabel lblDias = new JLabel("Días Plazo:");
		lblDias.setBounds(10, 75, 90, 14);
		contentPanel.add(lblDias);
		
		txtDiasPlazo = new JTextField();
		txtDiasPlazo.setBounds(110, 72, 330, 20);
		contentPanel.add(txtDiasPlazo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 430, 170);
		contentPanel.add(scrollPane);
		
		tablePrestamos = new JTable();
		scrollPane.setViewportView(tablePrestamos);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnPrestar = new JButton("Prestar");
		buttonPane.add(btnPrestar);
		
		JButton btnDevolver = new JButton("Devolver");
		buttonPane.add(btnDevolver);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 			
			}
		});
		buttonPane.add(btnCerrar);
	} 
}