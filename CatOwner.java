// UML Implementation

// UML Diagram

/**
 * Cat Owner
 *
 * - petFood: int
 * - timeAmount: int
 * - count: int
 *
 * +getFoodLevel(): this.petFood
 * +getTimeLevel(): this.timeAmount
 * +feedPet(int amount):
 * +giveAttention(int amount):
 * +tick(): void
 */

/**
 * @author Giovanni Peyo
 */
public class CatOwner extends Cat implements Owner {

    /** The Amount of food owner can give */
    private int petFood;
    /** The amount of time owner can give */
    private int timeAmount;
    /** Count variable for time steps */
    private int count;

    /**
     * Creates CatOwner object.
     * @param pet The amount of food owner can give.
     * @param time The amount of time owner can give
     * @param c Count variable for tick
     */
    public CatOwner( int pet, int time, int c) {
        this.petFood = pet;
        this.timeAmount = time;
        this.count = c;

    }

    /**
     * The food that the owner has.
     * @return the food the owner has
     */
    public int getFoodLevel() {
        return this.petFood;
    }

    /**
     * The time that the owner has
     * @return The time that the owner has
     */
    public int getTimeLevel() {
        return this.timeAmount;
    }

    /**
     * When this method is called the owner feeds their pet. The owner cannot feed
     * the pet more food than the owner has.
     * @param amount An integer representation of the amount of food given to the pet.
     */
    public void feedPet(int amount) {
        if (this.petFood - amount >= 0) {
            this.petFood -= amount;
            this.count +=1;
        }


    }

    /**
     * When this method is called the owner gives attention to their pet. The owner
     * cannot give more attention than the amount of time the owner has available.
     *
     * @param amount An integer representation of the amount of time the owner gives attention.
     */
    public void giveAttention (int amount) {
        if (this.timeAmount - amount >= 0) {
            this.timeAmount -= amount;
            this.count +=1;

        }
    }

    /**
     * This method is called during every time step of the simulation. This method
     * updates the owner's state.
     */

    public void tick() {
        this.count +=1;
        if (this.count == 10) {
            this.petFood += 10;
            this.timeAmount +=10;
            this.count =0;
        }

    }
}