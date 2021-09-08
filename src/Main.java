import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = getPerson();

        /*
        Старый способ сортировки (Императивный)

        List<Person> developers = new ArrayList<>();

        for (Person person : persons) {
            if (person.getSpeciality().equals(Speciality.DEVELOPER)){
                developers.add(person);
            }
        }
        /*

          Новый способ (Декларативный)

         */

        // Filter

       List<Person> developers =  persons.stream()
                .filter(person -> person.getSpeciality().equals(Speciality.DEVELOPER))
                .collect(Collectors.toList());
        developers.forEach(System.out::println);

        System.out.println();

        List<Person> managers = getPerson().stream()
                .filter(person -> person.getSpeciality().equals(Speciality.MANAGER))
                .collect(Collectors.toList());
        managers.forEach(System.out::println);

        System.out.println();

        List<Person> engineers = getPerson().stream()
                .filter(person -> person.getSpeciality().equals(Speciality.ENGINEER))
                .collect(Collectors.toList());
        engineers.forEach(System.out::println);

        System.out.println();

        // Sort
        System.out.println("Age Sorted ");

        List<Person> sortedAge =  persons.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        sortedAge.forEach(System.out::println);

        System.out.println();
        System.out.println("Salary Sorted ");

        List<Person> sortedSalary = persons.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .collect(Collectors.toList());
        sortedSalary.forEach(System.out::println);

        System.out.println();
        System.out.print("Max salary is: ");

        persons.stream()
                .max(Comparator.comparing(Person::getSalary))
                .ifPresent(System.out::println);

        System.out.println();
        System.out.print("Min salary is: ");


        persons.stream()
                .min(Comparator.comparing(Person::getSalary))
                .ifPresent(System.out::println);

        System.out.println();

        Map<Speciality,List<Person>> classifications = persons.stream()
                .collect(Collectors.groupingBy(Person::getSpeciality));

        classifications.forEach(((speciality, people) -> {
            System.out.println(speciality);
            people.forEach(System.out::println);
            System.out.println();
        }));

       Optional<String> oldestPerson =  persons.stream()
                .filter(person -> person.getSpeciality().equals(Speciality.DEVELOPER))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        System.out.print("The oldest person is: ");
        oldestPerson.ifPresent(System.out::println);

    }

    private static List<Person> getPerson(){
        return List.of(
                new Person("Egor", "Merzlov", 22,1150,Speciality.DEVELOPER),
                new Person("Vadim", "Krugli",21,900,Speciality.MANAGER),
                new Person("Gleb","Tihov",23,1200,Speciality.DEVELOPER),
                new Person("Vlad","Vlasov",22,1250,Speciality.ENGINEER),
                new Person("Kirill","Rovniy",20,950,Speciality.MANAGER),
                new Person("Vova","Sofin",25,1300,Speciality.ENGINEER),
                new Person("Gosha","Puton",22,1100,Speciality.MANAGER),
                new Person("Anton","Hvost",23,1400,Speciality.DEVELOPER),
                new Person("Katia","Naiko",21,1300,Speciality.ENGINEER)

        );
    }
}
