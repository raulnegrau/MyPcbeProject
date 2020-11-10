package com.rauln.entity;

import java.util.List;

public class Office {
    private String name;

    private List<Counter> counterList;

    private List<Document> documentList;

    public Office(String name, List<Counter> counterList, List<Document> documentList){
        this.name = name;
        this.counterList = counterList;
        this.documentList = documentList;
    }

    public String getName(){
        return name;
    }
    public List<Counter> getCounterList(){
        return counterList;
    }
    public List<Document> getDocumentList(){
        return documentList;
    }

    //seters
    public void setCounterList(List<Counter> counterList){
        this.counterList = counterList;
    }
    public void setDocumentList(List<Document> documentList){
        this.documentList = documentList;
    }


    public void lookForCounter(Document document) throws InterruptedException {
        System.out.println(" Office " + getName() + " looking for counter! ");
        int k = 1;
        while(k == 1) {
            for (Counter counter : getCounterList()) {
                if (counter.counterReady(document)) {
                    System.out.println(" Client leaved counter " + counter.getName());
                    k = 0;
                    break;
                }
                if(k == 1)System.out.println("No available counters at this time!");
            }
        }
    }
}