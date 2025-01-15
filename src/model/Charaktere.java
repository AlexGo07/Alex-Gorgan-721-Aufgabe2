package model;


import java.util.ArrayList;
import java.util.List;

public class Charaktere implements HasID{
    private Integer CharaktereID;
    private String CharaktereName;
    private String Herkunftsort;
    private List<Produkte> ausgelieheneProduktee;

    public Charaktere(Integer CharaktereID, String CharaktereName,String Herkunftsort) {
        this.CharaktereID = CharaktereID;
        this.CharaktereName = CharaktereName;
        this.Herkunftsort = Herkunftsort;
        this.ausgelieheneProduktee = new ArrayList<>();
    }
    public Integer getCharaktereID() {
        return CharaktereID;
    }
    public void setCharaktereID(Integer CharaktereID) {
        this.CharaktereID = CharaktereID;
    }
    public String getCharaktereName() {
        return CharaktereName;
    }
    public void setCharaktereName(String CharaktereName) {
        this.CharaktereName = CharaktereName;
    }
    public List<Produkte> getAusgelieheneProdukte() {
        return ausgelieheneProduktee;
    }
    public void addProdukte(Produkte Produkte) {
        ausgelieheneProduktee.add(Produkte);
    }
    public String getHerkunftsort() {
         return Herkunftsort;
    }
    public void setHerkunftsort() {
        this.Herkunftsort = Herkunftsort;
    }

    @Override
    public String toString() {
        return "Charaktere{" +
                "CharaktereID=" + CharaktereID +
                ", CharaktereName='" + CharaktereName + '\'' +
                ", ausgelieheneProduktee=" + ausgelieheneProduktee +
                '}';
    }

    @Override
    public Integer getId() {
        return CharaktereID;
    }
}

