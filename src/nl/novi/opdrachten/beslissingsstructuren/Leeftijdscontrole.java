package nl.novi.opdrachten.beslissingsstructuren;

import java.util.Scanner;

public class Leeftijdscontrole {
    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.println("Wat is uw leeftijd?");
        int givenAge = userInputScanner.nextInt();

        /*
        In Nederland mag je alcoholische dranken kopen vanaf je 18e. Je moet echter tot je 25ste een ID kunnen tonen.
        Hierboven heeft de gebruiker al zijn leeftijd ingevoerd. Het is aan jou om de volgende berichten af te drukken:
        Wanneer de gebruiker onder 18 is: Jij mag geen alcohol kopen.
        Wanneer de gebruiker 25 jaar of ouder is: Jij mag zonder restricties alcohol kopen.
        Wanneer de gebruiker tussen 18 en 25 is: Jij mag alcohol kopen, maar jij moet je ID tonen.

        Maak de beslissingsstructuur (if/else if/else) hieronder.
         */

        if(givenAge < 18){
            System.out.println("Jij mag geen alcohol kopen");
        } else if(givenAge > 25){
            System.out.println("Jij mag zonder restricties alcohol kopen");
        } else{
            System.out.println("Jij mag alchol kopen maar je moet je ID laten zien.");
        }
    }
}
