/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

/*
* OK, so this is the Runner class. I'm gonna take you through how it works.
* First, you run the program (good job), and a Scanner asks the user for their name.
* That name is the only controllable input into creating their profile courtesy of Profile.java
* A completely random dungeon is created. You can find a more detailed process by looking at the comments on
* randomGenerateField();.
* The game starts. More details will follow.
*/

import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        boolean gameEnd = false; boolean walkIntoWall = false;

        // The character creation process, based on Profile class. The only real input the user has is with their name.
        System.out.println("WARNING: The map only works right if you have the right font. In IntelliJ, go to File>Settings>Editor>Font>Change Font to Consolas");
        System.out.println("Welcome, enter your name.");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] tutorial = {
                "Welcome to Fungeon, a randomly generated turn-based dungeon game where you must explore the dungeon room by room to reach the boss room.",
                "Every room will start off hidden until you explore it. The boss room is visible on the map at all times, which is your goal.",
                "You navigate the world using n, e, s, and w, to explore north, east, west, and south. Your compass on the left will tell you your options, in addition to the main screen.",
                "If there is a wall in any direction, you would not be able to travel through. You gain a bit of health over time as you travel between rooms.",
                "There are five different types of rooms total in Fungeon.",
                "You start off in the Starting Room. There is nothing here, but if you return to this room, all of your health will be restored.",
                "An item room will give you the option to take or ignore a random item of a certain rarity. They spawn less frequently than battle rooms. Since this is randomly generated, you might not even be able to encounter one.",
                "An empty room is empty.",
                "A battle room will give you an encounter with a random enemy.",
                "During a battle, all of your stats will be factored into different aspects of the battle. Your strength will scale with the damage that you or your enemies deal, while defence of an opponent inversely scales with it.",
                "Your speed will determine your chance of successfully fleeing from a battle. It is compared to an enemy's speed.",
                "During a battle, you may choose to attack with a, defend and restore some health with d, inspect the enemy and view their stats with i, view your own stats with t, or attempt to flee with r.",
                "All of these actions will count as a turn EXCEPT for viewing your own stats. If you fail to flee, you will take extra damage if the enemy attacks.",
                "If you defeat an enemy in battle, the room will become safe for the remainder of the game and your stats may increase. If you flee, only the room will be safe.",
                "The more enemies you defeat, the stronger they get, so choose your fights wisely.",
                "The final room that has yet to be mentioned is the boss room. In here, you will fight an enemy with increased health and other stats. You will not be able to flee from this battle.",
                "Do NOT try to flee from a boss fight.",
                "The boss will have the ability to use special attacks.",
                "If you get lost while exploring, you can always use m to check the map, or t to check your own stats.",
                "Battle rooms will be marked with a B, Item rooms are marked with a T (as in treasure), the starting room will be marked with an S, and X marks the boss room.",
                "Good luck."
        };
        boolean tutorialEnded = false;
        while (!tutorialEnded) {
            System.out.println("Would you like to take the tutorial? (y/n)");
            in = new Scanner(System.in);
            input = in.nextLine();
            input.toLowerCase().trim();
            if (input.equals("y")) {
                tutorialEnded = true;
                System.out.println("Press enter after each line to continue.");
                for (int i = 0; i < tutorial.length; i++) {
                    System.out.println(tutorial[i]);
                    in = new Scanner(System.in);
                    input = in.nextLine();
                }
            }
            if (input.equals("n")) {
                tutorialEnded = true;
            }
        }

        int fieldLength = 11; int fieldWidth = 11;
        Profile you = new Profile(input, fieldLength/2, fieldLength/2, 100);
        Board board = new Board(fieldLength,fieldWidth);
        // Room[][] field = board.returnField();


        while (!gameEnd) {
            walkIntoWall = false;
            int xLoc = you.returnLocation()[1];
            int yLoc = you.returnLocation()[0];
            boolean enterBossRoom;
            Room n, e, s, w;
            n = board.getRoom(xLoc,yLoc-1);
            e = board.getRoom(xLoc+1,yLoc);
            s = board.getRoom(xLoc,yLoc+1);
            w = board.getRoom(xLoc-1,yLoc);
            printGUI(n, e, s, w);


            in = new Scanner(System.in);
            input = in.nextLine().toLowerCase();

            if (input.equals("m")) {
                board.printMap(you);
            }
            if (input.equals("n")) {
                if (n.isAnActualRoom()) {
                    if (n.bossRoom()) {
                        enterBossRoom = warnPlayerOfImpedingDoom();
                        if (enterBossRoom) {
                            board.getRoom(xLoc,yLoc).leaveRoom();
                            you.changeHealth((int) (you.health * 0.2));
                            gameEnd = n.enterRoom(you);
                        }
                    }
                    else {
                        board.getRoom(xLoc,yLoc).leaveRoom();
                        you.changeHealth((int) (you.health * 0.2));
                        gameEnd = n.enterRoom(you);
                    }
                }
                else {walkIntoWall = true;}
            }
            if (input.equals("e")) {
                if (e.isAnActualRoom()) {
                    if (e.bossRoom()) {
                        enterBossRoom = warnPlayerOfImpedingDoom();
                        if (enterBossRoom) {
                            board.getRoom(xLoc,yLoc).leaveRoom();
                            you.changeHealth((int) (you.health * 0.2));
                            gameEnd = e.enterRoom(you);
                        }
                    }
                    else {
                        board.getRoom(xLoc,yLoc).leaveRoom();
                        you.changeHealth((int) (you.health * 0.2));
                        gameEnd = e.enterRoom(you);
                    }
                }
                else {walkIntoWall = true;}
            }
            if (input.equals("s")) {
                if (s.isAnActualRoom()) {
                    if (s.bossRoom()) {
                        enterBossRoom = warnPlayerOfImpedingDoom();
                        if (enterBossRoom) {
                            board.getRoom(xLoc,yLoc).leaveRoom();
                            you.changeHealth((int) (you.health * 0.2));
                            gameEnd = s.enterRoom(you);
                        }
                    }
                    else {
                        board.getRoom(xLoc,yLoc).leaveRoom();
                        you.changeHealth((int) (you.health * 0.2));
                        gameEnd = s.enterRoom(you);
                    }
                }
                else {walkIntoWall = true;}
            }
            if (input.equals("w")) {
                if (w.isAnActualRoom()) {
                    if (w.bossRoom()) {
                        enterBossRoom = warnPlayerOfImpedingDoom();
                        if (enterBossRoom) {
                            board.getRoom(xLoc,yLoc).leaveRoom();
                            you.changeHealth((int) (you.health * 0.2));
                            gameEnd = w.enterRoom(you);
                        }
                    }
                    else {
                        board.getRoom(xLoc,yLoc).leaveRoom();
                        you.changeHealth((int) (you.health * 0.2));
                        gameEnd = w.enterRoom(you);
                    }
                }
                else {walkIntoWall = true;}
            }
            if (input.equals("t")) {
                System.out.println("Name: " + you.returnName());
                System.out.println("Health: " + you.health + " / " + you.maxHealth);
                System.out.println("Strength: " + you.returnStat(1) + " (" + you.returnItem().strengthBonus + ")");
                System.out.println("Defence: " + you.returnStat(2) + " (" + you.returnItem().defenceBonus + ")");
                System.out.println("Speed: " + you.returnStat(0) + " (" + you.returnItem().speedBonus + ")");
                System.out.println("Item: " + you.returnItem().name);
            }
            // You may have noticed that the y, x format (length, width) has been switched to x, y in this particular case.
            // I don't know why, but for some crazy fucking reason y, x doesn't seem to work, and x,y does.
            // So I'm keeping it like this.
            if (walkIntoWall) {
                System.out.println("You stare down the cave wall, then walk straight into it. You take 1 damage.");
                you.changeHealth(-1);
                System.out.println("Type anything to continue.");
                in = new Scanner(System.in);
                input = in.nextLine();
            }
            if (you.returnDeathStatus()) {
                gameEnd = true;
            }
        }
        if (you.returnDeathStatus()) {
            System.out.println("  #####      #     #     #  ######               #####    #     #  #######  ######  ");
            System.out.println(" #     #    # #    ##   ##  #                   #     #   #     #  #        #     # ");
            System.out.println(" #         #   #   # # # #  #                   #     #   #     #  #        #     # ");
            System.out.println(" #        #     #  #  #  #  #####               #     #   #     #  #####    ######  ");
            System.out.println(" #   ###  #######  #     #  #                   #     #    #   #   #        #  #    ");
            System.out.println(" #     #  #     #  #     #  #                   #     #     # #    #        #   #   ");
            System.out.println("  #####   #     #  #     #  ######               #####       #     #######  #    #  ");
        }
        else {
            System.out.println(" #     #   #####   #     #          #       #   #####  #     # ");
            System.out.println("  #   #   #     #  #     #          #       #     #    ##    # ");
            System.out.println("   # #    #     #  #     #          #       #     #    # #   # ");
            System.out.println("    #     #     #  #     #          #       #     #    #  #  # ");
            System.out.println("    #     #     #  #     #          #   #   #     #    #   # # ");
            System.out.println("    #     #     #  #     #           # # # #      #    #    ## ");
            System.out.println("    #      #####    #####             #   #     #####  #     # ");
        }


    }

    public static int generateRandomInteger(int min, int max) {
        return (int) (Math.random() * ((max + 1) - min)) + min;
    }

    public static void printGUI(Room n, Room e, Room s, Room w) {
        String[] GUI = {
                "       NORTH       ||", // 21 characters long
                "         ^         ||",
                "  WEST  < >  EAST  ||",
                "         V         ||",
                "       SOUTH       ||",
                "                   ||"
        };
        String[] overworld = {
                "  Your options:",
                "  (N)orth",
                "  (E)ast",
                "  (S)outh",
                "  (W)est",
                "  You can also check the (M)ap, or your S(T)ats."
        };
        if (!n.isAnActualRoom()) {
            GUI[0] = "                   ||";
            GUI[1] = "                   ||";
            overworld[1] = "";
        }
        if (!w.isAnActualRoom() && !e.isAnActualRoom()) {
            GUI[2] = "                   ||";
            overworld[2] = "";
            overworld[4] = "";
        }
        if (!w.isAnActualRoom() && e.isAnActualRoom()) {
            GUI[2] = "          >  EAST  ||";
            overworld[4] = "";
        }
        if (!e.isAnActualRoom() && w.isAnActualRoom()) {
            GUI[2] = "  WEST  <          ||";
            overworld[2] = "";
        }
        if (!s.isAnActualRoom()) {
            GUI[3] = "                   ||";
            GUI[4] = "                   ||";
            overworld[3] = "";
        }

        for (int i = 0; i < 6; i ++) {
            System.out.println(GUI[i] + overworld[i]);
        }

    }
    public static boolean warnPlayerOfImpedingDoom() {
        System.out.println("WARNING: The room you are about to enter is a Boss Room. Do you wish to enter? (y/n)");
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
        in.toLowerCase().trim();
        while (!in.equals("y") && !in.equals("n")) {
            System.out.println("WARNING: The room you are about to enter is a Boss Room. Do you wish to enter? (y/n)");
            input = new Scanner(System.in);
            in = input.nextLine();
            in.toLowerCase().trim();
        }
        if (in.equals("y")) {
            return true;
        }
        else {
            System.out.println("You hesitate, and end up staying in your current room.");
            return false;
        }
    }

}
