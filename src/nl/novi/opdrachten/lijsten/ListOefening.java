package nl.novi.opdrachten.lijsten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOefening {

    public static void main(String[] uitlegList) {

        //We hebben een list die de namen van voetbalclubs bevat
        List<String> clubNames = new ArrayList<>();
        //Die vullen we alvast voor de opdracht
        clubNames.add("AAAA Club");
        clubNames.add("Ajax");
        clubNames.add("PSV");
        clubNames.add("Feyenoord");
        clubNames.add("Fc Utrecht");
        clubNames.add("Fc Groningen");
        clubNames.add("FC Twente");

        // Vraag -1: Maak een methode die al taak heeft om de list per regel uit te printen.
        printClubNames(clubNames);

        // Vraag 0: Maak een methode die als taak heeft om de list uit te printen: positie + inhoud.
        // Bovenstaande list zou dan dit zijn:
        // 0 - Ajax
        // 1 - PSv
        // etc...
        printClubNamesIdx(clubNames);

        // Vraag 1: Maak een methode die checkt of een club al in de lijst zit en voeg deze anders toe.
        addClub("Ajax", clubNames);

        // Vraag 2: Maak een methode die de positie van de club in de lijst teruggeeft.
        clubIDX("Sparta", clubNames);
        System.out.println("\n");

        // Vraag 3: Maak een methode die de lijst alfabetisch sorteert. Wanneer Ajax niet op positie 1 staat, moeten de
        // clubs die voor Ajax staan verwijderd worden.
        // We voegen nog wat clubs toe om de code te kunnen testen.
        clubNames.add("AA Aachen");
        clubNames.add("AFC Amsterdam");
        clubNames.add("AFC");

//        printClubNamesIdx(clubNames);
//        orderAlphabeticallyAjaxFirst(clubNames);
//        printClubNamesIdx(clubNames);


        // Vraag 4: Kun je hetzelfde doen als hierboven, maar PSV moet dan laatste zijn.
        clubNames.add("Zlotty FC");
        clubNames.add("SC Eindhoven");

        printClubNamesIdx(clubNames);
        orderAlphabeticallyPSVLast(clubNames);
        printClubNamesIdx(clubNames);


    }
//    1
    public static void printClubNames(List<String> list){
        for(String s : list){
            System.out.println(s);
        }
    }

//    0
    public static void printClubNamesIdx(List<String> list){
        for(int i = 0 ; i < list.size(); i++){
            System.out.println(i + " - " + list.get(i));
        }
    }

//    1
    public static void addClub(String newClub, List<String> list){
        boolean alreadyInList = false;
        for (String s : list){
            if(s.equals(newClub)){
                System.out.println("That club is already in the list.");
                alreadyInList = true;
                break;
            }
        }

        if(!alreadyInList){
            System.out.println("Adding the club");
            list.add(newClub);
        }
    }

//    2
    public static void clubIDX(String clubname, List<String> list){
        boolean isInList = false;
        for (int i = 0; i < list.size(); i++){
            if(clubname.equals(list.get(i))){
                System.out.println(clubname + " is at index " + i);
                isInList = true;
                break;
            }
        }

        if(!isInList){
            System.out.println("Team is not in this list");
        }
    }

//    3
    public static void orderAlphabeticallyAjaxFirst(List<String> list){
        Collections.sort(list);

//        Remove clubs when ajax is not on index 0
        while(!list.get(0).equals("Ajax")){
            list.remove(0);
        }

    }

//    4
    public static void orderAlphabeticallyPSVLast(List<String> list){
        Collections.sort(list);
//        int listEndIndex = list.size() - 1;

        while (!list.get(list.size() - 1).equals("PSV")){
            list.remove(list.size() - 1);
        }

    }

}
