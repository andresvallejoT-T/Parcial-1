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
