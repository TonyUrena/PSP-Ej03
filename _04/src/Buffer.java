import java.util.LinkedList;

class Buffer {
    private LinkedList<Integer> buffer;
    private int capacidad;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        buffer = new LinkedList<>();
    }

    public void producir(int valor) {
        synchronized (this) {
            while (buffer.size() == capacidad) {
                try {
                    wait(); // Esperar si el búfer está lleno
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            buffer.add(valor);
            System.out.println("Producido: " + valor);
            notify(); // Notificar a un consumidor que puede tomar un elemento
        }
    }

    public int consumir() {
        synchronized (this) {
            while (buffer.isEmpty()) {
                try {
                    wait(); // Esperar si el búfer está vacío
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int valor = buffer.remove();
            System.out.println("Consumido: " + valor);
            notify(); // Notificar a un productor que puede agregar un elemento
            return valor;
        }
    }
}