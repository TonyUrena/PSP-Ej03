class Consumidor implements Runnable {
    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int valor = buffer.consumir();
            try {
                Thread.sleep(200); // Simular consumo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}