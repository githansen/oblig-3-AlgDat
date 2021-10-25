package no.oslomet.cs.algdat.Oblig3;


import java.util.*;

public class SBinTre<T> {
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        // Som oppgaven foreslo, er store deler kopiert fra Programkode 5.2.3 a) med noen endringer
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");
        Node<T> p = rot, q = null;
        int cmp = 0;

        while (p != null)
        {
            q = p;
            cmp = comp.compare(verdi,p.verdi);
            p = cmp < 0 ? p.venstre : p.høyre;
        }



        p = new Node<>(verdi, q);

        if (q == null) rot = p;     //Dersom treet er tomt settes roten til p og vi er ferdig med innleggingen
        else if (cmp < 0){
            q.venstre = p; //Setter noden inn på riktig plass
            p.forelder = q; //Setter foreldre-pekeren, , endring fra programkode
        }
        else{
            p.forelder = q; //Setter foreldre-pekeren, , endring fra programkode
            q.høyre = p; //Setter noden inn på riktig plass
        }

        antall++; //Øker antall
        endringer++; //Øker endringer
        return true;
    }

    public boolean fjern(T verdi) {

     throw new UnsupportedOperationException("Ikke ferdig");
        }


    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke ferdig");
    }

    public int antall(T verdi) {

        int antall = 0;
        Node<T> curr = rot;
        while(curr != null){
            if(comp.compare(verdi, curr.verdi) == 0) antall++;

            curr = comp.compare(curr.verdi, verdi) > 0 ?  curr.venstre : curr.høyre;
        }

        return antall;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


    private static <T> Node<T> førstePostorden(Node<T> p) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void postorden(Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }
    public ArrayList<T> serialize() {throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
