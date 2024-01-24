/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionEjercitos extends JFrame {
    private JComboBox<String> comboEjercito1;
    private JComboBox<String> comboEjercito2;
    private JButton botonAceptar;

    public SeleccionEjercitos(String[] ejercitos) {
        super("Seleccionar Ejércitos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        comboEjercito1 = new JComboBox<>(ejercitos);
        comboEjercito2 = new JComboBox<>(ejercitos);
        botonAceptar = new JButton("Aceptar");

        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ejercitoSeleccionado1 = (String) comboEjercito1.getSelectedItem();
                String ejercitoSeleccionado2 = (String) comboEjercito2.getSelectedItem();

                // Crear el Tablero con los ejércitos seleccionados
                SwingUtilities.invokeLater(() -> {
                    new Tablero(10, 10, ejercitoSeleccionado1, ejercitoSeleccionado2);
                });

                // Cerrar la ventana de selección de ejércitos
                dispose();
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Ejército 1:"));
        panel.add(comboEjercito1);
        panel.add(new JLabel("Ejército 2:"));
        panel.add(comboEjercito2);
        panel.add(new JLabel());
        panel.add(botonAceptar);

        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

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

