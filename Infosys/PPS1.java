package Infosys;

import java.util.Arrays;
import java.util.List;

public class PPS1 {

    public static void main(String[] args) {
        /*
        // Client -> Controller -> Service -> Repository(JPA) -> Database

        @Entity
        @Table(name="Students")
        public class Student {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Integer id;

            @Column(nullable = false)
            private String name;

            @Column(nullable = false)
            private String grade
            
        }

        2) Repository

        @Repository
        public interface StudentRepository extends JpaRepository<Student, Integer> {

        }

        3) Service
        @Service
        @RequiredArgsConstructor
        public class StudentService {
            private final StudentRepository repository

            public List<Student> getStudent() {
                return repository.finaAll();
            }

            public Student updateStudent(Integer id, Student dto) {
                Student student = repository.findById(id)
                .orElseThrown();

                student.setName(dto.getName());
                student.setGrade(dto.setGrade());

                return reposotory.save(student);
            }

        }

        4) Controller
        @RestController
        @RequestMapping("/students")
        public class StudentController {
            private final StudentService service;

            @GetMapping
            public ResponseEntity<List<Student>> getStudents() {
                return ResponseEntity.ok(service.getStudents());
            }
        }


         */

   int[] arr = {1,2,3,4,5,6};

   // For evens
    List<Integer> evens = Arrays.stream(arr)
            .filter(n -> n % 2 == 0)
            .boxed()
            .toList();

    evens.forEach(System.out::println);

    // For Odds
    List<Integer> odds = Arrays.stream(arr)
            .filter(n -> n%2 != 0)
            .boxed()
            .toList();

    odds.forEach(System.out::print);     
    
    
    

    /* Array

        ↓

        Arrays.stream(arr)



        Collection

        ↓

        list.stream()



        String

        ↓

        str.chars()



        Need List<Integer> from int[]?

        ↓

        boxed()



        Need lowercase?

        ↓

        Character.toLowerCase()



        Need characters?

        ↓

        (char) c

        "chars() is for Strings what stream() is for Lists."
     */

        String s1 = "ABCD";

        s1.chars().forEach(System.out::print); // 65, 66, 67  this chars() will give intStream
        s1.chars().forEach(c -> System.out.print(" "+(char)c)); // A B C



    String str = "Asam Pavan Infosys";
    long count = str.chars()
                    .map(Character::toLowerCase)
                    // .map(c-> Character.toLowerCase(c))
                    .filter(c -> 
                        c=='a' ||
                        c=='e' ||
                        c=='i' ||
                        c=='o' ||
                        c=='u')
                        .count();

    System.out.println(count);
    }
}
