import java.io.IOException;

public class Map {
    static Field[] fields;

    public static void prepare(){
        fields = new Field[40];
        fields[0] = new StartF( "-START-" );
        fields[1] = new StreetF("A1", 60, "\u001b[48;5;90m", 2 );
        fields[2] = new CardF("CHEST 1");
        fields[3] = new StreetF("A2", 60, "\u001b[48;5;90m", 4 );
        fields[4] = new TaxF("Tax 200");
        fields[5] = new StationF("S1", 200, "\u001b[48;5;7m" );
        fields[6] = new StreetF("B1", 100, "\u001b[48;5;13m", 6 );
        fields[7] = new CardF("CHANCE?");
        fields[8] = new StreetF("B2", 100, "\u001b[48;5;13m", 6 );
        fields[9] = new StreetF("B3", 120, "\u001b[48;5;13m", 8 );
        fields[10] = new JailF("JAIL");
        fields[11] = new StreetF("C1", 140, "\u001b[48;5;198m", 10 );
        fields[12] = new BuildingF("BE", 150);
        fields[13] = new StreetF("C2", 140, "\u001b[48;5;198m", 10 );
        fields[14] = new StreetF("C3", 160, "\u001b[48;5;198m", 12 );
        fields[15] = new StationF("S2", 200, "\u001b[48;5;7m" );
        fields[16] = new StreetF("D1", 180, "\u001b[48;5;208m", 14 );
        fields[17] = new CardF("CHEST 2");
        fields[18] = new StreetF("D2", 180, "\u001b[48;5;208m", 14 );
        fields[19] = new StreetF("D3", 180, "\u001b[48;5;208m", 16 );
        fields[20] = new ParkingF("PARKING");
        fields[21] = new StreetF("E1", 220, "\u001b[48;5;1m", 18 );
        fields[22] = new CardF("CHANCE?");
        fields[23] = new StreetF("E2", 220, "\u001b[48;5;1m", 18 );
        fields[24] = new StreetF("E3", 240, "\u001b[48;5;1m", 20 );
        fields[25] = new StationF("S3", 200, "\u001b[48;5;7m" );
        fields[26] = new StreetF("F1", 260, "\u001b[48;5;3m", 22 );
        fields[27] = new StreetF("F2", 260, "\u001b[48;5;3m", 22 );
        fields[28] = new BuildingF("BW", 150);
        fields[29] = new StreetF("F3", 280, "\u001b[48;5;3m", 24 );
        fields[30] = new PoliceF("GO2JAIL");
        fields[31] = new StreetF("G1", 300, "\u001b[48;5;2m", 26 );
        fields[32] = new StreetF("G2", 300, "\u001b[48;5;2m", 26 );
        fields[33] = new CardF("CHEST 3");
        fields[34] = new StreetF("G3", 320, "\u001b[48;5;2m", 28 );
        fields[35] = new StationF("S4", 200, "\u001b[48;5;7m" );
        fields[36] = new CardF("CHANCE?");
        fields[37] = new StreetF("H1", 350, "\u001b[48;5;4m", 35 );
        fields[38] = new TaxF("TAX 100");
        fields[39] = new StreetF("H2", 400, "\u001b[48;5;4m", 50 );
    }

