import java.util.*;
import java.util.stream.Collectors;

public class Test {
    private University university = new University();

    /**
     * @return The names of students who study computer science
     */
    public Collection<String> listComputerScienceStudentNames(){
        Collection<String> result = new ArrayList<>();
        for (Student student : university.getStudents()){
            if(student.getFieldOfStudy().equalsIgnoreCase("computer science")){
                result.add(student.getName());
            }
        }
        return result;
    }

    /**
     *
     * @param fieldOfStudy An optional filter. If provided then the result contains only
     *                     those students studying that field. Otherwise all graduated students will
     *                     will be returned.
     * @return the set of graduated students matching filter.
     */
    public Collection<Student> listGraduatedStudents(String fieldOfStudy){
        Collection<Student> result = new ArrayList<>();
        for (Student student : university.getStudents()){
            if(fieldOfStudy.isEmpty() && student.isHasGraduated()){
                result.add(student);
            } else if (student.getFieldOfStudy().equalsIgnoreCase(fieldOfStudy) && !student.isHasGraduated()) {
                result.add(student);
            }
        }
        return result;
    }

    /**
     * @return A Map containing a list of students for each field of study
     * (i.e the key is the fieldOfStudy)
     *
     */
    public Map<String, List<Student>> groupStudentsByFieldofStudy(){
        List<Student> students              = new ArrayList<>();
        for (Student student : university.getStudents()){
            students.add(student);
        }
        Map<String, List<Student>> result = students.stream().collect(Collectors.groupingBy(s ->s.getFieldOfStudy()));
        return result;
    }

    public static void main(String[] args){
        Test test = new Test();

        System.out.println(test.listComputerScienceStudentNames());
        System.out.println(test.listGraduatedStudents(""));
        System.out.println(test.listGraduatedStudents("physics"));
        System.out.println(test.listGraduatedStudents("business studies"));
        System.out.println(test.listGraduatedStudents("computer science"));
        System.out.println(test.groupStudentsByFieldofStudy());
    }
}
