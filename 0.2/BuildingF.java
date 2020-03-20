public class BuildingF implements Field{
    private String name;
    private char[] players;
    private int price;
    private boolean pledge;
    private boolean bought;
    private Player owner;


    public BuildingF( String name, int price ){
        this.name = name;
        this.price = price;
        this.players = new char[4];
        this.pledge = false;
        this.bought = false;
        this.owner = null;

        for( int i = 0; i < players.length; i++ )
            players[i] = 32;
    }

    @Override
    public String line1(){
        if( bought )
            return String.format("%-2s    %c", name, owner.getName());
        return String.format("%-2s $%3d", name, price);
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
        if( bought == true ){
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
        if( ((BuildingF)Map.fields[12]).owner == ((BuildingF)Map.fields[28]).owner )
            return 10*Dice.getDices();
        return 4*Dice.getDices();
    }

    public void setPledge( boolean pledge ){
        this.pledge = pledge;
    }

    public void setOwner( Player owner ){
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

    public char getOwnerName(){
        return owner.getName();
    }
}