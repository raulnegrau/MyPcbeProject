package com.rauln.create;

import com.rauln.entity.Document;
import com.rauln.entity.File;

import java.util.ArrayList;
import java.util.List;

public class DocumentDatabase {

    private List<Document> files;

    public DocumentDatabase(){
        this.files = new ArrayList<Document>();
    }


    public List<Document> getAllFilesFromTheDatabase(){
        List<Document> listDocument1 = new ArrayList<Document>();
        List<Document> listSubDoc12 = new ArrayList<Document>();

        listSubDoc12.add(new Document("subdoc1.2.1", null));
        listSubDoc12.add(new Document("subdoc1.2.2", null));

        listDocument1.add(new Document("subdoc1.1", null));
        listDocument1.add(new Document("subdoc1.2", listSubDoc12));
        listDocument1.add(new Document("subdoc1.3", null));


        files.add(new Document("Document1", listDocument1));


        files.add(new Document("Document2", listDocument1));



        files.add(new Document("Document3", listDocument1));


        files.add(new Document("Document4", listDocument1));
        return files;
    }

    public String toString(){
        String text = "";
        for(Document doc : this.files){
            text = text + doc.getDocumentName() + "\n";
        }
        return text;
    }

}
