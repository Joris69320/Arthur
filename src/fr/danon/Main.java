package fr.danon;

import fr.danon.controller.SonController;
import fr.danon.modele.Bo;
import fr.danon.modele.Live;
import fr.danon.modele.Son;

import java.util.Scanner;

public class Main {

    static SonController controller = SonController.getInstance();

    public static void main(String[] args) {

        String word = "";
        Scanner scan = new Scanner(System.in);

        do{
            Entry(word);
            word = scan.next();
        }while (!word.equals("3"));

        System.out.println("Fermeture du programme");
    }

    public static void Entry(String entry){
        Scanner scanner = new Scanner(System.in);
        if(entry.equalsIgnoreCase("0")){
            String type, groupeArtiste, titre, anneeSortie, otherParams;

            System.out.print("Type : ");
            type = scanner.next();

            System.out.print("\nGroupe ou Artiste : ");
            groupeArtiste = scanner.next();

            System.out.print("\nTitre : ");
            titre = scanner.next();

            System.out.print("\nAnnée de Sortie : ");
            anneeSortie = scanner.next();

            System.out.print("\nFilm ou lieu de concert : ");
            otherParams = scanner.next();

            addSon(type, groupeArtiste, titre, anneeSortie, otherParams);
        }
        else if(entry.equalsIgnoreCase("1")){
            for(Son s : controller.getAllSon()){
                System.out.println(s.getId()+" "+s.getTitre());
            }
            try{
                int id = Integer.parseInt(scanner.next());
                removeSon(id);
            }
            catch (Exception e){

            }
        }
        else if(entry.equalsIgnoreCase("2")){
            listSon();
        }
        else if(entry.equalsIgnoreCase("help")){
            System.out.println("0 - Ajouter un son");
            System.out.println("1 - Supprimer un son");
            System.out.println("2 - Voir la liste des sons");
            System.out.println("3 - Quitter le programme");
        }
        else{
            if(!entry.equalsIgnoreCase("")){
                System.out.println("Commande non valide!");
            }
        }
    }

    public static void addSon(String type, String groupeArtiste, String titre, String anneeSortie, String otherParms){
        controller.addSon(type, groupeArtiste, titre, anneeSortie, otherParms);
        System.out.println("Son ajouté avec succès!");
    }

    public static void removeSon(int id){
        controller.removeSon(id);
        System.out.println("Son supprimé avec succès!");
    }

    public static void listSon(){
        for (Son s : controller.getAllSon()){
            if(s instanceof Bo){
                Bo b = (Bo) s;
                System.out.println(b.getType()+" "+b.getGroupeArtiste()+" "+b.getTitre()+" "+ b.getAnneeSortie()+" "+b.getTitreFilm());
            }
            else{
                Live l = (Live) s;
                System.out.println(l.getType()+" "+l.getGroupeArtiste()+" "+l.getTitre()+" "+ l.getAnneeSortie()+" "+l.getLieuConcert());
            }
        }
    }
}