    public static void printMap( Player player ){
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("|"+fields[20].line1()+"|"+fields[21].line1()+"|"+fields[22].line1()+"|"+fields[23].line1()+"|"+fields[24].line1()+"|"+fields[25].line1()+"|"+fields[26].line1()+"|"+fields[27].line1()+"|"+fields[28].line1()+"|"+fields[29].line1()+"|"+fields[30].line1()+"|");
        System.out.println("|"+fields[20].line2()+"|"+fields[21].line2()+"|"+fields[22].line2()+"|"+fields[23].line2()+"|"+fields[24].line2()+"|"+fields[25].line2()+"|"+fields[26].line2()+"|"+fields[27].line2()+"|"+fields[28].line2()+"|"+fields[29].line2()+"|"+fields[30].line2()+"|");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("|"+fields[19].line1()+"|                                                                       |"+fields[31].line1()+"|");
        System.out.println("|"+fields[19].line2()+"|                                                                       |"+fields[31].line2()+"|");
        System.out.println("+-------+                                                                       +-------+");
        System.out.println("|"+fields[18].line1()+"|                                                                       |"+fields[32].line1()+"|");
        System.out.println("|"+fields[18].line2()+"|                                                                       |"+fields[32].line2()+"|");
        System.out.println("+-------+   _________________________________________________________________   +-------+");
        System.out.println("|"+fields[17].line1()+"|      /\\    /\\      ---   |\\   |   ---   |---\\    ---   |     \\   /    |"+fields[33].line1()+"|");
        System.out.println("|"+fields[17].line2()+"|     /  \\  /  \\   /     \\ | \\  | /     \\ |    | /     \\ |      \\ /     |"+fields[33].line2()+"|");
        System.out.println("+-------+    /    \\/    \\  \\     / |  \\ | \\     / |---/  \\     / |       |      +-------+");
        System.out.println("|"+fields[16].line1()+"|   /            \\   ---   |   \\|   ---   |        ---   +----   |      |"+fields[34].line1()+"|");
        System.out.println("|"+fields[16].line2()+"|   _________________________________________________________________   |"+fields[34].line2()+"|");
        System.out.println("+-------+                                                                       +-------+");
        System.out.println("|"+fields[15].line1()+"|                             BY LILARTISTO                             |"+fields[35].line1()+"|");
        System.out.println("|"+fields[15].line2()+"|                                                                       |"+fields[35].line2()+"|");
        System.out.println("+-------+                                                                       +-------+");
        System.out.println("|"+fields[14].line1()+"|                                                                       |"+fields[36].line1()+"|");
        System.out.println("|"+fields[14].line2()+"|                           "+player.getColor()+"+-------------+\u001b[0m                             |"+fields[36].line2()+"|");
        System.out.println("+-------+                              PLAYER: "+player.getName()+"                                +-------+");
        System.out.println("|"+fields[13].line1()+"|                              CARDS:                                   |"+fields[37].line1()+"|");
        System.out.println("|"+fields[13].line2()+"|                              $ "+String.format("%-4d", player.getMoney()) + "                                   |" + fields[37].line2()+"|");
        System.out.println("+-------+                           "+player.getColor()+"+-------------+\u001b[0m                             +-------+");
        System.out.println("|"+fields[12].line1()+"|                                                                       |"+fields[38].line1()+"|");
        System.out.println("|"+fields[12].line2()+"|                                                                       |"+fields[38].line2()+"|");
        System.out.println("+-------+                                                                       +-------+");
        System.out.println("|"+fields[11].line1()+"|                                                                       |"+fields[39].line1()+"|");
        System.out.println("|"+fields[11].line2()+"|                                                                       |"+fields[39].line2()+"|");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
        System.out.println("|"+fields[10].line1()+"|"+fields[9].line1()+"|"+fields[8].line1()+"|"+fields[7].line1()+"|"+fields[6].line1()+"|"+fields[5].line1()+"|"+fields[4].line1()+"|"+fields[3].line1()+"|"+fields[2].line1()+"|"+fields[1].line1()+"|"+fields[0].line1()+"|");
        System.out.println("|"+fields[10].line2()+"|"+fields[9].line2()+"|"+fields[8].line2()+"|"+fields[7].line2()+"|"+fields[6].line2()+"|"+fields[5].line2()+"|"+fields[4].line2()+"|"+fields[3].line2()+"|"+fields[2].line2()+"|"+fields[1].line2()+"|"+fields[0].line2()+"|");
        System.out.println("+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+-------+");
    }
    
    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}