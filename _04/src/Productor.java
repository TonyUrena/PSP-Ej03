class Productor implements Runnable {
    private Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.producir(i);
            try {
                Thread.sleep(100); // Simular producción
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}