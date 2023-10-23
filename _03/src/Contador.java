import java.util.concurrent.atomic.AtomicInteger;

public class Contador {
    AtomicInteger contador = new AtomicInteger();

    synchronized public void subeContador(){
        contador.addAndGet(1);
    }

    public void muestraContador(){
        System.out.println(contador);
    }
}
