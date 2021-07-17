package fr.danon.modele;

public class Bo extends Son{

    private String titreFilm;

    public Bo(int id, String type, String groupeArtiste, String anneeSortie, String titre, String titreFilm){
        super(id, type, groupeArtiste, anneeSortie, titre);
        this.titreFilm = titreFilm;
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

    public String getTitreFilm(){
        return this.titreFilm;
    }
}
