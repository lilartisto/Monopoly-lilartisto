public class StreetF implements Field{
    private String name;
    private char[] players;
    private int price;
    private boolean pledge;
    private int houses;
    private boolean hotel;
    private String color;
    private boolean bought;
    private char owner;

    public StreetF( String name, int price, String color ){
        this.name = name;
        this.price = price;
        this.players = new char[4];
        this.pledge = false;
        houses = 0;
        hotel = false;
        this.color = color;
        owner = 32;
        bought = false;

        for( int i = 0; i < players.length; i++ )
            players[i] = 32;
    }
    
    @Override
    public String line1(){
        if( bought ){
            if( hotel )
                return String.format("%s%-2s  H %c%s", color, name, owner, "\u001b[0m");
            else
                return String.format("%s%-2s D%d %c%s", color, name, houses, owner, "\u001b[0m");
        }
        return String.format("%s%-2s $%-3d%s", color, name, price, "\u001b[0m");
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

    public void setHouses( int h ){
        houses = h;
    }

    public void setHotel( boolean h ){
        hotel = h;
    }

    public void setBought( boolean bought ){
        this.bought = bought;
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

    public int getHouses(){
        return houses;
    }

    public boolean getHotel(){
        return hotel;
    }

    public boolean getBought(){
        return bought;
    }

    public char getOwner(){
        return owner;
    }
}