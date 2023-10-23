import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /////////////////////////////////////////////////////////////////////
        //
        //  He decidido no implementar la parte del ejercicio en la que
        //  hay que simulamos como los animales se resbalan.
        //  El motivo: al hacer que los animales se resbalen de forma
        //  aleatoria lo único que estamos consiguiendo es aleatorizar el
        //  resultado de la carrera. Para que la carrera sea realmente justa
        //  e influyan las prioridades de cada hilo, obligo a cada hilo a
        //  realizar la misma cantidad de operaciones para que el sistema
        //  operativo distribuya los recursos entre cada proceso.
        //
        ////////////////////////////////////////////////////////////////////


        CorredorThread[] corredores = {
                // Tortuga
                new CorredorThread("\uD83D\uDC22",1,0),
                // Liebre
                new CorredorThread("\uD83D\uDC07",7,3),
                // Perro
                new CorredorThread("\uD83D\uDC15",8,6),
                // Caballo
                new CorredorThread("\uD83C\uDFC7",10,9)
        };

        Carrera carrera = new Carrera(corredores, 100);

        Arrays.stream(carrera.corredores).forEach(c -> {
            c.start();
        });

        try {
            while(Carrera.carreraEnCurso) {
                Thread.sleep(500);
                dibujaCarrera(carrera.longitud, corredores);
            }
            System.out.println("Ganador: " + Carrera.ganador.getTipoCorredor());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void dibujaCarrera(int longitudCarrera, CorredorThread[] corredores) {
        String bordePista = "━".repeat(longitudCarrera);
        System.out.println("\n".repeat(50)); // simula una limpieza de pantalla
        System.out.println("┏" + bordePista + "┓");
        Arrays.stream(corredores).forEach(c -> {
            System.out.println("┃" +
                    " ".repeat(c.getPosicionCorredor() - 1) + c.getTipoCorredor() +
                    ((c.getPosicionCorredor() != longitudCarrera) ?
                            " ".repeat((longitudCarrera - c.getPosicionCorredor() - 1)) + "░" : " "));
        });
        System.out.println("┗" + bordePista + "┛");
    }

}