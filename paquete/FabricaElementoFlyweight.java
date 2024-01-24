
package paquete;

/**
 *
 * @author Roni
 */
import java.util.HashMap;
import java.util.Map;

public class FabricaElementoFlyweight {
    private Map<String, ElementoFlyweight> elementos = new HashMap<>();

    public ElementoFlyweight getElemento(String contenido) {
        if (!elementos.containsKey(contenido)) {
            elementos.put(contenido, new EtiquetaTerritorio(contenido));
        }
        return elementos.get(contenido);
    }
}

