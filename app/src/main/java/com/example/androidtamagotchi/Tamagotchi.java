package com.example.androidtamagotchi;

public class Tamagotchi extends Thread {
    //interface tänne
    //ensin ruuan syönti, ilmotus interfacella

    private int food;
    private String status;
    private int ID;
    TamagotchiInterface callbackInterface = null;
    boolean alive;

    public interface TamagotchiInterface{
        public void TamagotchiStatus(Tamagotchi tamagotchi);
    }

    public Tamagotchi(int startFood, int ID, TamagotchiInterface cInterface) {
        this.callbackInterface = cInterface;
        this.food = startFood;
        this.ID = ID;
        this.alive = true;
        this.status = "Alive";
    }



    @Override
    public void run() {
        while(this.alive) {
            try {
                this.food--;
                if(this.food < 1 || this.food > 20) {
                    this.status = "Tamagotchi dead";
                    this.alive = false;
                    this.food = -1;
                }
                callbackInterface.TamagotchiStatus(this);
                sleep(2000);
                //System.out.println("");
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public boolean feed() {
        if (food < 0 || food > 20) {
            this.alive = false;
            this.status = "dead";
            return false;
        }
        this.food += 10;
        return true;
    }

    public String getStatus() {
        if(food < 0 || food > 20) {
            this.status = "Tamagotchi dead";
        }
        return this.status;
    }




    public int getFood() {
        return this.food;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public void setFood(int food) {
        this.food+=food;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }
}

