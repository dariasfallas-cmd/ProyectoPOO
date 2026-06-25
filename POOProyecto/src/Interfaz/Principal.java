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
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import logica.Controladora;

public class Principal extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        try {
            // alerta obligatoria
            JOptionPane.showMessageDialog(null, 
                "SISTEMA DE PRESTAMOS\n\nNo hay préstamos vencidos en este momento.", 
                "Alertas del Sistema - TEC", 
                JOptionPane.WARNING_MESSAGE);
                
            Principal frame = new Principal();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Principal() {
        setTitle("Sistema de Control de Préstamos - TEC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        setLocationRelativeTo(null); 

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(0, 10));
        setContentPane(contentPane);

       
        JLabel lblTitulo = new JLabel("PROGRAMA DE CONTROL DE PRÉSTAMOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        
        JTabbedPane pestañas = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(pestañas, BorderLayout.CENTER);

        JPanel panelPersonas = new JPanel(new GridLayout(3, 1, 10, 20));
        panelPersonas.setBorder(new EmptyBorder(30, 50, 30, 50));
        JButton btnCrearPersona = new JButton("Registrar Nueva Persona (Cliente)");
        JButton btnEliminarPersona = new JButton("Borrar Persona del Sistema");
        
        panelPersonas.add(new JLabel("Administración de Prestatarios:", SwingConstants.CENTER));
        panelPersonas.add(btnCrearPersona);
        panelPersonas.add(btnEliminarPersona);
        pestañas.addTab("Personas", panelPersonas);

        JPanel panelItems = new JPanel(new GridLayout(3, 1, 10, 20));
        panelItems.setBorder(new EmptyBorder(30, 50, 30, 50));
        JButton btnCrearItem = new JButton("Registrar Nuevo Ítem en el Catálogo");
        JButton btnEliminarItem = new JButton("Dar de Baja / Borrar Ítem");
        
        panelItems.add(new JLabel("Catálogo de Objetos (Libros, Videojuegos, Revistas, etc):", SwingConstants.CENTER));
        panelItems.add(btnCrearItem);
        panelItems.add(btnEliminarItem);
        pestañas.addTab("Ítems", panelItems);

        JPanel panelPrestamos = new JPanel(new GridLayout(3, 1, 10, 20));
        panelPrestamos.setBorder(new EmptyBorder(30, 50, 30, 50));
        JButton btnPrestar = new JButton("Otorgar y Registrar Préstamo");
        JButton btnDevolver = new JButton("Procesar Devolución (Liberar Ítem)");
        
        panelPrestamos.add(new JLabel("Gestión de Préstamos Activos y Devoluciones:", SwingConstants.CENTER));
        panelPrestamos.add(btnPrestar);
        panelPrestamos.add(btnDevolver);
        pestañas.addTab("Préstamos", panelPrestamos);

        JPanel panelConfig = new JPanel(new GridLayout(2, 1, 10, 20));
        panelConfig.setBorder(new EmptyBorder(40, 50, 40, 50));
        JButton btnAgregarTipo = new JButton("Administrar Tipos Físicos (Libro, Revista, etc.)");
        JButton btnAgregarCategoria = new JButton("Administrar Categorías Temáticas");
        
        panelConfig.add(btnAgregarTipo);
        panelConfig.add(btnAgregarCategoria);
        pestañas.addTab("Tipos y Categorías", panelConfig);

        JPanel panelReportes = new JPanel(new GridLayout(4, 1, 10, 15));
        panelReportes.setBorder(new EmptyBorder(20, 50, 20, 50));
        JButton repUsuarios = new JButton("Reporte 1: Préstamos por Usuario");
        JButton repItems = new JButton("Reporte 2: Estado de Ítems (Alfabético)");
        JButton repCategorias = new JButton("Reporte 3: Objetos por Categoría");
        
        panelReportes.add(new JLabel("Consultas y Reportes del Sistema:", SwingConstants.CENTER));
        panelReportes.add(repUsuarios);
        panelReportes.add(repItems);
        panelReportes.add(repCategorias);
        pestañas.addTab("Reportes", panelReportes);

        btnCrearPersona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el Nombre del Cliente:", "Registro", JOptionPane.QUESTION_MESSAGE);
                if (nombre == null || nombre.trim().isEmpty()) return;

                String tel = JOptionPane.showInputDialog(null, "Ingrese el Teléfono:", "Registro", JOptionPane.QUESTION_MESSAGE);
                if (tel == null || tel.trim().isEmpty()) return;

                String correo = JOptionPane.showInputDialog(null, "Ingrese el Correo Electrónico:", "Registro", JOptionPane.QUESTION_MESSAGE);
                if (correo == null || correo.trim().isEmpty()) return;

       
                Controladora.getInstancia().registrarPersona(nombre, tel, correo);
                
                JOptionPane.showMessageDialog(null, "¡Persona guardada con éxito!");
            }
        });

        btnEliminarPersona.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String correo = JOptionPane.showInputDialog(null, "Ingrese el correo de la persona a eliminar:");
                if (correo == null || correo.trim().isEmpty()) return;
                
                Controladora.getInstancia().eliminarPersona(correo);
                JOptionPane.showMessageDialog(null, "Se procesó la solicitud de eliminación.");
            }
        });


        btnCrearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cod = JOptionPane.showInputDialog(null, "Código del Ítem:");
                if (cod == null || cod.trim().isEmpty()) return;
                String nom = JOptionPane.showInputDialog(null, "Nombre del Objeto:");
                if (nom == null || nom.trim().isEmpty()) return;
                String desc = JOptionPane.showInputDialog(null, "Descripción:");
                if (desc == null || desc.trim().isEmpty()) return;
                String tipo = JOptionPane.showInputDialog(null, "Tipo de Ítem (Ej: Libro, DVD):");
                if (tipo == null || tipo.trim().isEmpty()) return;

                Controladora.getInstancia().agregarItem(cod, nom, desc, tipo);
                JOptionPane.showMessageDialog(null, "¡Ítem incorporado al catálogo!");
            }
        });

        btnEliminarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cod = JOptionPane.showInputDialog(null, "Ingrese el código del ítem a borrar:");
                if (cod == null || cod.trim().isEmpty()) return;
                Controladora.getInstancia().eliminarItem(cod);
                JOptionPane.showMessageDialog(null, "Ítem eliminado correctamente.");
            }
        });

      
        btnPrestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(null, "ID Único del Préstamo:");
                if (id == null || id.trim().isEmpty()) return;
                String correo = JOptionPane.showInputDialog(null, "Correo de la Persona:");
                if (correo == null || correo.trim().isEmpty()) return;
                String codItem = JOptionPane.showInputDialog(null, "Código del Ítem a prestar:");
                if (codItem == null || codItem.trim().isEmpty()) return;

             
                Controladora.getInstancia().registrarPrestamo(id, correo, codItem, new java.util.Date());
                JOptionPane.showMessageDialog(null, "¡Préstamo registrado exitosamente!");
            }
        });

        btnDevolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(null, "Ingrese el ID del Préstamo a finalizar:");
                if (id == null || id.trim().isEmpty()) return;

                Controladora.getInstancia().registrarDevolucion(id);
                JOptionPane.showMessageDialog(null, "¡Devolución registrada! El ítem ha quedado libre.");
            }
        });

   
        repUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalP = Controladora.getInstancia().getListaPersonas().size();
                int totalPr = Controladora.getInstancia().getListaPrestamos().size();
                JOptionPane.showMessageDialog(null, "--- Reporte por Usuarios ---\n" +
                        "Total de prestatarios registrados: " + totalP + "\n" +
                        "Total de préstamos activos en este momento: " + totalPr, 
                        "Reporte del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        repItems.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int totalI = Controladora.getInstancia().getListaItems().size();
                JOptionPane.showMessageDialog(null, "--- Reporte Alfabético de Ítems ---\n" +
                        "Cantidad total de ítems en el catálogo: " + totalI, 
                        "Reporte del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        repCategorias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "--- Reporte por Categorías ---\nFiltrando catálogo por grupos temáticos...", 
                        "Reporte del Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
