package paquete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JuegoInterfazAvanzada extends JFrame {

        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
            );
    
            pack();
        }// </editor-fold>//GEN-END:initComponents
    
        // Variables declaration - do not modify//GEN-BEGIN:variables
        // End of variables declaration//GEN-END:variables

    private JLabel etiquetaTerritorio;
    private JComboBox<String> listaTerritorio;
    private JButton botonIniciar;
    private JTextArea areaTexto;
    private FabricaElementoFlyweight fabricaElementoFlyweight = new FabricaElementoFlyweight();

    public JuegoInterfazAvanzada() {
        super("Juego de Estrategia");

        etiquetaTerritorio = new JLabel("Seleccione Territorio:");
        listaTerritorio = new JComboBox<>(new String[]{"Bosque", "Campo abierto", "Montaña", "Desierto", "Playa"});

        areaTexto = new JTextArea(10, 30);
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        botonIniciar = new JButton("Iniciar Juego");
        botonIniciar.addActionListener(e -> iniciarJuego());

        JPanel panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.add(etiquetaTerritorio);
        panelSuperior.add(listaTerritorio);

        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.add(panelSuperior, BorderLayout.NORTH);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        JPanel panelBoton = new JPanel();
        panelBoton.add(botonIniciar);

        setLayout(new BorderLayout());
        add(panelCentral, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void iniciarJuego() {
        
        String selectedCultura = (String) listaTerritorio.getSelectedItem();
        mostrarMensaje("Iniciando juego en territorio: " + selectedCultura);

        // Utilizar Flyweight para crear instancias de etiquetas compartidas
        ElementoFlyweight etiquetaTerritorio = fabricaElementoFlyweight.getElemento("Territorio: " + selectedCultura);
        etiquetaTerritorio.mostrar();
        
        // Crear una ventana para seleccionar ejércitos en la misma ventana
        String[] ejercitos = {"INGLATERRA", "FRANCIA", "SACRO IMPERIO ROMANO GERMANICO", "ARAGON", "MOROS"};
        JComboBox<String> comboEjercito1 = new JComboBox<>(ejercitos);
        JComboBox<String> comboEjercito2 = new JComboBox<>(ejercitos);
        
        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(e -> {
        String ejercitoSeleccionado1 = (String) comboEjercito1.getSelectedItem();
        String ejercitoSeleccionado2 = (String) comboEjercito2.getSelectedItem();

        // Lógica para iniciar el juego con los ejércitos seleccionados
        mostrarMensaje("Ejército 1: " + ejercitoSeleccionado1 + "\nEjército 2: " + ejercitoSeleccionado2);

        // Puedes agregar más lógica según tus necesidades

        // Crear el Tablero con los ejércitos seleccionados
        SwingUtilities.invokeLater(() -> {
            Tablero tablero = new Tablero(10, 10, ejercitoSeleccionado1, ejercitoSeleccionado2);
            tablero.setLocationRelativeTo(null); // Centra la ventana
            tablero.setVisible(true);
        });

        // Cerrar la ventana de selección de ejércitos
        ((Window) SwingUtilities.getRoot(botonAceptar)).dispose();
        });

        JPanel panelSeleccionEjercitos = new JPanel(new GridLayout(3, 2));
        panelSeleccionEjercitos.add(new JLabel("Ejército 1:"));
        panelSeleccionEjercitos.add(comboEjercito1);
        panelSeleccionEjercitos.add(new JLabel("Ejército 2:"));
        panelSeleccionEjercitos.add(comboEjercito2);
        panelSeleccionEjercitos.add(new JLabel());
        panelSeleccionEjercitos.add(botonAceptar);

        JOptionPane.showOptionDialog(
            this,
            panelSeleccionEjercitos,
            "Seleccionar Ejércitos",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            new Object[]{},
            null
        );
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JuegoInterfazAvanzada());
    }
    
}
