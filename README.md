Ia a Utilizar Gemini Pro
Gemini de paga

Prom numero Usado:
Mi codigo genera una matriz 3x3 que tiene en sus datos el nombre de 3 lenguajes de programacion, lo que realiza mi codigo dividio en dos clases jave la Clase Main y la Clase Contador, usan hilos para leer el nombre del lenjuague de programacion usando el el join en los hilos para q se muestre la fila y la cantidad de que palabra se esta buscando en mi codigo hice q busque la palabra java. quiero que me digas como puedo mejorar el codigo y que opinas de este, ademas si es posible me gustaria agregar que se muestre al inicio la palabra q se esta buscando y al final la palabra el total de veces q se repite

ESte es mi codgio:
package ec.edu.utpl.computacion.proava;


public class Main {
    public static void main(String[] args)  {

//compare to
        String matriz [][] =  new String[3][3] ;

        for (int i=0;i < matriz.length;i++)

        {
        for (int j =0 ; j< matriz.length ;j++)
        {
            matriz[i][j] = palabra();
            System.out.print((matriz[i][j]+" "));

        }
            System.out.println();
        }
        Contador fila1 = new Contador(matriz[0][0],matriz[0][1],matriz[0][2],1,0,"java");
        Contador fila2 = new Contador(matriz[1][0],matriz[1][1],matriz[1][2],2,0,"java");
        Contador fila3 = new Contador(matriz[2][0],matriz[2][1],matriz[2][2],3,0,"java");

        Thread hiloA =new Thread(()-> fila1.Run());
        Thread hiloB = new Thread(()-> fila2.Run());
        Thread hiloC = new Thread(()-> fila3.Run());
      hiloA.start();
      hiloB.start();
      hiloC.start();
      try{
          hiloA.join();
          hiloB.join();
          hiloC.join();


      } catch (InterruptedException e){
             Thread.currentThread().interrupt();
      }

    }

    public static String palabra (  ){
        int b = (int)(Math.random() *3);
        String pal = "null" ;
        if (b==0){
            pal= "java";
        }else if (b==1){
            pal= "python";
        }else {
            pal= "c++";
        }
        return pal;

    }
}

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

