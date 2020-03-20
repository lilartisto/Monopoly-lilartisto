import java.util.Scanner;

public class Main{

    public static Scanner scanner;

    private static boolean playNext( Player[] players, int nPlayers ){
        int aliveCounter = 0;
        for( int i = 0; i < nPlayers; i++ ){
            if( !players[i].getBankrupt() )
                aliveCounter++;
        }
        return aliveCounter > 1;
    }

    public static void main( String[] args ){
        System.out.println("\u001b[37mPodaj Witamy w MONOPOLY!");

        scanner = new Scanner( System.in );
        Map.prepare();
        int nPlayers;

        do {
            System.out.println("Podaj liczbe graczy 2-4");
            nPlayers = scanner.nextInt();
        } while( !(nPlayers >= 2 && nPlayers <= 4) );

        Player[] players = new Player[4];
        for( int i = 0; i < 4; i++ ){
            if( i < nPlayers){
                System.out.println("Podaj nazwe(znak) gracza nr " + (i+1));
                char tmp = scanner.next().charAt(0);
                players[i] = new Player( tmp, "\u001b[3"+(i+1)+"m");
            }
            else{
                players[i] = new Player( (char)32, "" );
            }
            Map.fields[ players[i].getWhere() ].addPlayer( players[i].getName() );
        }

        while( playNext(players, nPlayers) ){ // petla odpowiadajaca za kolejne tury
            for( int j = 0; j < nPlayers; j++ ){ // petla tury dla gracza
                if( players[j].getBankrupt() )
                    continue;
                Map.clrscr();
                Map.printMap( players[j] );
                Menu.mainMenu( players[j] );
            }
        }
        
        
        scanner.close();
    }
}