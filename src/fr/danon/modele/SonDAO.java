package fr.danon.modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SonDAO {

    private String url, user, password;

    public SonDAO(){
        url = "jdbc:mysql://localhost/isitech";
        user = "root";
        password = "";
    }

    public List<Son> getAllSon(){

        List<Son> sons = new ArrayList<>();

        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement sql = con.createStatement();
            ResultSet line = sql.executeQuery("SELECT b.id AS id, type, groupeArtiste, titre, anneeSortie, titreFilm FROM bo b " +
                    "INNER JOIN son s ON s.id = b.id;");

            while(line.next()){
                int id = line.getInt(1);
                String type = line.getString(2);
                String groupeArtiste = line.getString(3);
                String titre = line.getString(4);
                String anneeSortie = line.getString(5);
                String titreFilm = line.getString(6);
                Bo b = new Bo(id, type, groupeArtiste, anneeSortie, titre, titreFilm);
                sons.add(b);
            }

            line = sql.executeQuery("SELECT l.id AS id, type, groupeArtiste, titre, anneeSortie, lieuConcert FROM live l " +
                    "INNER JOIN son s ON s.id = l.id;");

            while (line.next()){
                int id = line.getInt(1);
                String type = line.getString(2);
                String groupeArtiste = line.getString(3);
                String titre = line.getString(4);
                String anneeSortie = line.getString(5);
                String lieuConcert = line.getString(6);
                Live l = new Live(id, type, groupeArtiste, anneeSortie, titre, lieuConcert);
                sons.add(l);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return sons;
    }

    public void removeBo(int id){
        try{
            Connection con = DriverManager.getConnection(url,user,password);
            Statement sql = con.createStatement();
            sql.execute("DELETE FROM bo WHERE id = "+id+";");
            sql.execute("DELETE FROM son WHERE id = "+id+";");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeLive(int id){
        try{
            Connection con = DriverManager.getConnection(url,user,password);
            Statement sql = con.createStatement();
            sql.execute("DELETE FROM live WHERE id = "+id+";");
            sql.execute("DELETE FROM son WHERE id = "+id+";");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addBo(int id, String type, String groupeArtiste, String titre, String anneeSortie, String titreFilm){
        try{
            Connection con = DriverManager.getConnection(url,user,password);
            Statement sql = con.createStatement();
            sql.execute("INSERT INTO son (id,type,groupeArtiste,titre,anneSortie) VALUES ("+id+",'"+type+"','"+groupeArtiste+"','"+titre+"','"+anneeSortie+"')");
            sql.execute("INSERT INTO bo (id,titreFilm) VALUES ("+id+",'"+titreFilm+"')");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void addLive(int id, String type, String groupeArtiste, String titre, String anneeSortie, String lieuConcert){
        try{
            Connection con = DriverManager.getConnection(url,user,password);
            Statement sql = con.createStatement();
            sql.execute("INSERT INTO son (id,type,groupeArtiste,titre,anneeSortie) VALUES ("+id+",'"+type+"','"+groupeArtiste+"','"+titre+"','"+anneeSortie+"')");
            sql.execute("INSERT INTO live (id,lieuConcert) VALUES ("+id+",'"+lieuConcert+"')");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
