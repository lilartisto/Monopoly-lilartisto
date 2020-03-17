public class JailF implements Field{
    private String name;
    private char[] players;
    private char[] playersJail;

    public JailF( String name ){
        this.name = name;
        this.players = new char[4];
        this.playersJail = new char[4];

        for( int i = 0; i < players.length; i++ )
        {
            players[i] = 32;
            playersJail[i] = 32;
        }
    }

    @Override
    public String line1(){
        return String.format("J: %c%c%c%c", playersJail[0], playersJail[1], playersJail[2], playersJail[3]);
    }

    @Override
    public String line2(){
        return String.format("%c %c %c %c", players[0], players[1], players[2], players[3]);
    }

    @Override
    public void doWhenStand(Player player){

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

    public void addPlayerJail( char p ){
        for( int i = 0; i < playersJail.length; i++ )
            if( playersJail[i] == 32 )
            {
                playersJail[i] = p;
                break;
            }
    }

    public void deletePlayerJail( char p ){
        for( int i = 0; i < playersJail.length; i++)
            if( playersJail[i] == p )
            {
                playersJail[i] = 32;
                break;
            }
    }

    String getName(){
        return name;
    }
}