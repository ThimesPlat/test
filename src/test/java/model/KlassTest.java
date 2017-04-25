package model;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ToMeg on 2017-04-25.
 */
public class KlassTest {

    Set<Student> studentSet;
    Klass aKlass;

    @Before
    public void setUp(){
        studentSet = new HashSet<Student>();
        studentSet.add(new Student(1, "Thymios", 3));
        studentSet.add(new Student(2,"Fredrik", 3));
        studentSet.add(new Student(3,"Victor",3));
        aKlass = new Klass("3A", studentSet);
    }
    @Test
    public void getNamn() throws Exception {
        Assert.assertEquals("3A", aKlass.getNamn());
    }

    @Test
    public void getStudents() throws Exception {
        Set<Student> testStuds= aKlass.getStudents();
        Assert.assertTrue((testStuds.contains(new Student(1, "Thymios",3))) &&
                (testStuds.contains(new Student(2, "Fredrik",3))) &&
                (testStuds.contains(new Student(3, "Victor",3))));
    }

}