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

public class DialogoTipos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtDescripcionTipo;
	private JTable tableTipos;

	public static void main(String[] args) {
		try {
			DialogoTipos dialog = new DialogoTipos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogoTipos() {
		setTitle("Tipos de Ítems");
		setBounds(100, 100, 480, 380); 
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblTipo = new JLabel("Tipo / Formato:");
		lblTipo.setBounds(10, 15, 100, 14);
		contentPanel.add(lblTipo);
		
		txtDescripcionTipo = new JTextField();
		txtDescripcionTipo.setBounds(120, 12, 320, 20);
		contentPanel.add(txtDescripcionTipo);
		txtDescripcionTipo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 430, 230);
		contentPanel.add(scrollPane);
		
		tableTipos = new JTable();
		scrollPane.setViewportView(tableTipos);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonPane.add(btnGuardar);
		
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