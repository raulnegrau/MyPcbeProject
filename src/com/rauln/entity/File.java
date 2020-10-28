package com.rauln.entity;

import java.util.List;

public class File {
    private String documentName;
    private List<Document> subDocumentList;

    public File(String documentName, List<Document> subDocumentList){
        this.documentName = documentName;
        this.subDocumentList = subDocumentList;
    }
    //getters
    public String getDocumentName(){
        return documentName;
    }
    public List<Document> getDocumentList(){
        return subDocumentList;
    }
    //setters
    public void setDocumentName(String documentName){
        this.documentName = documentName;
    }
    public void setSubDocumentList(List<Document> subDocumentList){
        this.subDocumentList = subDocumentList;
    }

    public void addSubDocument(Document subDocument){
        subDocumentList.add(subDocument);
    }
}