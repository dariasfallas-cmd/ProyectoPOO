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

public class DialogoItems extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTable tableItems;

	public static void main(String[] args) {
		try {
			DialogoItems dialog = new DialogoItems();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoItems() {
		setTitle(" Ítems");
		setBounds(100, 100, 480, 380); 
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 15, 60, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(80, 12, 360, 20);
		contentPanel.add(txtCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 60, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, 42, 360, 20);
		contentPanel.add(txtNombre);
		
		JLabel lblDesc = new JLabel("Descripción:");
		lblDesc.setBounds(10, 75, 75, 14);
		contentPanel.add(lblDesc);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(90, 72, 350, 20);
		contentPanel.add(txtDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 430, 170);
		contentPanel.add(scrollPane);
		
		tableItems = new JTable();
		scrollPane.setViewportView(tableItems);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnGuardar = new JButton("Guardar");
		buttonPane.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		buttonPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		buttonPane.add(btnEliminar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 			
			}
		});
		buttonPane.add(btnCerrar);
	} 
}