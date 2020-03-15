public class BuildingF implements Field{
    private String name;
    private char[] players;
    private int price;
    private boolean pledge;
    private boolean bought;
    private char owner;

    public BuildingF( String name, int price ){
        this.name = name;
        this.price = price;
        this.players = new char[4];
        this.pledge = false;
        this.bought = false;
        this.owner = 32;

        for( int i = 0; i < players.length; i++ )
            players[i] = 32;
    }

    @Override
    public String line1(){
        if( bought )
            return String.format("%-2s    %c", name, owner);
        return String.format("%-2s $%3d", name, price);
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

    public void setPledge( boolean pledge ){
        this.pledge = pledge;
    }

    public void setOwner( char owner ){
        this.owner = owner;
    }

    public int getPrice(){
        return price;
    }

    public int priceSell(){
        return (int)(0.5*(double)price);
    }

    public int priceBuy(){
        return (int)(1.1*(double)priceSell());
    }

    public boolean getPledge(){
        return pledge;
    }

    public boolean getBought(){
        return bought;
    }

    public char getOwner(){
        return owner;
    }
}