
package party;

public class Guest {
    private int borekCount;
    private int cakeCount;
    private int drinkCount;

    public Guest() {
        this.borekCount = 0;
        this.cakeCount = 0;
        this.drinkCount = 0;
    }

    public int getBorekCount() {
        return borekCount;
    }

    public void eatBorek() {
        if (borekCount < 4)
            borekCount++;
    }

    public int getCakeCount() {
        return cakeCount;
    }

    public void eatCake() {
        if (cakeCount < 2)
            cakeCount++;
    }

    public int getDrinkCount() {
        return drinkCount;
    }

    public void drink() {
        if (drinkCount < 4)
            drinkCount++;
    }

    public boolean isSatisfied() {
        return borekCount == 4 && cakeCount == 2 && drinkCount == 4;
    }
}
