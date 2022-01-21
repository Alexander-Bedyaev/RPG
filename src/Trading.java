import java.util.Scanner;

public class Trading {
    Scanner scanner = new Scanner(System.in);
    Vendor vendor = new Vendor();

    public void purchase() {
        System.out.println("У торговца " + vendor.meds + " порций лекарства. 20 золота/порция");
        System.out.println("У вас " + Game.player.gold + " золота");
        System.out.println("Сколько лекарства вы хотите купить?");
        byte medsToBuy = scanner.nextByte();
        if (medsToBuy < vendor.meds && 0 < medsToBuy && medsToBuy * 20 <= Game.player.gold) {
           vendor.meds = (byte) (vendor.meds - medsToBuy);
            Game.player.gold = Game.player.gold - medsToBuy * 20;
            Game.player.meds = (byte) (Game.player.meds + medsToBuy);
            System.out.println("Сделка состоялась. У вас: " +  Game.player.gold + "-золота, " + Game.player.meds + "-лекарства");
        } else {
            System.out.println("Вы не можете купить указанное количество лекарства");
        }

        Game.actionOption();
    }
}
