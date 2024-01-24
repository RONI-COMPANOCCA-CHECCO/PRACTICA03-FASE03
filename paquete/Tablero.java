package paquete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tablero extends javax.swing.JFrame {
    @SuppressWarnings("unchecked")
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
    private JButton[][] botones;
    private Ejercito e1;
    private Ejercito e2;

    public Tablero(int filas, int columnas, String nombreEjercito1, String nombreEjercito2) {
        super("BATALLA ENTRE " + nombreEjercito1 + " VS " + nombreEjercito2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        botones = new JButton[filas][columnas];

        // Configura el diseño del contenedor
        setLayout(new GridLayout(filas + 1, columnas + 1));

        // Agrega una etiqueta vacía en la esquina superior izquierda
        add(new JLabel());

        // Agrega etiquetas para las columnas (números)
        for (int i = 1; i <= columnas; i++) {
            JLabel label = new JLabel(Integer.toString(i), JLabel.CENTER);
            add(label);
        }

        // Crear y agregar botones al Tablero con letras para las filas
        for (int i = 1; i <= filas; i++) {
            JLabel label = new JLabel(Character.toString((char) ('A' + i - 1)), JLabel.CENTER);
            add(label);

            for (int j = 1; j <= columnas; j++) {
                botones[i - 1][j - 1] = new JButton();
                botones[i - 1][j - 1].setBackground(new Color(135, 206, 250));
                botones[i - 1][j - 1].setForeground(Color.BLACK);
                botones[i - 1][j - 1].setFont(new Font("Arial", Font.BOLD, 14));
                botones[i - 1][j - 1].addActionListener(new BotonListener());

                add(botones[i - 1][j - 1]);
            }
        }

        // Lógica para la creación de Ejércitos y colocación de soldados
        int cant;
        String cultura[] = {"Inglaterra","Francia","Sacro Imperio Romano Germanico","Aragon","Moros"};
        
        cant = aleatorio(1, 10);
        e1 = new Ejercito(nombreEjercito1, cant);
        colocarSoldado(0, 0, e1.misSoldados.get(0));

        cant = aleatorio(1, 10);
        e2 = new Ejercito(nombreEjercito2, cant);
        colocarSoldado(1, 1, e2.misSoldados.get(0));

        // Atacar entre soldados
        e1.misSoldados.get(0).atacar(e2.misSoldados.get(0));

        // Mostrar el Tablero (puedes implementar un método mostrar() en la clase Tablero)
        mostrar();

        setVisible(true);
        
        // Obtener información sobre la memoria
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("Total de memoria: " + totalMemory + " bytes");
        System.out.println("Memoria libre: " + freeMemory + " bytes");
        System.out.println("Memoria utilizada: " + usedMemory + " bytes");
    }

    private class BotonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            System.out.println("Clic en el botón: " + boton.getText());
        }
    }

    public void colocarSoldado(int fila, int columna, Soldado soldado) {
        botones[fila][columna].setText(soldado.toString());
        soldado.setPosicion(fila, columna);
    }

    public static int aleatorio(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }

    public void mostrar() {
        // Lógica para mostrar información de los Ejércitos
        System.out.print("Ejercito 1 " + e1.getCultura());
        System.out.println("\nCantidad total de Soldados: " + Soldado.cuantos() + "\n"
                + "Espadachines: " + Espadachin.cuantos() + "\n"
                + "Arqueros: " + Arquero.cuantos() + "\n"
                + "Lanceros: " + Lancero.cuantos() + "\n"
                + "Caballeros: " + Caballero.cuantos() + "\n");
        Ejercito.resetearCantidad();

        System.out.print("Ejercito 2 " + e2.getCultura());
        System.out.println("\nCantidad total de Soldados: " + Soldado.cuantos() + "\n"
                + "Espadachines: " + Espadachin.cuantos() + "\n"
                + "Arqueros: " + Arquero.cuantos() + "\n"
                + "Lanceros: " + Lancero.cuantos() + "\n"
                + "Caballeros: " + Caballero.cuantos() + "\n");
        Ejercito.resetearCantidad();
    }

    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        Tablero tablero = new Tablero(10, 10, "Ejercito1", "Ejercito2");
        tablero.setLocationRelativeTo(null); // Centra la ventana
        tablero.setVisible(true);
    });
}
}

