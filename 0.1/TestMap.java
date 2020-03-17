public class TestMap{
    public static void main( String[] args ){
        Map map = new Map();
        Player player = new Player('X', "\u001b[31m");

        ((StreetF)map.fields[11]).setOwner( player.getName() );
        ((StreetF)map.fields[11]).setBought( true );

        map.printMap( player );
    }
}