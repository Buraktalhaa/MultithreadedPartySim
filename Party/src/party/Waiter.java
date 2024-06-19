// Waiter.java
package party;

public class Waiter {
    public void fillTray(Tray tray) {
        if (tray.remainingItems() <= 1) {
            System.out.println("The " + tray.name + "tray has been refilled."); 
        } else {
            System.out.println("The tray does not need to be refilled.");
        }
    }

}


