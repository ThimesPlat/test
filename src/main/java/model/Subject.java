package model;

/**
 * Created by ToMeg on 2017-04-21.
 */
public class Subject {



    private String namn;

    @Override
    public boolean equals(Object o) {
        if (o instanceof  Subject) {
            Subject sub= (Subject) o;
            return (sub.getNamn() == this.getNamn());
        } else return false;

    }
    @Override
    public int hashCode() {
        return namn.hashCode();
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public Subject(String namn) {
        this.setNamn(namn);
    }

    public String getNamn() {
        return namn;
    }



}
