package com.rauln.entity;

import com.rauln.entity.Document;

public class Client {
    private int id;
    private static int idCounter = 0;

    private Document document;

    public Client(Document document){
        id = idCounter++;
        this.document = document;
    }

    public int getId(){
        return id;
    }

    public Document getDocument(){
        return document;
    }
}