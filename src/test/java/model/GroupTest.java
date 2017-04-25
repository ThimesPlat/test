package model;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ToMeg on 2017-04-25.
 */
public class GroupTest {

    Group testGroup;
    Set<Student> studentSet;
    Set<Subject> subjectSet;


    @Before
    public void setUp() {
        subjectSet = new HashSet<Subject>();
        studentSet = new HashSet<Student>();
        subjectSet.add(new Subject("Computer Science"));
        subjectSet.add(new Subject("PowerLifting"));
        studentSet.add(new Student(1, "Thymios", 3,subjectSet));
        subjectSet.remove(new Subject("PowerLifting"));
        subjectSet.add(new Subject("Math"));
        subjectSet.add(new Subject("Ancient Greek"));
        studentSet.add(new Student(2,"Fredrik", 3,subjectSet));
        subjectSet.clear();
        subjectSet.add(new Subject("Computer Science"));
        studentSet.add(new Student(3,"Victor",3,subjectSet));
        testGroup= new Group(1,studentSet, subjectSet, 3,10,3);
    }

    @Test
    public void getSubjects() throws Exception {
        Set<Subject> testSubs= testGroup.getSubjects();
        Assert.assertEquals(1,testSubs.size());
        Assert.assertTrue(testSubs.contains(new Subject("Computer Science")));
    }

    @Test
    public void getNumberOfStudents() throws Exception {
        Assert.assertEquals(3,testGroup.getNumberOfStudents());
    }

    @Test
    public void addStudent() throws Exception {
        //testing max value. Group has already 3 students and the max is 10.
        for(int i=0; i<7; i++) { //filling up group;
            Assert.assertTrue (testGroup.addStudent(new Student(i+4,"Student"+(i+4), 3) ) ); //addStudent must return true since there is enough space
            Assert.assertEquals(i+4, testGroup.getNumberOfStudents());
        }
        //testing to add in a full group
        Assert.assertFalse(testGroup.addStudent(new Student(11,"TheLateGuy",3)));
    }
    @Test
    public void getStudents() throws Exception {
        Set<Student> testStuds= testGroup.getStudents();

        Assert.assertTrue((testStuds.contains(new Student(1, "Thymios",3))) &&
                (testStuds.contains(new Student(2, "Fredrik",3))) &&
                (testStuds.contains(new Student(3, "Victor",3))));
    }

}