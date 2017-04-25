import model.Group;
import model.Klass;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ToMeg on 2017-04-21.
 */
public class School {

    public School(Set<Group> groups, ArrayList<Klass> klasses) {
        this.groups = groups;
        this.klasses = klasses;
        theUnplacedOnes= new HashMap<Set<Subject>, Student>();
    }

    private Set<Group> groups;
    private ArrayList<Klass> klasses;
    /*Unplaced Students. To provide further flexibility students are unplaced for individual groups/subjects.
    In this way    a student will be unplaced only in the groups he/she cannot join because of reasons*/
    private Map<Set<Subject>, Student> theUnplacedOnes;

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Klass> getKlasses() {
        return klasses;
    }

    public void setKlasses(ArrayList<Klass> klasses) {
        this.klasses = klasses;
    }

    public Map<Set<Subject>, Student> getTheUnplacedOnes() {
        return theUnplacedOnes;
    }

    /*This function handles the logic of sorting predefined klasses of students in predefined groups
        with a specific grade level and a specific set of subjects.
        This is based on the assumption that a subject has also many grade levels. (e.g. Math 1 is not the same as Math 9)
        Time Complexity: O(N**3)
        Space Complexity O(N)
        * */
    public void populateGroups(){
        System.out.println("---- Populating Groups ----");
            for (Klass c :
                    klasses) {
                for (Student s :
                        c.getStudents()) {
                    boolean added=false;
                    Set<Subject> failedSubs;
                    for (Group g :
                            groups) {
                        if (s.getGradeLvl() == g.getGradeLvl()) {
                            if (s.hasSubjects(g.getSubjects())){
                                added= g.addStudent(s);
                                if (!added) {
                                    failedSubs=g.getSubjects();
                                    theUnplacedOnes.put(failedSubs, s);
                                }
                            }
                        }
                    }
                }
            }
        //Checking for groups that do not fulfill minimum requirements. If any is found, students are unplaced.
        for (Group g :
                groups) {
            if (g.getNumberOfStudents() < g.getMin()) {
                for (Student s :
                        g.getStudents()) {
                    theUnplacedOnes.put(g.getSubjects(), s);
                }
            }
            }
        System.out.println("\t Done....! \n \t Unplaced Students:");
        System.out.println(theUnplacedOnes.toString());
    }
}
