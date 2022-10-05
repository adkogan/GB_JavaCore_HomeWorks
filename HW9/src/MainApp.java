import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {


    public static final Course MATH = new Course("math");
    public static final Course GEO = new Course("Geography");
    public static final Course LIT = new Course("Literature");
    public static final Course POLI = new Course("Political Science");
    public static final Course BIO = new Course("Biology");


    public static void main(String[] args) {


        List<Student> students = Arrays.asList(
            new Student(
                "Pit",
                    Arrays.asList(
                            GEO
                    )
                ),
            new Student(
                "Sid",
                    Arrays.asList(
                         MATH, POLI
                    )
            ),
            new Student(
                "Mary",
                    Arrays.asList(
                         MATH, LIT
                    )
                ),
            new Student("Sam",
                    Arrays.asList(
                            MATH, LIT, GEO
                    )
            ),
            new Student("Ben", Arrays.asList(
                    GEO, MATH, LIT, POLI
                    )
            )
            , new Student("Meg",
                        Arrays.asList(
                                POLI
                        )
                )
            , new Student("Tim",
                        Arrays.asList(
                                BIO
                        )
                )
            );

       Set<Course> uniqueCourses = getUniqueCourses(students);
       System.out.println(uniqueCourses);

       List<Student> theMostGeekyStudents = getTheMostGeekyStudents(students);
       System.out.println(theMostGeekyStudents);

       List<Student> studentsByCourse = getStudentsByCourse(students, BIO);
       System.out.println(studentsByCourse);


    }


    private static Set<Course> getUniqueCourses(List<Student> students) {
        return students.
                stream().
                flatMap(student -> student
                        .getCourses()
                        .stream()
                )
                .collect(Collectors.toSet());
    }


    private static List<Student> getTheMostGeekyStudents(List<Student> students){
        return students.
                stream().
                sorted(
                    Comparator.
                            <Student>comparingInt(o -> o.getAllCourses().size()).
                            reversed()
                ).
                //sorted((o1, o2) -> o1.getAllCourses().size() - o2.getAllCourses().size()).
                limit(3).
                collect(Collectors.toList());
    }


    private static List<Student> getStudentsByCourse(List<Student> students, Course course){
        return students.
                stream().
                filter(student -> student.
                        getAllCourses().
                        contains(course)).
                collect(Collectors.toList());

    }




}
