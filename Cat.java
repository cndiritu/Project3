import java.util.Random;

/**
 * Represents the Cat class
 * @author Chris Ndiritu
 */
public class Cat implements Pet {
    /** The name of the Cat */
    private String name;
    /** The amount of hunger. Shows how hungry the cat is */
    private int hunger;
    /** Shows if the cat is healthy, true if healthy false if not. */
    private boolean health;
    /** The amount of happiness. */
    private int mood;
    /** Random object */
    private Random rand;
    /** New instance variable. Shows the cat's need to go outside. */
    private int outdoorLevel;

    /**
     * Cat Constructor
     */
    public Cat(){

    }

    /**
     * Creates the Cat object
     *
     * @param n Represents the name of Cat
     * @param h Represents the amount of hunger
     * @param r Represents the random variable
     * @param m Represents the amount of happiness
     */
    public Cat(String n, int h, Random r, int m) {
        this.name = n;
        this.hunger = h;
        this.rand = r;
        this.health = true; //all cats start off healthy
        this.mood = m;
        this.outdoorLevel = 4;
    }

    /**
     * The name of the cat
     *
     * @return The name of the cat
     */
    public String getName() {
        return this.name;
    }

    /**
     * The amount of happiness
     *
     * @return The amount of happiness
     */
    public int getMood() {
        return this.mood;
    }

    /**
     * When this method is called, the pet receives attention.
     *
     * @param amount An integer representation of the amount of attention received by the pet.
     */
    public void receiveAttention(int amount) {
            this.mood += amount;

    }

    /**
     * Returns an integer representation of this pet's hunger level. A larger integer
     * represents a greater level of hunger.
     *
     * @return An integer representation of this pet's hunger.
     */
    public int getHunger() {
        return this.hunger;
    }

    /**
     * When this method is called, the pet receives food.
     *
     * @param amount An integer representation of the amount of food received by the pet.
     */
    public void receiveFood(int amount) { /** Cat recieves food which increases it's hunger level */
            this.hunger -= amount;

    }

    /**
     * Return true if healthy false if false
     *
     * @return true if pet is healthy, false if false
     */
    public boolean getHealth(){ /** Returns whether or not the Cat is in good health */
        //Conditions of good health hunger is above 6 and mood is above 6
        if(this.hunger <= 6 & this.mood >= 6 ){
            this.health = true;
        }
        else{
            this.health = false;
        }
        return this.health;
    }

    /**
     * Represents the outdoor need of the cat
     * @return the need of the cat to go outdoors
     */
    public int getOutside() {
        return this.outdoorLevel;
    }

    /**
     * Adjusts the outdoor need and the cat's happiness when called.
     */
    public void goOutside() {
        this.outdoorLevel +=1;
        this.mood += 1;
    }



    /**
     * This method is called during every time step of the simulation. This method
     * updates the pet's state.
     */
    public void tick() {

        int num = this.rand.nextInt(100);
        if (num <= 10) {
            this.mood -= 8;
            this.outdoorLevel -=5;

        }
        this.hunger += 1;
        goOutside();

    }
}