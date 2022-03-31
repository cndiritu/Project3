import java.util.Random;
import java.util.Scanner;

/**
 * @authors Giovanni Peyo and Christian Ndiritu
 */
public class testingconsole {
    /** The input of the User */
    private Scanner keyboardIn;
    /** Creating a cat object */
    private Cat catz;
    /** Creating a CatOwner object */
    private CatOwner own;

    /**
     * Creates the console
     * @param r The random variable that will get the 10%
     */
    public testingconsole(Random r) {
        this.keyboardIn = new Scanner(System.in);
        String name = askforName();
        this.catz = new Cat(name,3,r,10);
        this.own = new CatOwner(10,10,0);
    }

    /**
     * Finds the name of the cat.
     * @return The Name of the cat
     */
    private String askforName(){
        System.out.print("What is your cat's name: ");
        String n = keyboardIn.nextLine();
        return n;

    }

    /**
     * Creates the RUN that returns nothing.
     * Contains the possible options the user can choose
     */
    public void run() {

        boolean keepRunning = true;

        while (keepRunning == true) { // Could I use a do..while loop?
            System.out.println("You have " + this.own.getFoodLevel() + " Food points and " + this.own.getTimeLevel() + " Time points");

            if(catz.getHealth()==true){
                System.out.println(this.catz.getName()+ " has good health");
            }
            else if(catz.getHealth()==false){
                System.out.println(this.catz.getName()+ " has poor health");
            }


            System.out.println("Happiness = "+ this.catz.getMood());
            System.out.println("Hunger = "+ this.catz.getHunger());
            System.out.println("Outdoor Fun = " + this.catz.getOutside());

            System.out.println("What would like you to do with "+this.catz.getName());
            System.out.println("1 = feed; 2 = play; 3 = nothing --- Enter your choice: ");
            int response = keyboardIn.nextInt();
            if(keyboardIn.hasNextLine()) {
                keyboardIn.nextLine();
            }

            if(response == 1){
                System.out.println("How much would you like to feed "+this.catz.getName());
                int foodanswer = this.keyboardIn.nextInt();
                if(keyboardIn.hasNextLine()) {
                    keyboardIn.nextLine();
                }
                if(foodanswer <= this.own.getFoodLevel()){
                    this.catz.receiveFood(foodanswer); // Make sure cat doesn't have the extra food the owner has
                    this.own.feedPet(foodanswer);

                }

                this.catz.tick(); // Can I make a private method in this class to call the tick method for the cat and the owner?
                this.own.tick();
            }
            else if(response == 2){
                System.out.println("How much time would you like to spend with "+catz.getName());
                int timeanswer = this.keyboardIn.nextInt();
                if(keyboardIn.hasNextLine()) {
                    keyboardIn.nextLine();
                }
                if(timeanswer <= this.own.getTimeLevel()){
                    this.catz.receiveAttention(timeanswer);
                    this.own.giveAttention(timeanswer);
                }


                this.catz.tick();
                this.own.tick();
            }

            else if(response == 3){
                this.catz.tick();
                this.own.tick();
            }

            System.out.println("---------------------");
            System.out.println();
            System.out.println("Would you like to keep playing? type 1 for Yes click 2 for No");
            int ans = this.keyboardIn.nextInt();
            if(ans == 2){
                keepRunning = false;
            }


        }

        System.out.println("At the end of the game");
        if(catz.getHealth() == true){ //Could I make a methods for lines 85-89? I copied these from lines 33-37
            System.out.println(catz.getName()+ " has good health");
        }
        else if(catz.getHealth() == false){
            System.out.println(catz.getName()+ " has poor health");

            System.out.println("Happiness = "+ catz.getMood());
            System.out.println("Hunger = "+ catz.getHunger());



        }
    }

    /**
     * Main method
     * @param args used to build the console
     */
    public static void main(String[] args){
        System.out.println("Welcome to the Pet Cat Simulation");

        Random rand = new Random();

        testingconsole petConsole = new testingconsole(rand);
        petConsole.run();

    }
}
