package nl.novi.opdrachten.whilelussen;

public class EvenTeller {
    public static void main(String[] even) {
        /*
        Maak een while-lus.
        Deze while-lus moet net zo lang lopen tot en met de teller op 10 staat.
        Print alleen de even getallen uit!
         */
        int teller = 0;
        do {
            if(teller % 2 == 0){
                System.out.println(teller);
            }

            teller++;
        }while(teller != 11);
    }
}
