public class TestMap{
    public static void main( String[] args ){
        Player player = new Player('X', "\u001b[31m");
        Map.prepare();

        ((StreetF)Map.fields[11]).setOwner( player );
        ((StreetF)Map.fields[11]).setBought( true );

        ((StreetF)Map.fields[13]).setOwner( player ); //jp
        ((StreetF)Map.fields[13]).setBought( true );

        Map.printMap( player );
        
        //Map.clrscr();

        System.out.println( ((StreetF)Map.fields[13]).rent() );
    }
}