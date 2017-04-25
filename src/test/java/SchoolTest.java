import junit.framework.Assert;
import model.Group;
import model.Klass;
import model.Student;
import model.Subject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ToMeg on 2017-04-25.
 */
public class SchoolTest {

     Set<Group> groups;
     ArrayList<Klass> classes;
     School school;

    /**
     * Populates the needed classes with data to test the School class which implements all business logic
     */
    @Before
    public  void setUp() {
        groups = new HashSet<Group>();
        classes = new ArrayList<Klass>();
        int countIds = 1;
        int studIds = 1;
        Set<Subject> mandatorySet = new HashSet<Subject>();
        mandatorySet.add(new Subject("Math"));
        mandatorySet.add(new Subject("Geography"));
        mandatorySet.add(new Subject("Literature"));
        //adding some students with mandatory courses and populating classes
        Set<Student> students = new HashSet<Student>();
        for (int i = 1; i <= 5; i++) {
            students.clear();
            for (int j = 1; j <= 6; j++) {
                students.add(new Student(studIds, "Student" + countIds, i, mandatorySet));
                studIds++;
            }
            classes.add(new Klass("Class " + i, students));
        }
        //Creating Mandatory Groups
        for (int i = 1; i <= 5; i++) {
            groups.add(new Group(countIds, mandatorySet, i, 10, 3));
            countIds++;
        }
        //creating optional courses groups
        Set<Subject> optionalSet = new HashSet<Subject>();
        optionalSet.add(new Subject("English"));
        for (int i = 1; i <= 5; i++) {
            groups.add(new Group(countIds, optionalSet, i, 10, 3));
            countIds++;
        }
        optionalSet.clear();
        optionalSet.add(new Subject("Mandarin Chinese"));
        for (int i = 1; i <= 5; i++) {
            groups.add(new Group(countIds, optionalSet, i, 10, 3));
            countIds++;
        }
        //adding some English students in even classes
        mandatorySet.add(new Subject("English"));
        for (int i = 1; i <= 5; i++) {
            students.clear();
            if (i % 2 == 0) {
                for (int j = 0; j < 4; j++) {
                    students.add(new Student(studIds, "Student" + studIds, i, mandatorySet));
                    studIds++;
                }
            }
            classes.add(new Klass("Eng-" + i, students));
        }
        //adding not enough Chinese students  in odd classes
        optionalSet.add(new Subject("Math"));
        optionalSet.add(new Subject("Geography"));
        optionalSet.add(new Subject("Literature"));
        for (int i = 1; i <= 5; i++) {
            students.clear();
            if (i % 2 == 1) {
                for (int j = 0; j < 2; j++) {
                    students.add(new Student(studIds, "Student" + studIds, i, optionalSet));
                    studIds++;
                }
            }
            classes.add(new Klass("Kin-" + i, students));
        }
        //adding one student too much in an even class
        students.clear();
        students.add(new Student(studIds, "oneTooMany", 2, mandatorySet));
        classes.add(new Klass("No17", students));
        school = new School(groups, classes);
    }


    @Test
    public void populateGroups() throws Exception {
        school.populateGroups();
        //checking group population
        for (Group g :
                school.getGroups()) {
            if (g.getGradeLvl() % 2 == 0){
                Assert.assertEquals(10,g.getNumberOfStudents());
            }else Assert.assertEquals(8,g.getNumberOfStudents());
            Set<Student> students= g.getStudents();
            for (Student s :
                    students) {
                Assert.assertTrue(s.hasSubjects(g.getSubjects()));
                //checking if students are allocated to the correct grade levels
                Assert.assertEquals(s.getGradeLvl(),g.getGradeLvl());
            }
        }
        //Checking Unplaced Student number;
        Map<Set<Subject>, Student> unplacedOnes= school.getTheUnplacedOnes();
        Assert.assertEquals(7, unplacedOnes.size());
        for (Set<Subject> key :
                unplacedOnes.keySet()) {
            Assert.assertTrue(key.contains(new Subject("Mandarin Chinese"))
                    || key.contains(new Subject("Math")));
        }
    }

}