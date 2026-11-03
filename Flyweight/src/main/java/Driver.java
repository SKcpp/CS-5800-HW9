public class Driver {
    public static void main(String[] args) throws Exception 
    {
        Document doc = new Document();
        doc.addText("Hello",  "Arial",   12, "Red");
        doc.addText("World",  "Calibri", 14, "Blue");
        doc.addText("CS",     "Verdana", 16, "Black");
        doc.addText("5800",   "Arial",   16, "Blue");

        System.out.println("Original text : " + doc.getText());
        System.out.println("Characters    : " + doc.length());
        System.out.println("Flyweights    : " + CharacterPropertiesFactory.count());

        doc.save("document.txt");
        System.out.println("\nSaved to document.txt");

        Document loaded = Document.load("document.txt");
        System.out.println("Loaded text   : " + loaded.getText());
        System.out.println("Flyweights after load (should be unchanged): " + CharacterPropertiesFactory.count());
        System.out.println("\nLoaded document details:");
        loaded.print();

        loaded.editCharacter(0, 'J', "Arial", 12, "Red");
        System.out.println("\nAfter edit    : " + loaded.getText());
        System.out.println("Flyweights    : " + CharacterPropertiesFactory.count());
    }
}