package paquete;

// Clase concreta que implementa la interfaz Flyweight
public class EtiquetaTerritorio implements ElementoFlyweight {
    private String contenido;

    public EtiquetaTerritorio(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public void mostrar() {
        // mostramos el elemento
        System.out.println(contenido);
    }
}

