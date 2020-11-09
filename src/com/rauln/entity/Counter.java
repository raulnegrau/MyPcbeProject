package com.rauln.entity;

import java.util.Date;
// un ghiseu intra in pauza numa ce o eliberat un anumit numar de documente

public class Counter{
    private String name;
//    private int id;
//    private static int idCounter = 0;
    private volatile boolean hasClient = false;

    private boolean breakStatus = false;

    public Counter(String name){
        this.name = name;
    }


    //getters
    public String getName() {
        return name;
    }
    public boolean getBreakStatus(){
        return breakStatus;
    }

    // alt nume
    public void setBreakStatus(){
        int number = (int) (Math.random() * 10) % 10;
        if(number < 4){
            breakStatus = true;
        }
        else {
            breakStatus = false;
        }
    }




        // rezolv concurency
        // resursa partajata din document: documentType
    public boolean counterReady(Document document) throws InterruptedException {
        setBreakStatus();
        if(hasClient == false && breakStatus == false){
            hasClient = true;
            System.out.println("~Counter " + getName() + " working with a client!");
            document.setDocumentState(true);
            //Thread.sleep(1000);
            hasClient = false;
            return true;
        }
        if(hasClient == true) {
            System.out.println("~Counter " + getName() + " has already a client!");
            System.exit(1); // ceva nu merge bine xD
        }
        if(breakStatus == true) {
            System.out.println("~Counter " + getName() + " : break time!");
        }
        return false;
    }

}