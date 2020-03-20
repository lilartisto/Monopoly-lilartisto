public class PoliceF implements Field{
    private String name;
    private char[] players;

    public PoliceF( String name ){
        this.name = name;
        this.players = new char[4];

        for( int i = 0; i < players.length; i++ )
            players[i] = 32;
    }

    @Override
    public String line1(){
        return String.format("%-7s", name);
    }

    @Override
    public String line2(){
        return String.format("%c %c %c %c", players[0], players[1], players[2], players[3]);
    }

    @Override
    public void doWhenStand(Player player){
        addPlayer( player.getName() );
        Map.clrscr();
        Map.printMap(player);
        //idzie do wiezenia ale zaimplementuje to pozniej
    }

    public void addPlayer( char p ){
        for( int i = 0; i < players.length; i++ )
            if( players[i] == 32 )
            {
                players[i] = p;
                break;
            }
    }

    public void deletePlayer( char p ){
        for( int i = 0; i < players.length; i++)
            if( players[i] == p )
            {
                players[i] = 32;
                break;
            }
    }
}