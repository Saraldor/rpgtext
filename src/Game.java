import java.util.Scanner;


public class Game {
  Scanner theScanner = new Scanner(System.in);
  Scanner enterScanner = new Scanner(System.in);
  int playerHP;
  int orcHP;
  int silverRing;
  String playerName;
  String playerWeapon;
  String orcWeapon;
  int choice;

  public static void main(String[] args) {

    Game newGame;
    newGame = new Game();
    newGame.playerSetup();
    newGame.townGate();

  }

  public void playerSetup() {

    playerHP = 20;
    orcHP = 10;
    orcWeapon = "Small Axe";
    playerWeapon = "Short Sword";
    System.out.println("Your HP: " + playerHP);
    System.out.println("Your Weapon: " + playerWeapon);

    System.out.println("Enter Player Name");
    playerName = theScanner.nextLine();
    System.out.println("Welcome " + playerName + ", Let´s start you adventures!");
  }

  public void townGate() {
    System.out.println("******TOWN******");

    System.out.println("Your are at the gate of the town");

    System.out.println("A guard is standing in front of the gate");
    System.out.println("What do you want to do?");
    System.out.println("*************************");
    System.out.println("1: Talk to the guard");
    System.out.println("2: Kick the guard");
    System.out.println("3: Leave");


    choice = theScanner.nextInt();
    if (choice == 1) {
      if (silverRing == 1) {
        end();
      } else {
        System.out.println("Guard: Hello there stranger, so your name is " + playerName + "? Sorry we can not let strangers in the Town");
        enterScanner.nextLine();
        townGate();
      }
    }
    if (choice == 2) {
      playerHP = playerHP - 1;
      System.out.println("Guard: What are you doing\n The guard hit you hard \n (You receive 1 damage)\n Your HP " + playerHP);
      enterScanner.nextLine();
      townGate();
    }

    if (choice == 3) {
      crossRoad();
    } else {
      townGate();
    }
  }

  public void crossRoad() {
    System.out.println("******THE CROSSROAD*******");
    System.out.println("1: Go north");
    System.out.println("2: Go east");
    System.out.println("3: Go south");
    System.out.println("4: Go west");
    System.out.println("*************************");

    choice = theScanner.nextInt();
    if (choice == 1) {
      north();
    }
    if (choice == 2) {
      east();
    }
    if (choice == 3) {
      townGate();
    }
    if (choice == 4) {
      west();
    } else {
      crossRoad();
    }


  }

  public void north() {
    System.out.println("****** North *******");
    System.out.println("There is a river.\n You drink the water and rest\n You HP is recovered.");
    playerHP = playerHP + 1;
    System.out.println("HP:" + playerHP);
    System.out.println("\n\n1: Go back to the Crossroad");
    System.out.println("*************************");
    choice = theScanner.nextInt();
    if (choice == 1) {
      crossRoad();

    } else {
      north();
    }

  }


  public void east() {
    System.out.println("****** East *******");
    System.out.println("You walk in to the forest\n You found a long Sword");
    playerWeapon = "Long Sword";
    System.out.println("Your new Weapon" + playerWeapon);
    System.out.println("\n\n1: Go back to the Crossroad");
    System.out.println("*************************");
    choice = theScanner.nextInt();
    if (choice == 1) {
      crossRoad();

    } else {
      east();
    }
  }

  public void west() {
    System.out.println("****** West *******");
    System.out.println("You encounter a Orc");
    System.out.println("1: Fight");
    System.out.println("2: Run");
    choice = theScanner.nextInt();
    if (choice == 1) {
      fight();
    }

    if (choice == 2) {
      crossRoad();

    } else {
      west();


    }
  }

  public void fight() {
    System.out.println("****** Fight *******");

    System.out.println("You HP: " + playerHP + " Weapon:" + playerWeapon);
    System.out.println("Orc HP: " + orcHP + " Weapon:" + orcWeapon);
    System.out.println("1: Attack");
    System.out.println("2: Run");
    choice = theScanner.nextInt();
    if (choice == 1) {
      attack();
    }

    if (choice == 2) {
      crossRoad();

    } else {
      attack();


    }
  }

  public void attack() {
    int playerDamage = 0;


    if (playerWeapon.equals("Short Sword")) {
      playerDamage = new java.util.Random().nextInt(2);
    }
    if (playerWeapon.equals("Long Sword")) {
      playerDamage = new java.util.Random().nextInt(5);
    }
      System.out.println("You Attack the Orc and gave it " + playerDamage + "damage!");

      orcHP = orcHP - playerDamage;
      System.out.println("Orc HP: " + orcHP);
      if (orcHP < 1) {
        winner();
      }
      if (orcHP > 0) {
        int orcDamage;
        orcDamage = new java.util.Random().nextInt(4);
        System.out.println("Orc attack you and gave you: " + orcDamage + " damage");
        playerHP = playerHP - orcDamage;
        System.out.println("Your HP " + playerHP);
        if (playerHP < 1) {
          dead();

        }
        if (playerHP > 0) {
          fight();
        }
      }
    }


  public void dead() {
    System.out.println("****** DEAD *******");
    System.out.println("You are dead!!!");
    System.out.println("You are dead!!!");
    System.out.println("****** DEAD *******");
  }

  public void winner() {
    System.out.println("****** WINNER ********");
    System.out.println("You kill the Orc!");
    System.out.println("the orc dropped a ring!");
    System.out.println("you obtained a silver ring!");
    System.out.println("1: Go east");
    System.out.println("2: Go forward in to the forest");
    System.out.println("****** WINNER ********");
    silverRing = 1;
    choice = theScanner.nextInt();
    if (choice == 1) {
      crossRoad();

    } else {
      winner();
    }

  }
public void end(){
  System.out.println("****** THE GUARD********");
  System.out.println("Guard: You killed the orc");
  System.out.println("Guard: It seems you are a trustworthy guy.Welcome to our Town!");
  System.out.println("\n\n\n End");
  System.out.println("****** END ********");
}


}
