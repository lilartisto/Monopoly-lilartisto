public class TaxF implements Field{
    private String name;
    private char[] players;

    public TaxF( String name ){
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
        if( player.getWhere() == 4 )
            Menu.taxMenu( player, 200);
        else
            Menu.taxMenu( player, 100);
    }

    @Override
    public void addPlayer( char p ){
        for( int i = 0; i < players.length; i++ )
            if( players[i] == 32 )
            {
                players[i] = p;
                break;
            }
    }

    @Override
    public void deletePlayer( char p ){
        for( int i = 0; i < players.length; i++)
            if( players[i] == p )
            {
                players[i] = 32;
                break;
            }
    }
}