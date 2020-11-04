package com.rauln.entity;

import java.util.Date;
// un ghiseu intra in pauza numa ce o eliberat un anumit numar de documente

public class Counter {
    private int id;
    private static int idCounter = 0;

    private boolean breakStatus = false;
    private long breakTime;

    public Counter(){
        this.id = idCounter++;
    }

    //Setters
    public void setBreakTime(int breakTime){
        this.breakTime = breakTime;
    }

    //getters
    public int getId() {
        return id;
    }
    public boolean getBreakStatus(){
        return breakStatus;
    }

    // alt nume
    public void setPauza(){
        // !!! concurenta
        int n = (int) (Math.random()*10);
        if(n <= 2){
            Date date = new Date();
            breakTime = date.getTime();
            breakStatus = true;
        }
        else breakStatus = false;
    }



}