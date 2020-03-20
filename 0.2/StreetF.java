import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StreetF implements Field{
    private String name;
    private char[] players;
    private int price;
    private boolean pledge;
    private int houses;
    private boolean hotel;
    private String color;
    private boolean bought;
    private Player owner;
    private int rent;

    public StreetF( String name, int price, String color, int rent ){
        this.name = name;
        this.price = price;
        this.players = new char[4];
        this.pledge = false;
        houses = 0;
        hotel = false;
        this.color = color;
        owner = null;
        bought = false;
        this.rent = rent;

        for( int i = 0; i < players.length; i++ )
            players[i] = 32;
    }
    
    @Override
    public String line1(){
        if( bought ){
            if( hotel )
                return String.format("%s%-2s  H %c%s", color, name, owner.getName(), "\u001b[0m");
            else
                return String.format("%s%-2s D%d %c%s", color, name, houses, owner.getName(), "\u001b[0m");
        }
        return String.format("%s%-2s $%-3d%s", color, name, price, "\u001b[0m");
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

    public boolean hasDistrict(){
        int nColors = 0;
        int nOwners = 0;
        for( int i = 0; i < 40; i++ ){
            if( Map.fields[i] instanceof StreetF )
                if( ((StreetF)Map.fields[i]).color == this.color ){
                    nColors++;
                    //System.out.println("((StreetF)Map.fields[i]).getOwnerName()=" + ((StreetF)Map.fields[i]).getOwnerName());
                    //System.out.println("owner.getName()=" + owner.getName());
                    if( ((StreetF)Map.fields[i]).getOwnerName() == owner.getName() )
                        nOwners++;
                }
        }
        return nColors == nOwners;
    }

    public int rent(){
        if( !hasDistrict() )
            return rent;
        try{
            Scanner scannerFile = new Scanner( new File("rent.txt") );
            String line;

            while( true ){
                line = scannerFile.nextLine();
                Scanner scannerLine = new Scanner( line );
                if( scannerLine.nextInt() == rent )
                    break;
                scannerLine.close();
            }
            Scanner scanner = new Scanner(line);
            int r = scanner.nextInt(); //rent

            for( int i = 0; i <= houses; i++ )
                r = scanner.nextInt(); // i = 0 district, i1 1 house, i2 2house, i3 3house, i4 4 house
            if( hotel )
                r = scanner.nextInt(); // hotel
            scanner.close();
            return r;

        } catch(FileNotFoundException e){ 
            return rent;
         }
    }

    public void setPledge( boolean pledge ){
        this.pledge = pledge;
    }

    public void setHouses( int h ){
        houses = h;
    }

    public void addHouseHotel(){
        if( houses == 4 && !hotel)
            hotel = true;
        houses++;
    }

    public void setHotel( boolean h ){
        hotel = h;
    }

    public void setBought( boolean bought ){
        this.bought = bought;
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

    public int getHouses(){
        return houses;
    }

    public boolean getHotel(){
        return hotel;
    }

    public boolean getBought(){
        return bought;
    }

    public char getOwnerName(){
        if( owner == null )
            return (char)32;
        return owner.getName();
    }

    public String getName(){
        return name;
    }
}