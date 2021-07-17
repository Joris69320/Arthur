package fr.danon.controller;

import fr.danon.modele.Bo;
import fr.danon.modele.Live;
import fr.danon.modele.Son;
import fr.danon.modele.SonDAO;

import java.util.ArrayList;
import java.util.List;

public class SonController {

    private static List<Son> sonList = null;
    private SonDAO database;
    private static SonController controller;

    private SonController(){
        this.database = new SonDAO();
        sonList = new ArrayList<>();
    }

    public static SonController getInstance(){
        if(sonList == null){
            controller = new SonController();
            sonList = controller.database.getAllSon();
            return controller;
        }
        return controller;
    }

    public List<Son> getAllSon(){
        return sonList;
    }

    public void removeSon(int id){
        for(Son s : sonList){
            if(s.getId() == id){
                if(s instanceof Bo){
                    controller.database.removeBo(id);
                }
                else{
                    controller.database.removeLive(id);
                }
                sonList.remove(s);
            }
        }
    }

    public void addSon(String type, String groupeArtiste, String titre, String anneeSortie, String otherParms){
        int id = newId();
        if(type.equalsIgnoreCase("BO")){
            controller.database.addBo(id, type, groupeArtiste, titre, anneeSortie, otherParms);
            Bo b = new Bo(id, type, groupeArtiste, titre, anneeSortie, otherParms);
            sonList.add(b);
        }
        else{
            controller.database.addLive(id, type, groupeArtiste, titre, anneeSortie, otherParms);
            Live l = new Live(id, type, groupeArtiste, titre, anneeSortie, otherParms);
            sonList.add(l);
        }
    }

    public int newId(){
        if(sonList.size() < 1){
            return 1;
        }
        else{
            int max = 1;
            for(Son s : sonList){
                if(s.getId() > max){
                    max = s.getId();
                }
            }
            return max+1;
        }
    }
}
