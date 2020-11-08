package com.rauln.create;

import com.rauln.entity.Document;

import java.util.ArrayList;
import java.util.List;

public class DocumentDatabase {

    private List<Document> files;

    public DocumentDatabase(){
        this.files = new ArrayList<Document>();
    }

    public void addFile(Document document){
        files.add(document);
    }

    public List<Document> initDocumentDatabaseWithData(){
        Document document;
        List<Document> intermediatDocuments, anotherIntermediatDocuments;

        //documentul principal
        document = new Document("Pensie", null);

        //dubdocumente
        intermediatDocuments = new ArrayList<Document>();
        intermediatDocuments.add(new Document("Cerere tip pensie", null));
        anotherIntermediatDocuments = new ArrayList<Document>();

        Document anotherDocument = new Document("Acte vechime", null);
        anotherIntermediatDocuments.add(new Document("Carnet de munca", null));
        anotherIntermediatDocuments.add(new Document("Adeverinta vechime", null));
        anotherIntermediatDocuments.add(new Document("Adeverinta sporuri", null));
        anotherDocument.setIntermediateDocumentList(anotherIntermediatDocuments);
        intermediatDocuments.add(anotherDocument);

        anotherDocument = new Document("Acte stare civila", null);
        anotherIntermediatDocuments = new ArrayList<Document>();
        anotherIntermediatDocuments.add(new Document("Copie buletin", null));
        anotherIntermediatDocuments.add(new Document("Certificat de nastere", null));
        anotherIntermediatDocuments.add(new Document("Certificat de casatorie", null));
        anotherDocument.setIntermediateDocumentList(anotherIntermediatDocuments);
        intermediatDocuments.add(anotherDocument);

        intermediatDocuments.add(new Document("Diploma de absolvire a invatamantului universitar", null));
        intermediatDocuments.add(new Document("Dovada incetarii calitatii de asigurat", null));
        document.setIntermediateDocumentList(intermediatDocuments);

        addFile(document);

        document = new Document("Permis Auto", null);
        intermediatDocuments = new ArrayList<Document>();
        intermediatDocuments.add(new Document("Fisa medicala", null));
        intermediatDocuments.add(new Document("Fisa scolarizare", null));
        intermediatDocuments.add(new Document("Aviz psihologic", null));
        intermediatDocuments.add(new Document("Copie buletin", null));
        intermediatDocuments.add(new Document("Chitanta taxa auto", null));
        intermediatDocuments.add(new Document("Fisa evidenta ore conducere", null));
        document.setIntermediateDocumentList(intermediatDocuments);
        addFile(document);

        document = new Document("Inscriere facultate", null);
        intermediatDocuments = new ArrayList<Document>();
        intermediatDocuments.add(new Document("Diploma bacalaoreat", null));
        intermediatDocuments.add(new Document("Foaie matricola liceu", null));
        intermediatDocuments.add(new Document("Certificat de nastere", null));
        intermediatDocuments.add(new Document("Copie buletin", null));
        intermediatDocuments.add(new Document("Formular de inregistrare", null));
        intermediatDocuments.add(new Document("Fisa de inscriere", null));
        intermediatDocuments.add(new Document("Chitanta taxa de procesare", null));
        intermediatDocuments.add(new Document("Chitanta taxa de inscriere", null));
        document.setIntermediateDocumentList(intermediatDocuments);
        files.add(document);

        return files;
    }

    public String toString(){
        String text = "";
        for(Document doc : this.files){
            text = text + doc.getDocumentName() + "\n";
        }
        return text;
    }

    public Document getDocumentUsingIndex(int index){
        return files.get(index);
    }

    public String getAllSimpleDocuments(){
        String documentList = "";
        for (Document document : this.files){
            documentList = documentList + document.getDocumentIfSimple();
        }

        return documentList;
    }

    public int mainDocumentCounter(){
        return files.size();
    }

    public Document getDocumentById(int index){
        return files.get(index);
    }

    public Document cloneDocument(Document document){
        Document doc = new Document(document.getDocumentName(), document.getIntermediateDocumentList());
        return doc;
    }

}
