package com.rauln.entity;

import com.rauln.create.DocumentDatabase;
import com.rauln.create.OfficeDatabase;

public class Client implements Runnable{
    private int id;
    private static int idCounter = 0;

    private Document document;

    public Client(Document document) throws InterruptedException {
        id = idCounter++;
        this.document = document;
        //Thread.sleep(3000);
    }

    public int getId(){
        return id;
    }

    public Document getDocument(){
        return document;
    }

    public void findOffice(Document document) throws InterruptedException {
        System.out.println(" Client " + getId() + " looking for office... ");
        OfficeDatabase officeDatabase = new OfficeDatabase();
        officeDatabase.initOfficeDatabaseWithData();
        if(!document.getDocumentType()) {
            System.out.println(document.getDocumentName() + " is a regular file!");
            Office office = officeDatabase.lookForTheRightOfficeToGo(document.getDocumentName());
            System.out.println(" Client " + getId() + " found office " + office.getName());
            office.lookForCounter(document);
        } else {
            System.out.println(" Looks like " + document.getDocumentName() + " is a file!" + document.getDocumentType());
            for(Document doc : document.getIntermediateDocumentList()){
                System.out.println(" Client " + getId() + " is looking for the right office for " + doc.getDocumentName());
                findOffice(doc);
            }
            document.setDocumentState(true);
        }
        if(document.getDocumentState()) System.out.println(" File " + document.getDocumentName() + " completed!");
    }

    @Override
    public void run() {
        try {
            findOffice(this.document);
        } catch (InterruptedException e) {
            System.out.println("Sleep error : " + e.getMessage());
        }
    }
}