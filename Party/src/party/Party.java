
package party;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Party {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        List<Guest> guests = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            guests.add(new Guest());
        }
        
        Tray borekTray = new Tray(30, "Borek");
        Tray cakeTray = new Tray(15, "Cake");
        Tray drinkTray = new Tray(30, "Drink");

        Lock borekLock = new ReentrantLock();
        Lock cakeLock = new ReentrantLock();
        Lock drinkLock = new ReentrantLock();
        
        Thread[] guestThreads = new Thread[guests.size()];
        for (int i = 0; i < guestThreads.length; i++) {
            Guest guest = guests.get(i);
            guestThreads[i] = new Thread(() -> {
                while (!guest.isSatisfied()) {
                    // Servis yap
                    if (!borekTray.isEmpty()) {
                        borekLock.lock();
                        try {
                            if (!borekTray.isEmpty()) {
                                guest.eatBorek();
                                borekTray.decrementRemainingItems();
                                borekTray.decrementItemCount();
                                System.out.println("Guest " + guests.indexOf(guest) + " ate a borek.");
                                Thread.sleep(1000);
                                System.out.println("Total number of borek remaining = " + borekTray.getItemCount() +
                                        " /  Number of boreks left on tray = " + borekTray.remainingItems());

                                if (borekTray.remainingItems() <= 1) {
                                    waiter.fillTray(borekTray);
                                    Thread.sleep(3000);
                                    borekTray.fillRemainingItems();
                                } 
                               
                            }
                        } 
                        catch (InterruptedException ex) {
                            Logger.getLogger(Party.class.getName()).log(Level.SEVERE, null, ex);
                        }                        finally {
                            borekLock.unlock();
                        }
                    }

                    if (!cakeTray.isEmpty()) {
                        cakeLock.lock();
                        try {
                            if (!cakeTray.isEmpty()) {
                                guest.eatCake();
                                cakeTray.decrementRemainingItems();
                                cakeTray.decrementItemCount();
                                System.out.println("Guest " + guests.indexOf(guest) + " ate a slice of cake.");
                                Thread.sleep(1000);
                                System.out.println("Total number of cakes remaining = " + cakeTray.getItemCount() +
                                        " / Number of cakes left on tray = " + cakeTray.remainingItems());

                                if (cakeTray.remainingItems() <= 1) {
                                    waiter.fillTray(cakeTray);
                                    Thread.sleep(3000);
                                    cakeTray.fillRemainingItems();

                                } 
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Party.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            cakeLock.unlock();
                        }
                    }

                    if (!drinkTray.isEmpty()) {
                        drinkLock.lock();
                        try {
                            if (!drinkTray.isEmpty()) {
                                guest.drink();
                                drinkTray.decrementRemainingItems();
                                drinkTray.decrementItemCount();
                                System.out.println("Guest " + guests.indexOf(guest) + " drank a glass of drink.");
                                Thread.sleep(1000);
                                System.out.println("Total number of drinks remaining = " + drinkTray.getItemCount() +
                                        " / Number of drinks left on tray = " + drinkTray.remainingItems());

                                if (drinkTray.remainingItems() <= 1) {
                                    waiter.fillTray(drinkTray);
                                    Thread.sleep(3000);
                                    drinkTray.fillRemainingItems();

                                } 
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Party.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            drinkLock.unlock();
                        }
                    }


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            guestThreads[i].start();
        }

        for (Thread thread : guestThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Party is over. Guests are satisfied!");
    }
}
