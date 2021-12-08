package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.List;

public class GeheimeCode {

    public static void main(String[] secret) {

        List<String> laResistanceMembers = new ArrayList<>();

        laResistanceMembers = addMembers(laResistanceMembers, "Arie");
        laResistanceMembers = addMembers(laResistanceMembers, "Sjaak");
        laResistanceMembers = addMembers(laResistanceMembers, "Henrie");
        laResistanceMembers = addMembers(laResistanceMembers, "Piet");
        laResistanceMembers = addMembers(laResistanceMembers, "LeDroitCestMoi");

        System.out.println("\tOriginal List:");
        printNames(laResistanceMembers);
        System.out.println("\n");

        /*
        Opdracht 1: Hierboven zijn via de methode addMembers, leden aan de lijst toegevoegd. Pas de Methode zo aan dat
         er alleen unieke namen in voor mogen komen.
         */

        /*
        Opdracht 2: La Resistance wil niet dat de lijst met namen zo in handen komt te vallen van de bezetter. Versleutel
        Maak een methode die de lijst op de volgende manier versleuteld:
        a) Verander elke letter naar het nummer in het alfabet. Voeg na elke veranderde letter een - toe
        (behalve de laatste). Dus a wordt 1, b wordt 2 et cetera.
        Wanneer een letter een hoofdletter is, moet je beginnen met tellen bij 100. Dus A wordt 101, B wordt 102.
        Voorbeeld: Alex wordt versleuteld naar: 101-12-5-24
        b) Als de positie in de lijst een even getal is, dan moet de cijfercombinatie omgedraaid worden.
         */
        System.out.println("\tEncoded List:");
        laResistanceMembers = encodeNameList(laResistanceMembers);
        printNames(laResistanceMembers);
        System.out.println("\n");


        /*
        Opdracht 3:
        Schrijf een methode die de versleutelde lijst kan omzetten naar de ontsleutelde lijst.
         */

        System.out.println("\tDecoded List:");
        laResistanceMembers = decodeNameList(laResistanceMembers);
        printNames(laResistanceMembers);

    }

    //    OPDRACHT 1
    private static List<String> addMembers(List<String> members, String name) {
        if (!members.contains(name)) {
            members.add(name);
        }
        return members;
    }

    private static void printNames(List<String> members) {
        for (String s : members) {
            System.out.println(s);
        }
    }

    //    OPDRACHT 2
//    ENCODING
    private static List<String> encodeNameList(List<String> list) {
        List<String> encodedList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String encodedName = encodeName(list.get(i));

            // reverse encoded name if index in list is even
            if (i % 2 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(encodedName);
                sb.reverse();
                encodedList.add(sb.toString());
            } else {
                encodedList.add(encodedName);
            }
        }

        return encodedList;

    }

    private static String encodeName(String name) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encodedName = "";
        for (int i = 0; i < name.length(); i++) {

            for (int j = 0; j < alphabet.length(); j++) {
                if (name.substring(i, i + 1).toLowerCase().equals(alphabet.substring(j, j + 1))) {

                    // Check if character was uppercase or lowercase;
                    if (!Character.isUpperCase(name.charAt(i))) {
                        encodedName += Integer.toString(j);
                        break;
                    } else {
                        encodedName += Integer.toString(j + 100);
                        break;
                    }
                }
            }

            if (i != name.length() - 1) {
                encodedName += "-";
            }

        }

        return encodedName;
    }

    //    OPDRACHT 3
//    DECODING
    private static List<String> decodeNameList(List<String> list) {
        List<String> decodedList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String decodedName;
            if (i % 2 == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(list.get(i));
                sb.reverse();
                decodedName = decodeName(sb.toString());
            } else {
                decodedName = decodeName(list.get(i));
            }

            decodedList.add(decodedName);
        }

        return decodedList;
    }

    private static String decodeName(String encodedName) {
        String decodedName = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String subString = encodedName;

        while (!subString.isEmpty()) {
//            Get single lettercode by makin a substring (up until "-")
            String encodedLetter;
            int hyphenIDX = 0;
            if (subString.contains("-")) {
                hyphenIDX = subString.indexOf("-");
                encodedLetter = subString.substring(0, hyphenIDX);
            } else {
                encodedLetter = subString.substring(0);
            }

            int letterCode = Integer.parseInt(encodedLetter);

//            Convert lettercode to letter and add to decodedName (check for Capital letters)
            if (letterCode < 100) {
                decodedName += alphabet.substring(letterCode, letterCode + 1);
            } else {
                decodedName += alphabet.substring(letterCode - 100, letterCode - 99).toUpperCase();
            }

            subString = subString.substring(hyphenIDX + 1);
        }

        return decodedName;

    }
}
