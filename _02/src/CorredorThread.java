public class CorredorThread extends Thread{
    private String tipoCorredor;
    private int prioridad, probResbalar, posicionCorredor = 1;

    public CorredorThread(String tipoCorredor, int prioridad, int probResbalar) {
        this.tipoCorredor = tipoCorredor;
        this.prioridad = prioridad;
        this.probResbalar = probResbalar;
        this.setPriority(prioridad);
    }

    @Override
    public void run() {
        super.run();
        int sufreUnPoquito;

        /////////////////////////////////////////////
        //  En el run de cada hilo hacemos
        //  "sufra" la CPU. Con esto garantizamos
        //  que el sistema operativo distribuya
        //  los ciclos entre cada hilo dependiendo
        //  de su prioridad
        /////////////////////////////////////////////

        while (posicionCorredor < Carrera.longitud){

            for (long i = 0; i < 100000000; i++) {
                sufreUnPoquito = 2*2;
            }
            posicionCorredor++;
        }
//
//        while (posicionCorredor < Carrera.longitud){
//            posicionCorredor++;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        Carrera.carreraEnCurso = false;
        Carrera.ganador = this;
    }

    public int getPosicionCorredor() {
        return posicionCorredor;
    }

    public void setPosicionCorredor(int posicionCorredor) {
        this.posicionCorredor = posicionCorredor;
    }

    public String getTipoCorredor() {
        return tipoCorredor;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getProbResbalar() {
        return probResbalar;
    }

}
