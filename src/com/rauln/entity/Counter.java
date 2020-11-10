package com.rauln.entity;


public class Counter{
    private String name;
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

    public void setBreakStatus(){
        int number = (int) (Math.random() * 10) % 10;
        if(number < 4){
            breakStatus = true;
        }
        else {
            breakStatus = false;
        }
    }

    public boolean counterReady(Document document) throws InterruptedException {
        setBreakStatus();
        if(hasClient == false && breakStatus == false){
            hasClient = true;
            System.out.println("~Counter " + getName() + " working with a client!");
            document.setDocumentState(true);
            hasClient = false;
            return true;
        }
        if(hasClient == true) {
            System.out.println("~Counter " + getName() + " has already a client!");
        }
        if(breakStatus == true) {
            System.out.println("~Counter " + getName() + " : break time!");
        }
        return false;
    }

}