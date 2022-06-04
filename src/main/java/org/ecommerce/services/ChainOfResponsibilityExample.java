package org.ecommerce.services;
import java.util.*;
/** Classe de gestion de journalisation abstraite. */
abstract class Logger {
    /** L'élément suivant dans la chaîne de responsabilité. */
    protected Logger next;
    protected Logger() {
        this.next = null;
    }
    public Logger setNext( Logger l) { next = l; return l; }
    public void message( String msg) {
        writeMessage( msg ); /** Traitement  */
        if ( next != null ) {
            System.out.println("has Next");
            next.message(msg);
        }
    }
    abstract protected void writeMessage( String msg );
}
/** Journalisation sur la sortie standard. */
class StdoutLogger extends Logger {
    public StdoutLogger() { super(); }
    protected void writeMessage( String msg ) {
        System.out.println( "Writing to stdout: " + msg ); }
}
/** Journalisation par courriel. */
class EmailLogger extends Logger {
    public EmailLogger() { super(); }
    protected void writeMessage( String msg ) { System.out.println( "Sending via email: " + msg ); }
}
/** Journalisation sur l'erreur standard. */
class StderrLogger extends Logger {
    public StderrLogger() { super(); }
    protected void writeMessage( String msg ) {
        System.err.println( "Sending to stderr: " + msg );
    }
}
public class ChainOfResponsibilityExample {
    public static void main( String[] args ) throws InterruptedException {
/*// Construire la chaîne de responsabilité
// StdoutLogger -> EmailLogger -> StderrLogger
        Logger l,l1;
        l = new StdoutLogger();
        l1 = l.setNext(new EmailLogger());
        l1.setNext(new StderrLogger());
// Traité par StdoutLogger
        l.message( "Entering function y.");
// Traité par StdoutLogger et EmailLogger
        l.message( "Step1 completed.");
// Traité par les trois loggers
        l.message( "An error has occurred.");*/
   int tab[] = {2,5,1};
   System.out.println(Arrays.binarySearch(tab,5));
    } }

