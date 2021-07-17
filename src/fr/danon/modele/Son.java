package fr.danon.modele;

public abstract class Son {

    protected int id;
    protected String type;
    protected String groupeArtiste;
    protected String anneeSortie;
    protected String titre;

    public Son(int id, String type, String groupeArtiste, String titre, String anneeSortie){
        this.id = id;
        this.type = type;
        this.groupeArtiste = groupeArtiste;
        this.anneeSortie = anneeSortie;
        this.titre = titre;
    }

    public abstract int getId();
    public abstract String getType();
    public abstract String getGroupeArtiste();
    public abstract String getAnneeSortie();
    public abstract String getTitre();
}
