import java.util.Scanner;

public class Main{
    private static int nPlayers;
    private static Player[] players;
    public static void main( String[] args ){
        System.out.println("\u001b[37mPodaj Witamy w MONOPOLY!");

        Scanner scanner = new Scanner( System.in );
        Map map = new Map();

        do {
            System.out.println("Podaj liczbe graczy 2-4");
            nPlayers = scanner.nextInt();
        } while( !(nPlayers >= 2 && nPlayers <= 4) );

        players = new Player[4];
        for( int i = 0; i < 4; i++ ){
            if( i < nPlayers ){
                System.out.println("Podaj nazwe(znak) gracza nr " + (i+1));
                char tmp = scanner.next().charAt(0);
                players[i] = new Player( tmp, "\u001b[3"+(i+1)+"m");
            }
            else{
                players[i] = new Player( (char)32, "" );
            }
            map.fields[ players[i].getWhere() ].doWhenStand( players[i] );
        }

        map.printMap(players[1]);
        
        scanner.close();
    }
}