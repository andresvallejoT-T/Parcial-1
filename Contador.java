package ec.edu.utpl.computacion.proava;

public class Contador {

    private String palabra1;
    private String palabra2;
    private String palabra3;
    private int fila;
    private int cont;
    private String buscPalabra;
   public Contador (String palabra1, String palabra2,String palabra3,int fila,int cont,String buscPalabra){
       this.palabra1=palabra1;
       this.palabra2=palabra2;
       this.palabra3=palabra3;
       this.fila=fila;
       this.cont=0;
       this.buscPalabra=buscPalabra;


   }
    public void Run(){
       if (palabra1.equals(buscPalabra)){
                cont++;
            }
        if (palabra2.equals(buscPalabra)){
            cont++;

        }
        if (palabra3.equals(buscPalabra)){
            cont++;

        }
//        try {
//            Thread.sleep(1000); // pausa 1 segundo real
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            return;
//        }
        System.out.println("En la fila "+fila+" Existen " +cont+" de "+buscPalabra);
        cont=0;
        }
}
