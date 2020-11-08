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


    public int lookForCounter(List<Office> officeList, Document findDocument){
//        System.out.println("start func");
        for (Office office : officeList){
//            System.out.println(" office " + office.getId());
            for (Document document : office.getDocumentList()){
//                System.out.println(" office " + office.getId() + "document : " + document.getDocumentName());
                if(findDocument.getDocumentName().equals(document.getDocumentName()))
                    return office.getId();
            }
        }
        return -1;
    }

    // functie asemanatoare cu "semaforul" din curs
    // verifica daca un counter e in pauza sau nu
    // daca e in pauza cauta un ccounter disponibil
    // daca nu e in pauza trimite clientul acolo

}