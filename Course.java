// assignment 2 10.9

public class Course {
  private String courseName;

  private String[] students;

  private int numberOfStudents;

  public Course(String courseName) {
    this.courseName = courseName;
    numberOfStudents = 0;
    students = new String[1];
  }

  public void addStudent(String student) {
    if (numberOfStudents == students.length) {
      String[] temp = new String[students.length * 2];
      System.arraycopy(students, 0, temp, 0, students.length);
      students = temp;
    }
    students[numberOfStudents] = student;
    numberOfStudents++;
  }

  public String[] getStudents() {
    return students;
  }

  public int getNumberOfStudents() {
    return numberOfStudents;
  }

  public String getCourseName() {
    return courseName;
  }

  public void dropStudent(String student) {
    int loc = 0;
    while (loc < numberOfStudents && !students[loc].equals(student)) {
      loc++;
    }
    for (int i = loc + 1; i < numberOfStudents; i++) {
      students[i - 1] = students[i];
    }
    if (loc < numberOfStudents) {
      numberOfStudents--;
    }
  }

  public void clear() {
    for (int i = 0; i < numberOfStudents; i++) {
      students[i] = null;
    }
    numberOfStudents = 0;
  }

  public static void main(String[] args) {
    Course c = new Course("Java");
    c.addStudent("T1");
    c.addStudent("T2");  // Trigger expansion
    c.addStudent("T3");  // Trigger expansion
    c.addStudent("T4");
    c.addStudent("T5");  // Trigger expansion
    for (int i = 0; i < c.getNumberOfStudents(); i++) {
      System.out.println(c.getStudents()[i]);
    }

    c.dropStudent("T2");
    System.out.println("After drop T2");
    for (int i = 0; i < c.getNumberOfStudents(); i++) {
      System.out.println(c.getStudents()[i]);
    }

    c.clear();
    System.out.println("After clear");
    for (int i = 0; i < c.getNumberOfStudents(); i++) {
      System.out.println(c.getStudents()[i]);
    }
  }
}