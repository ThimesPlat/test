package model;

import java.util.Set;

/**
 * Created by ToMeg on 2017-04-21.
 */
public class Klass {
    private String namn;
    private Set<Student> students;

    public Klass(String namn, Set<Student> students) {
        this.namn = namn;
        this.students = students;
    }

    public String getNamn() {
        return namn;
    }

    public Set<Student> getStudents() {
        return students;
    }

}
