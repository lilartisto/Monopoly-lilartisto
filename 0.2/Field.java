public interface Field {
    String line1();
    String line2();
    void doWhenStand( Player player );
    void addPlayer( char p );
    void deletePlayer( char p );
}