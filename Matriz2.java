
/**
 * Write a description of class Matriz2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Matriz2
{
   int filas=2;
   int columnas=2;
   double[][] matriz = new double[filas][columnas];
   
   public static void main(String[] args){
       Matriz2 p=new Matriz2();
       p.imprimir_matriz();
       Matriz2 q=new Matriz2();
       p.suma_matriz(q).imprimir_matriz();
   }
   
   public Matriz2(){
       Scanner sc=new Scanner(System.in);
       for(int i =0; i<filas;i++){
           for(int j=0;j<columnas;j++){
               System.out.println("Ingresa el número en la posición ( "+ (i+1)+ " x " + (j+1) + " )");
               double numero=sc.nextDouble();
               matriz[i][j]=numero;
           }
       }
   }
   public Matriz2(double a,double b,double c,double d){
       matriz[0][0]=a;
       matriz[0][1]=b;
       matriz[1][0]=c;
       matriz[1][1]=d;
    }
    
    public void imprimir_matriz(){
        for(int x=0;x<matriz.length;x++){
            for(int y=0; y<matriz[x].length;y++){
                if(y==matriz[x].length-1){
                    System.out.println(matriz[x][y]);
                }
                else{
                    System.out.print(matriz[x][y]+ " ");
                }
            }
        }
    }
    
    public double obtener_valor(int fil, int col){
        return matriz[fil][col];
    }
    
    public double determinante(){
        return matriz[0][0]*matriz[1][1]-matriz[1][0]*matriz[0][1];
    }
    
    public Matriz2 inversa_matriz(){
        double[][] matriz_I=new double[2][2];
        int u_e_d=(int) determinante();
        try{
            int lu=1/u_e_d;
            double[][] matriz_T=new double[2][2];
            matriz_T[0][0]=matriz[1][1];
            matriz_T[1][1]=matriz[0][0];
            matriz_T[0][1]=-matriz[0][1];
            matriz_T[1][0]=-matriz[1][0];
            for(int a=0;a<matriz.length;a++){
                for(int b=0;b<matriz[a].length;b++){
                    matriz_I[a][b]=1/(determinante())*matriz_T[a][b];
                }
            }
        }
        catch(ArithmeticException e){
            System.out.println("La matriz que elegiste es singular");
        }
        Matriz2 m_I= new Matriz2(matriz_I[0][0],matriz_I[0][1],matriz_I[1][0],matriz_I[1][1]);
        return m_I;
    }
    
    public Matriz2 suma_matriz(Matriz2 c){
        double l = matriz[0][0] + c.obtener_valor(0,0);
        double m = matriz[0][1] + c.obtener_valor(0,1);
        double n = matriz[1][0] + c.obtener_valor(1,0);
        double o = matriz[1][1] + c.obtener_valor(1,1);
        Matriz2 suma = new Matriz2(l,m,n,o);
        return suma;
    }
}
