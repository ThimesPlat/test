package model;

import junit.framework.Assert;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ToMeg on 2017-04-23.
 */
public class StudentTest {

    static Set<Subject> subjectSet;
    static Student  testStud;

    @BeforeClass
    public static void setUp() throws Exception {
        subjectSet= new HashSet<Subject>();
        subjectSet.add(new Subject("Math"));
        subjectSet.add( new Subject("Geography"));
        testStud= new Student(1,"testName", 2, subjectSet);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNamn() throws Exception {
        Assert.assertEquals("testName", testStud.getNamn());
    }

    @Test
    public void getGradeLvl() throws Exception {
        Assert.assertEquals(2,testStud.getGradeLvl());
    }

    @Test
    public void getSubjects() throws Exception {
        //testing number of subjects
        Assert.assertEquals(2,testStud.getSubjects().size());
        //checking subjects
        Assert.assertEquals(true,testStud.getSubjects().contains(new Subject("Math")));
        Assert.assertEquals(true,testStud.getSubjects().contains(new Subject("Geography")));
        //false case
        Assert.assertEquals(false,testStud.getSubjects().contains(new Subject("Mandarin Chinese")));
    }

    @Test
    public void hasSubjects() throws Exception {
        Set<Subject> testSet= new HashSet<Subject>();
        testSet.add(new Subject("Math"));
        testSet.add( new Subject("Geography"));
        //checking the true case
        Assert.assertEquals(true,testStud.hasSubjects(testSet));
        //false case
        testSet.add(new Subject("Mandarin Chinese"));
        Assert.assertEquals(false,testStud.hasSubjects(testSet));
        //checking single subject.
        testSet.clear();
        testSet.add(new Subject("Math"));
        Assert.assertEquals(true, testStud.hasSubjects(testSet));

    }

    @Test
    public void addSubject() throws Exception {
        testStud.addSubject(new Subject("Mandarin Chinese"));
        //checking size
        Assert.assertEquals(3,testStud.getSubjects().size());
        //checking true case
        Set<Subject> testSet= new HashSet<Subject>();
        testSet.add(new Subject("Mandarin Chinese"));
        Assert.assertEquals(true, testStud.hasSubjects(testSet));
    }
}