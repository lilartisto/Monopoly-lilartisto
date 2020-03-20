public class Menu {
    
    public static void mainMenu( Player player ){
        System.out.println("+------------------+-----------------+-------------+-------------+----------------------+");
        System.out.println("|(1)rzut kostka(1) |(2)wymien sie(2) |(3)zastaw(3) |(4)kredyt(4) |(5)kup domki/hotele(5)|");
        System.out.println("+------------------+-----------------+-------------+-------------+----------------------+");

        System.out.print("Twoj wybor: ");
        int choice = 0;
        choice = Main.scanner.nextInt();

        switch( choice ){
            case 1:
                int where = player.getWhere() + Dice.rollDice();
                if( where > 39 ){
                    where -= 40;
                    player.setMoney( player.getMoney() + 200 );
                }
                Map.fields[ player.getWhere() ].deletePlayer( player.getName() );
                player.setWhere( where );
                Map.fields[ where ].doWhenStand(player);
                if( Dice.isDoublet() ){
                    System.out.println("Wyrzuciles dublet! Rzucasz koscmi jeszcze raz!");
                    where = player.getWhere() + Dice.rollDice();
                    if( where > 39 ){
                        where -= 40;
                        player.setMoney( player.getMoney() + 200 );
                    }
                    Map.fields[ player.getWhere() ].deletePlayer( player.getName() );
                    player.setWhere( where );
                    Map.fields[ where ].doWhenStand(player);
                }
            break;
            case 2:
                //wymiana
            break;
            case 3:
                //zastaw
            break;
            case 4:
                // kredyt
            break;
            case 5:
                houseMenu(player);
                Map.clrscr();
                Map.printMap(player);
                mainMenu(player);
            break;
        }
    }

    public static boolean buyMenu( Player player, int price ){ //kto kupuje i za ile
        int choice;
        System.out.println("");
        System.out.println( "CHCESZ KUPIC POLE ZA " + price +"$? (0)nie/(1)tak" );
        System.out.print("Twoj wybor: ");
        choice = Main.scanner.nextInt();

        if( choice == 0 ){
            return false;
        }
        if( player.getMoney() < price ){
            System.out.print("Nie masz tylu pieniedzy, hahaha!");
            return false;
        }
        player.setMoney( player.getMoney() - price );
        return true;
    }

    public static void payMenu( Player player, Player owner, int rent ){ //kto placi, komu i ile
        System.out.println("");
        System.out.println("TO POLE NALEZY DO " + owner.getName() + ", ZAPLAC " + rent);
        while( true ){
            System.out.println("| (0)ZAPLAC(0) | (1)ZASTAW(1) | (2)ZBANKRUTUJ(2) |");
            int choice = Main.scanner.nextInt();
            if( choice == 0 ){ //placimy
                if( player.getMoney() < rent ){
                    System.out.println("Nie masz tylu pieniedzy, hahaha!");
                }
                else{
                    player.setMoney( player.getMoney() - rent );
                    owner.setMoney( owner.getMoney() + rent );
                    break;
                }
            }
            else if( choice == 1){ //zastawiamy
                //tu pojawi sie kod
            }
            else{ //bankrutujemy
                bankruptMenu( player, owner );
                break;
            }
        }
    }

    public static void taxMenu( Player player, int rent ){
        System.out.println("Placisz " + rent + "$! HAHAHA!");
        while( true ){
            System.out.println("| (0)ZAPLAC(0) | (1)ZASTAW(1) | (2)ZBANKRUTUJ(2) |");
            int choice = Main.scanner.nextInt();
            if( choice == 0 ){ //placimy
                if( player.getMoney() < rent ){
                    System.out.println("Nie masz tylu pieniedzy, hahaha!");
                }
                else{
                    player.setMoney( player.getMoney() - rent );
                    break;
                }
            }
            else if( choice == 1){ //zastawiamy
                //tu pojawi sie kod
            }
            else{ //bankrutujemy
                bankruptMenu( player );
                break;
            }
        }
    }

    public static void houseMenu( Player player ){
        while( true ){

            int price = 0;
            boolean aval[] = new boolean[40];

            System.out.println("\n+ - - - + - - - + - - - + - - - + - - - + - - - + - - - +");
            System.out.print("POLA DO ZAKUPU DOMKU/HOTELU: ");
            for( int i = 0; i < 40; i++ ){
                aval[i] = false;
                if( i%10 == 0 )
                    price += 50;

                if( Map.fields[i] instanceof StreetF )
                    if( ((StreetF)Map.fields[i]).getBought() )
                        if( ((StreetF)Map.fields[i]).getOwnerName() == player.getName() && ((StreetF)Map.fields[i]).hasDistrict() && !(((StreetF)Map.fields[i]).getHotel()) ){
                            System.out.print("("+i+")"+((StreetF)Map.fields[i]).getName()+"("+price+"$) ");
                            aval[i] = true;
                }
            }

            System.out.println("\nNA KTORYM POLU CHCESZ KUPIC DOMEK/HOTEL? (0)powrot(0)");
            System.out.print("Twoj wybor: ");
            int choice = Main.scanner.nextInt();
            if( choice == 0 )
                break;
            
            if( choice < 40 && choice > 0 ){
                if( aval[ choice ] ){
                    if( choice < 10 )
                        price = 50;
                    else if( choice >= 10 && choice < 20 )
                        price = 100;
                    else if( choice >= 20 && choice < 30 )
                        price = 150;
                    else
                        price = 200;
                
                    if( player.getMoney() < price ){
                    System.out.println("Masz za malo kasy, hahaha!");
                    }
                    else{
                        ((StreetF)Map.fields[choice]).addHouseHotel();
                        player.setMoney( player.getMoney() - price );
                    }
                }
            }
        }
    }

    public static void tradeMenu(){

    }

    public static void pledgeMenu(){

    }

    public static void creditMenu(){

    }

    public static void bankruptMenu( Player player, Player owner ){
        for( int i = 0; i < 40; i++ ){
            if( Map.fields[i] instanceof StreetF ){
                ((StreetF)Map.fields[i]).setOwner(owner);
            }
            else if( Map.fields[i] instanceof BuildingF ){
                ((BuildingF)Map.fields[i]).setOwner(owner);
            }
            else if( Map.fields[i] instanceof StationF ){
                ((StationF)Map.fields[i]).setOwner(owner);
            }
        }
        player.setBankrupt( true );
        owner.setMoney( player.getMoney() );
        player.setMoney( 0 );
        Map.fields[ player.getWhere() ].deletePlayer( player.getName() );
    }

    public static void bankruptMenu( Player player ){
        //licytacja ekwipunku
        player.setBankrupt( true );
        player.setMoney( 0 );
        Map.fields[ player.getWhere() ].deletePlayer( player.getName() );
    }

    public static void auctionMenu(){

    }
}