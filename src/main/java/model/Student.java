package model;

import java.util.Set;

/**
 * Created by ToMeg on 2017-04-21.
 */


public class Student {

    private int id;
    private String namn;
    private int gradeLvl;
    private Set<Subject> subjects;

    public Student(int id, String namn, int gradeLvl, Set<Subject> subjects) {
        this.id = id;
        this.namn = namn;
        this.gradeLvl = gradeLvl;
        this.subjects = subjects;
    }

    public Student(int id, String namn, int gradeLvl) {
        this.id = id;
        this.namn = namn;
        this.gradeLvl = gradeLvl;
    }

    public int getId() {
        return id;
    }

    public String getNamn() {
        return namn;
    }

    public int getGradeLvl() {
        return gradeLvl;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public boolean hasSubjects(Set<Subject> subjectSet) {
        boolean result= true;
        for (Subject s :
                subjectSet) {
            if (!subjects.contains(s)) result=false;
        }
        return result;
    }

    public boolean addSubject(Subject sub) {
        return subjects.add(sub);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student stud= (Student)o;
            return ((stud.getNamn() == this.getNamn()) && (stud.getId() == this.getId()));
        }else return false;
    }

    @Override
    public int hashCode() {
        return (namn.hashCode() + id);
    }

}
