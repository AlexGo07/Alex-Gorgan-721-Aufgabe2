package model;


import java.util.ArrayList;
import java.util.List;

public class Charaktere implements HasID{
    private Integer CharaktereID;
    private String CharaktereName;
    private List<Produkte> ausgelieheneProduktee;

    public Charaktere(Integer CharaktereID, String CharaktereName) {
        this.CharaktereID = CharaktereID;
        this.CharaktereName = CharaktereName;
        this.ausgelieheneProduktee = new ArrayList<>();
        //this.ausgelieheneProduktee = ausgelieheneProduktee;
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
    public List<Produkte> getAusgelieheneProduktee() {
        return ausgelieheneProduktee;
    }
    public void addProdukte(Produkte Produkte) {
        ausgelieheneProduktee.add(Produkte);
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

