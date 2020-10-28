package com.rauln.entity;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private String documentName;
    private List<Document> intermediateDocumentList;
    private boolean documentState = false; // 1 => document procurat, 0 => document neprocurat
    private boolean documentType = true; // 1 => exista subdocumente, 0 => nu exista subdocumente

    public Document(String documentName, List<Document> intermediateDocumentList){
        this.documentName = documentName;
        if(intermediateDocumentList == null) {
            this.intermediateDocumentList = new ArrayList<Document>();
            this.documentType = false;
        }
        else this.intermediateDocumentList = intermediateDocumentList;
    }

    //getters
    public String getDocumentName(){
        return documentName;
    }
    public List<Document> getIntermediateDocumentList(){
        return intermediateDocumentList;
    }
    public boolean getDocumentState(){
        return this.documentState;
    }
    public boolean getDocumentType(){
        return documentType;
    }

    //setters
    public void setDocumentName(String documentName){
        this.documentName = documentName;
    }
    public void setIntermediateDocumentList(List<Document> intermediateDocumentList){
        this.intermediateDocumentList = intermediateDocumentList;
    }
    public void setDocumentState(boolean documentState){
        this.documentState = documentState;
    }
    public void setDocumentType(boolean documentType){
        this.documentType = documentType;
    }

    public boolean checkDocument() {
        // true when all anexes are true
        //boolean otherDocumentsState = true;
        if(intermediateDocumentList.isEmpty()){
            return documentState;
        }
        //System.out.println("Am trecut de primul if!");
        if(documentState){
            for(Document document : intermediateDocumentList){
                if(!document.checkDocument()) {
                    //System.out.println("False in for");
                    return false;
                }
            }
            return true;
        }
        //System.out.println("Ultimul return false!");
        return false;
    }

    public String toString(){
        return documentName;
    }

}