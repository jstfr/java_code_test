public class Student {
    private String name;
    private String fieldOfStudy;
    private boolean hasGraduated;

    public Student(String name, String fieldOfStudy, boolean hasGraduated) {
        this.name           = name;
        this.fieldOfStudy   = fieldOfStudy;
        this.hasGraduated   = hasGraduated;
    }

    public String getName() {return name;}
    public String getFieldOfStudy() {return fieldOfStudy;}
    public boolean isHasGraduated() {return hasGraduated;}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", hasGraduated=" + hasGraduated +
                '}';
    }
}
