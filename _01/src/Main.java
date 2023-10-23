public class Main {

    public static void main(String[] args) {

        Contador contador = new Contador();

        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                contador.subeContador();
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                contador.subeContador();
            }
        });

        Thread hilo3 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                contador.subeContador();
            }
        });

        Thread hilo4 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                contador.subeContador();
            }
        });

        try {

            hilo1.start();
            hilo2.start();
            hilo3.start();
            hilo4.start();

            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();

            contador.muestraContador();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}