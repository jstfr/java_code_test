import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class University {
    private Collection<Student> students = new ArrayList<>();

    public University(){
        students.add(new Student("John", "Computer Science", false));
        students.add(new Student("Mary", "Computer Science", false));
        students.add(new Student("Steve", "Computer Science", true));
        students.add(new Student("Becky", "Business Studies", false));
        students.add(new Student("Liam", "Business Studies", true));
        students.add(new Student("Jane", "Physics", false));
    }

    public Collection<Student> getStudents() {
        return Collections.unmodifiableCollection(students);
    }
}
