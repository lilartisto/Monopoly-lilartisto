public class StationF implements Field{
    private String name;
    private char[] players;
    private int price;
    private boolean pledge;
    private String color;
    private Player owner;
    private boolean bought;

    public StationF( String name, int price, String color ){
        this.name = name;
        this.price = price;
        this.players = new char[4];
        this.pledge = false;
        this.color = color;
        this.owner = null;
        this.bought = false;

        for( int i = 0; i < players.length; i++ )
            players[i] = 32;
    }
    
    @Override
    public String line1(){
        if( bought )
            return String.format("%s%-2s    %c%s", color, name, owner.getName(), "\u001b[0m");
        return String.format("%s%-2s $%3d%s", color, name, price, "\u001b[0m");
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
        if( bought ){
            if( owner.getName() != player.getName() ){
                Menu.payMenu( player, owner, rent() );
            }
        }
        else{
            if( Menu.buyMenu( player, price ) ){
                owner = player;
                bought = true;
            }
            else{
                //jesli nie kupil to licytacja
            }
        }
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

    public int rent(){
        int r = 25;
        for( int i = 5; i < 40; i = i + 10 ){
            if( ((StationF)Map.fields[i]).owner == this.owner )
                r*=2;
        }
        return r/2;
    }

    public void setPledge( boolean pledge ){
        this.pledge = pledge;
    }

    public void setOwner( Player owner ){
        this.owner = owner;
    }

    public void setBought( boolean bought ){
        this.bought = bought;
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

    public char getOwnerName(){
        return owner.getName();
    }

    public boolean getBought(){
        return bought;
    }
}