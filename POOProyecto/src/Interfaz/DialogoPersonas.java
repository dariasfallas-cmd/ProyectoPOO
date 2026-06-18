package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DialogoPersonas extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTable tablePersonas;

	public static void main(String[] args) {
		try {
			DialogoPersonas dialog = new DialogoPersonas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoPersonas() {
		setTitle("Administración de Personas - WallRose");
		setBounds(100, 100, 480, 380); 
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 15, 60, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, 12, 360, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(10, 45, 60, 14);
		contentPanel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(80, 42, 360, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(10, 75, 65, 14);
		contentPanel.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(80, 72, 360, 20);
		contentPanel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 430, 170);
		contentPanel.add(scrollPane);
		
		tablePersonas = new JTable();
		scrollPane.setViewportView(tablePersonas);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
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