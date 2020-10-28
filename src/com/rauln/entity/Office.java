package com.rauln.entity;

import java.util.List;

public class Office {
    private int officeId;
    private static int idCounter = 0;

    private List<Counter> counterList;

    private List<Document> documentList;

    public Office(List<Counter> counterList, List<Document> documentList){
        this.officeId = idCounter++;
        this.counterList = counterList;
        this.documentList = documentList;
    }

    //getters
    public int getId(){
        return officeId;
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




}