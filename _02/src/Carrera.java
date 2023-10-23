public class Carrera {
    CorredorThread[] corredores;
    static volatile int longitud;
    static volatile boolean carreraEnCurso = true;
    static volatile CorredorThread ganador;

    public Carrera(CorredorThread[] corredores, int longitud) {
        this.corredores = corredores;
        this.longitud = longitud;
    }

    public int getLongitud() {
        return longitud;
    }

}
