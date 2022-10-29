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

    public boolean leggInn(T verdi) { // Kopiert fra programkode 5.2.3 a)
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");

        Node<T> p = rot, q = null;               // p starter i roten
        int cmp = 0;                             // hjelpevariabel

        while (p != null)       // fortsetter til p er ute av treet
        {
            q = p;                                 // q er forelder til p
            cmp = comp.compare(verdi,p.verdi);     // bruker komparatoren
            p = cmp < 0 ? p.venstre : p.høyre;     // flytter p
        }

        // p er nå null, dvs. ute av treet, q er den siste vi passerte

        p = new Node<T>(verdi, null, null, q); // oppretter en ny node med q som forelder

        if (q == null) rot = p;                  // p blir rotnode
        else if (cmp < 0) q.venstre = p;         // venstre barn til q
        else q.høyre = p;                        // høyre barn til q

        antall++;                                // én verdi mer i treet
        return true;                             // vellykket innlegging
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        Objects.requireNonNull(verdi, "Ulovlig med nullverdier!");
        Node<T> p = rot; // Setter node p = rotnode
        int antall_verdi = 0;
        while (p != null)
        {
            int cmp = comp.compare(verdi, p.verdi); // Sammenlikner så vi vet om vi skal gå til høyre eller venstre node
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else {
                p = p.høyre;
                antall_verdi++;
            }
        }
        return antall_verdi;
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        //Objects.requireNonNull(p.verdi, "Ulovlig med nullverdier!");
        //if (tom()) throw new NoSuchElementException("Treet er tomt!");
        //Node<T> p = rot;
        while (true)  // venstre -> høyre -> node (finner første node uten noen barn)
        {
            if (p.venstre != null) p = p.venstre;
            else if (p.høyre != null) p = p.høyre;
            else return p; // returnerer første postorden
        }
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        if (p.forelder == null) return null; // p er siste node i postorden (rotnode)'
        Node<T> f = p.forelder; // hjelpenode (forelder til p)
        if (f.høyre == p) return f; // Hvis p er høyre barn til sin forelder f, er forelderen f den neste
        // Hvis p er venstre barn til sin forelder f, gjelder:
        else if (f.høyre == null) return f; // Hvis p er enebarn (f.høyre er null), er forelderen f den neste.
        else return førstePostorden(f.høyre); // Hvis p ikke er enebarn (dvs. f.høyre er ikke null), så er den neste den noden som kommer først i postorden i subtreet med f.høyre som rot.
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


    public void postorden(Oppgave<? super T> oppgave) {
        if (tom()) return;   // tomt tre

        Node<T> p = førstePostorden(rot); // Finner første postorden fra rotnode

        while (p != null) { // kjører fram til vi går ut av treet
            oppgave.utførOppgave(p.verdi); // Utfører oppgave
            p = nestePostorden(p); // Finner neste postorden
        }

        //throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        if (!tom()) postordenRecursive(rot, oppgave); // sjekker først om treet er tomt
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        if (p == null) return;
        // Kopiert fra kompendium programkode 5.1.7 a), bare bytter om fra node -> venstre -> høyre til venste -> høyre -> node
        postordenRecursive(p.venstre,oppgave);  // til venstre barn
        postordenRecursive(p.høyre,oppgave);      // til høyre barn
        oppgave.utførOppgave(p.verdi);
        //throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
