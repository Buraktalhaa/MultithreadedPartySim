
package party;

public class Tray {
    private int capacity;
    private int itemCount;
    private int tepsideKalan = 5;
    public String name;
    static int finishCount = 3;


    public Tray(int itemCount, String name) {
        this.capacity = 5;
        this.itemCount = itemCount;
        this.name = name;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void decrementItemCount() {
        if (itemCount > 0)
            itemCount--;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }
    
    public int remainingItems() {  
        return tepsideKalan;
    }
    
    public void fillRemainingItems(){
        if (itemCount >= 5){
            tepsideKalan = capacity;   
        }
        else if((itemCount < 5) && (itemCount >= 1)){
            tepsideKalan = itemCount;
        }
        else if(itemCount == 0){
            System.out.println("The " + name + "s tray is out of products");
            finishCount--;
        }
        if(finishCount == 0){
            System.out.println("Party is over!!!");
            System.exit(0);
        }
    }
    
    public void decrementRemainingItems(){
        tepsideKalan =tepsideKalan - 1;
    }
    

}


