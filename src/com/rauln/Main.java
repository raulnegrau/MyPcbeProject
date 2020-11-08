package com.rauln;

import com.rauln.create.DocumentDatabase;
import com.rauln.create.OfficeDatabase;
import com.rauln.entity.Client;
import com.rauln.entity.Counter;
import com.rauln.entity.Document;
import com.rauln.entity.Office;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DocumentDatabase documentDatabase = new DocumentDatabase();
        List<Document> documentList = documentDatabase.initDocumentDatabaseWithData();
//        System.out.println(documentDatabase.toString());
//        System.out.println(documentList.toString());
//        System.out.println(documentDatabase.getDocumentUsingIndex(1).toString());

//        System.out.println(documentDatabase.getAllSimpleDocuments());


        OfficeDatabase officeDatabase = new OfficeDatabase();
        List<Office> officeList = officeDatabase.initOfficeDatabaseWithData();
//        System.out.println(officeDatabase.toString());

//
//
//        System.out.println(doc.checkDocument());
//        for(Document document : doc.getIntermediateDocumentList()){
//            document.setDocumentState(true);
//        }
//        System.out.println(doc.checkDocument());
//        doc.setDocumentState(true);
//        System.out.println(doc.checkDocument());

        //create clients
        Client client;
        Thread thread;
        int indexDocument;
        int number = documentDatabase.mainDocumentCounter();
        for (int i = 0; i < 10; i++){
            indexDocument = (int) (Math.random() * 10 ) % number;
//            System.out.println(indexDocument);
            client = new Client(documentDatabase.cloneDocument(documentDatabase.getDocumentById(indexDocument)));
            Counter c = new Counter();
            thread = new Thread(c, " Client " + client.getId());
//            System.out.println("Client " + client.getId() + " wants " + client.getDocument().getDocumentName() + "\n");
            thread.start();
        }

        //        officeList.get(1).lookForCounter(officeList, new Document("Cerere tip pensie", null));

    }
}

