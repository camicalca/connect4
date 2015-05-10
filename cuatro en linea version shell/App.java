import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Board tablero = new Board();
        int counter = 0;
        tablero.toStringB();
        int player=1;
        while (!CheckBoard.checkBoard(tablero)){
            System.out.println("Ingrese la columna 0-5");
            Scanner scan = new Scanner (System.in);
            int c = scan.nextInt();
            if (counter%2==0){
                player=1;
            }
            else{
                player = 2;
            }
            CheckBoard.move(tablero,c,player);
            counter++;
            System.out.println("==================");
            tablero.toStringB();


        }
        System.out.println("El jugador "+player+" gano el juego");


    }
}
