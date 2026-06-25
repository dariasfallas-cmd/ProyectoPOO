package Interfaz;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import logica.Controladora;

public class Principal extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        try {
            Principal frame = new Principal();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Principal() {
        setTitle("Sistema de Gestión de Préstamos Bancarios - TEC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 400);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPane.setLayout(new BorderLayout(0, 20));
        setContentPane(contentPane);


        JLabel lblTitulo = new JLabel("CONTROL DE PRÉSTAMOS BANCARIOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 0, 15));
        contentPane.add(panelBotones, BorderLayout.CENTER);

        
        JButton btnRegistrarCliente = new JButton("1. Registrar Cliente Nuevo (Persona)");
        btnRegistrarCliente.setFont(new Font("Arial", Font.PLAIN, 14));
        panelBotones.add(btnRegistrarCliente);

        
        JButton btnAgregarItem = new JButton("2. Agregar Tipo de Crédito (Ítem)");
        btnAgregarItem.setFont(new Font("Arial", Font.PLAIN, 14));
        panelBotones.add(btnAgregarItem);

        
        JButton btnRegistrarPrestamo = new JButton("3. Otorgar Préstamo Bancario");
        btnRegistrarPrestamo.setFont(new Font("Arial", Font.BOLD, 14));
        panelBotones.add(btnRegistrarPrestamo);

        
        JButton btnDevolucion = new JButton("4. Procesar Cancelación / Devolución de Crédito");
        btnDevolucion.setFont(new Font("Arial", Font.PLAIN, 14));
        panelBotones.add(btnDevolucion);


  //ACCIONES
        btnRegistrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el Nombre del Cliente:", "Registro de Cliente", JOptionPane.QUESTION_MESSAGE);
                if (nombre == null || nombre.trim().isEmpty()) return;

                String telefono = JOptionPane.showInputDialog(null, "Ingrese el Teléfono:", "Registro de Cliente", JOptionPane.QUESTION_MESSAGE);
                if (telefono == null || telefono.trim().isEmpty()) return;

                String correo = JOptionPane.showInputDialog(null, "Ingrese el Correo Electrónico Único:", "Registro de Cliente", JOptionPane.QUESTION_MESSAGE);
                if (correo == null || correo.trim().isEmpty()) return;

                // Llama a tu controladora en singular
                Controladora.getInstancia().registrarPersona(nombre, telefono, correo);
                JOptionPane.showMessageDialog(null, "¡Cliente registrado con éxito en el sistema!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        
        btnAgregarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog(null, "Ingrese el Código Único del Ítem:", "Catálogo de Créditos", JOptionPane.QUESTION_MESSAGE);
                if (codigo == null || codigo.trim().isEmpty()) return;

                String nombre = JOptionPane.showInputDialog(null, "Nombre del Crédito (Ej: Fiduciario, Hipotecario):", "Catálogo de Créditos", JOptionPane.QUESTION_MESSAGE);
                if (nombre == null || nombre.trim().isEmpty()) return;

                String desc = JOptionPane.showInputDialog(null, "Descripción o Condiciones:", "Catálogo de Créditos", JOptionPane.QUESTION_MESSAGE);
                if (desc == null || desc.trim().isEmpty()) return;

                String tipo = JOptionPane.showInputDialog(null, "Tipo de Línea de Crédito:", "Catálogo de Créditos", JOptionPane.QUESTION_MESSAGE);
                if (tipo == null || tipo.trim().isEmpty()) return;

                Controladora.getInstancia().agregarItem(codigo, nombre, desc, tipo);
                JOptionPane.showMessageDialog(null, "¡Tipo de Crédito incorporado al catálogo!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        
        btnRegistrarPrestamo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idPrestamo = JOptionPane.showInputDialog(null, "Asigne un ID único a este Préstamo:", "Apertura de Crédito", JOptionPane.QUESTION_MESSAGE);
                if (idPrestamo == null || idPrestamo.trim().isEmpty()) return;

                String correo = JOptionPane.showInputDialog(null, "Ingrese el Correo del Cliente Solicitante:", "Apertura de Crédito", JOptionPane.QUESTION_MESSAGE);
                if (correo == null || correo.trim().isEmpty()) return;

                String codItem = JOptionPane.showInputDialog(null, "Ingrese el Código del Ítem/Crédito a asignar:", "Apertura de Crédito", JOptionPane.QUESTION_MESSAGE);
                if (codItem == null || codItem.trim().isEmpty()) return;

                // El método registrarPrestamo de tu controladora validará automáticamente si está disponible
                Controladora.getInstancia().registrarPrestamo(idPrestamo, correo, codItem, new java.util.Date());
                JOptionPane.showMessageDialog(null, "¡Préstamo bancario generado y asociado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        
        btnDevolucion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idPrestamo = JOptionPane.showInputDialog(null, "Ingrese el ID del Préstamo a finalizar/cancelar:", "Cierre de Crédito", JOptionPane.QUESTION_MESSAGE);
                if (idPrestamo == null || idPrestamo.trim().isEmpty()) return;

                
                Controladora.getInstancia().registrarDevolucion(idPrestamo);
                JOptionPane.showMessageDialog(null, "¡Crédito procesado! Registro removido e ítem liberado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}

