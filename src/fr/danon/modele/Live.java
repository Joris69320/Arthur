package fr.danon.modele;

public class Live extends Son{

    private String lieuConcert;

    public Live(int id, String type, String groupeArtiste, String anneeSortie, String titre, String lieuConcert){
        super(id, type, groupeArtiste, anneeSortie, titre);
        this.lieuConcert = lieuConcert;
    }

    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public String getType() {
        return super.type;
    }

    @Override
    public String getGroupeArtiste() {
        return super.groupeArtiste;
    }

    @Override
    public String getAnneeSortie() {
        return super.anneeSortie;
    }

    @Override
    public String getTitre() {
        return super.titre;
    }

    public String getLieuConcert(){
        return this.lieuConcert;
    }
}
