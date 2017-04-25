package model;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by ToMeg on 2017-04-21.
 */
public class Group {

    private int id;
    private Set<Student> students;
    private Set<Subject> subjects;
    private int gradeLvl;
    private int max;
    private int min;


    public Group(int id, Set<Subject> subjects, int gradeLvl, int max, int min) {
        this.id = id;
        this.subjects = subjects;
        this.gradeLvl = gradeLvl;
        this.max = max;
        this.min = min;
        students= new HashSet<Student>();
    }

    //for testing purposes only
    public Group(int id, Set<Student> students, Set<Subject> subjects, int gradeLvl, int max, int min) {
        this.id = id;
        this.students = students;
        this.subjects = subjects;
        this.gradeLvl = gradeLvl;
        this.max = max;
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setGradeLvl(int gradeLvl) {
        this.gradeLvl = gradeLvl;
    }

    public int getGradeLvl() {
        return gradeLvl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getNumberOfStudents(){
        return students.size();
    }

    public boolean addStudent (Student s) {
        if (students.size() < max) {
            return students.add(s);
        }else return false;
    }

    public Set<Student> getStudents() {
        return students;
    }

    /* public boolean hasMultipleSubjects(){
        if (subjects.size()>1) return true;
        else return false;
    }*/


}
