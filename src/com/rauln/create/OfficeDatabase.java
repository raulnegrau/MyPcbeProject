package com.rauln.create;

import com.rauln.entity.Counter;
import com.rauln.entity.Document;
import com.rauln.entity.Office;

import java.util.ArrayList;
import java.util.List;

public class OfficeDatabase{
    private List<Office> officeList;

    public OfficeDatabase(){
        this.officeList = new ArrayList<Office>();
    }

    public void addOffice(Office office){
        officeList.add(office);
    }

    public List<Office> initOfficeDatabaseWithData(){
        //biroul medicului
        List<Counter> counter = new ArrayList<>();
        List<Document> document = new ArrayList<>();
        counter.add(new Counter(" (0.0) "));
        counter.add(new Counter(" (0.1) "));
        document.add(new Document("Fisa medicala", null));
        document.add(new Document("Aviz psihologic", null));
        Office office = new Office(" (0) ",counter, document);
        addOffice(office);

        // birou finante
        counter = new ArrayList<Counter>();
        document = new ArrayList<Document>();
        counter.add(new Counter(" (1.0) "));
        counter.add(new Counter(" (1.1) "));
        counter.add(new Counter(" (1.2) "));
        document.add(new Document("Cerere tip pensie", null));
        document.add(new Document("Carnet de munca", null));
        document.add(new Document("Adeverinta vechime", null));
        document.add(new Document("Adeverinta sporuri", null));
        document.add(new Document("Dovada incetarii calitatii de asigurat", null));
        office = new Office(" (1) ", counter, document);
        addOffice(office);

        //birou scoala
        counter = new ArrayList<Counter>();
        document = new ArrayList<Document>();
        counter.add(new Counter(" (2.0) "));
        counter.add(new Counter(" (2.1) "));
        counter.add(new Counter(" (2.2) "));
        counter.add(new Counter(" (2.3) "));
        counter.add(new Counter(" (2.4) "));
        counter.add(new Counter(" (2.5) "));
        document.add(new Document("Fisa scolarizare", null));
        document.add(new Document("Chitanta taxa auto", null));
        document.add(new Document("Fisa evidenta ore conducere", null));
        document.add(new Document("Diploma bacalaoreat", null));
        document.add(new Document("Foaie matricola liceu", null));
        document.add(new Document("Formular de inregistrare", null));
        document.add(new Document("Fisa de inscriere", null));
        document.add(new Document("Chitanta taxa de procesare", null));
        document.add(new Document("Chitanta taxa de inscriere", null));
        document.add(new Document("Diploma de absolvire a invatamantului universitar", null));
        office = new Office(" (2) ",counter, document);
        addOffice(office);

        //birou copii acte
        counter = new ArrayList<Counter>();
        document = new ArrayList<Document>();
        counter.add(new Counter(" (3.0) "));
        counter.add(new Counter(" (3.1) "));
        document.add(new Document("Copie buletin", null));
        document.add(new Document("Certificat de nastere", null));
        document.add(new Document("Certificat de casatorie", null));
        office = new Office(" (3) ",counter, document);
        addOffice(office);
        return officeList;
    }

    public String toString(){
        String officeStructure = "";
        for (Office office : this.officeList){
            officeStructure = officeStructure + "\nOffice " + office.getName() + " can releas these documents:";
            for (Document document : office.getDocumentList()){
                officeStructure = officeStructure + document.getDocumentIfSimple();
            }
            officeStructure = officeStructure + "\nand has these counters: ";
            for (Counter counter : office.getCounterList()){
                officeStructure = officeStructure + "\n" + counter.getName();
            }
        }
        return officeStructure;
    }

    public Office findRightOffice(String documentName){
        for(Office office : officeList){
            for(Document document : office.getDocumentList()){
                if(document.getDocumentName().equals(documentName))
                    return office;
            }
        }
        return null;
    }

    public Office lookForTheRightOfficeToGo(String documentName){
        System.out.println(" Looking for the right office for " + documentName);
        for(Office office : officeList){
            System.out.println("Looking in office" + office.getName());
            for(Document document : office.getDocumentList()){
                if(document.getDocumentName().equals(documentName)){
                    System.out.println(" Office " + office.getName() + " will help with " + documentName);
                    return office;
                }
            }
        }
        return null;
    }
}
