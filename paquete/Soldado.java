package paquete;
public class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad = 0;
    private String actitud = "defensa";
    private boolean vive = true;
    private static int num = 0;
	
    //COMSTRUCTORES
	public Soldado(String nomb, int ataque, int defensa, int vida) {
	nombre = nomb;
        nivelAtaque = ataque;
        nivelDefensa = defensa;
        nivelVida = vida;
        vidaActual = vida;
        num++;
	}

	// Otros métodos
    public void atacar() {
        actitud = "ataque";
        avanzar();
    }

    public void defender() {
        actitud = "defensa";
        velocidad = 0;
    }

    public void avanzar() {
        velocidad++;
    }

    public void retroceder() {
        velocidad--;
    }

    public void serAtacado() {
        vidaActual--;
        if (vidaActual == 0) 
            morir();
    }

    public void huir(){
        actitud = "fuga";
        velocidad++;
    }

    public void morir() {
        vive = false;
    }

    public String toString() {
        return nombre+ " " +nivelAtaque+ " "+nivelDefensa+ " " +nivelVida+ " " +vidaActual+ " " +velocidad+ " " +actitud+ " " +vive;
    }

    public static int cuantos(){
        return num;
    }

    public static void resetearCantidad(){
        num=0;
    }

    public int getVida(){
        return nivelVida;
    }

    public String getActitud(){
        return actitud;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public int getNivelDefensa(){
        return nivelDefensa;
    }
    
    public void atacar(Soldado enemigo) {
        if (actitud.equals("ataque")) {
        // Verificar si el enemigo está en una casilla adyacente (horizontal o vertical)
        int distanciaFila = Math.abs(enemigo.getFila() - this.fila);
        int distanciaColumna = Math.abs(enemigo.getColumna() - this.columna);

        if ((distanciaFila == 1 && distanciaColumna == 0) || (distanciaFila == 0 && distanciaColumna == 1)) {
            // Atacar al enemigo
            enemigo.serAtacado();
            System.out.println(this.getNombre() + " ataca a " + enemigo.getNombre());
        } else {
            System.out.println(this.getNombre() + " no puede atacar a " + enemigo.getNombre() + ". Están demasiado lejos.");
        }
        }
    }
    
    private int fila;
    private int columna;

    public void setPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getNombre() {
        return nombre; 
    }
}
