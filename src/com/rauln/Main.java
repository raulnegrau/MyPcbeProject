package com.rauln;

import com.rauln.create.DocumentDatabase;
import com.rauln.entity.Document;
import com.rauln.entity.File;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DocumentDatabase documentDatabase = new DocumentDatabase();
        documentDatabase.getAllFilesFromTheDatabase();
        System.out.println(documentDatabase.toString());

//        Document doc = documentDatabase.getAllFilesFromTheDatabase().get(0);
//
//
//
//        System.out.println(doc.checkDocument());
//        for(Document document : doc.getIntermediateDocumentList()){
//            document.setDocumentState(true);
//        }
//        System.out.println(doc.checkDocument());
//        doc.setDocumentState(true);
//        System.out.println(doc.checkDocument());

    }
}
