import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Person {

    public static void main(String... args) {
        loadList();

    }


    Person(String firstName, String lastName, int month) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.month = month;

    }

    String firstName;
    String lastName;
    int month;

    public static void loadList() {

        List<Person> persons = Arrays.asList(
                new Person("Ovidiu", "Robotin", 11),
                new Person("Emanuel", "Robotin", 12),
                new Person("Teodora", "Ausan", 9),
                new Person("Teodor", "Pop", 2),
                new Person("Tudor", "Marcu", 5),
                new Person("Georgiana", "Pasca", 12),
                new Person("Ana", "Popescu", 12),
                new Person("Bogdan", "Popa", 12),
                new Person("Aurelia", "Calin", 3),
                new Person("Madalina", "Bancos", 12),
                new Person("Marc", "Dorobantiu", 6),
                new Person("Amelia", "Libotean", 12),
                new Person("Diana", "Muresan", 9),
                new Person("Maria", "Teodorovici", 4),
                new Person("Georgiana", "Robotin", 11));


        List<Person> filtered =
                persons
                        .stream()

                        .collect(Collectors.toList());

        System.out.println("We found the following persons in the database:" + filtered);

        System.out.println();


        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),
                        (j, p) -> j.add(p.getFirstName().toUpperCase()),

                        (j1, j2) -> j1.merge(j2),
                        StringJoiner::toString);

        String names = (String) persons
                .stream()
                .filter(p -> p.month == 12)

                .collect(personNameCollector);

        System.out.println("Persons that were born in December:" + names);


    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }


    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", month=" + month +
                '}';
    }
}



