package com.rauln;

import com.rauln.entity.Document;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // document 1
        List<Document> listDocument1 = new ArrayList<Document>();
        List<Document> listSubDoc12 = new ArrayList<Document>();

        listSubDoc12.add(new Document("subdoc1.2.1", null));
        listSubDoc12.add(new Document("subdoc1.2.2", null));

        listDocument1.add(new Document("subdoc1.1", null));
        listDocument1.add(new Document("subdoc1.2", listSubDoc12));
        listDocument1.add(new Document("subdoc1.3", null));

        Document doc = new Document("Document1", listDocument1);

        System.out.println(doc.checkDocument());
        for(Document document : doc.getIntermediateDocumentList()){
            document.setDocumentState(true);
        }
        System.out.println(doc.checkDocument());
        doc.setDocumentState(true);
        System.out.println(doc.checkDocument());

    }
}
