package for_each;

import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collectors;

public class NowJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> lines = Arrays.asList("one","two","three");
//		
//		List<String> results = lines.stream()
//				.filter(line -> !"one".equals(line))
//				.collect(Collectors.toList());
//		
//		results.forEach(System.out::println);
		
		 List<Person> persons = Arrays.asList(
	                new Person("mkyong", 30),
	                new Person("jack", 20),
	                new Person("lawrence", 40)
	        );
		 
		 Person p1 = persons.stream()
				 .filter(person -> "jack".equals(person.getName()))
				 .findAny()
				 .orElse(null);
		 
		 String name  = persons.stream()
				 .filter(person -> person.getName().equals("jack"))
				 .map(Person::getName)
				 .findAny()
				 .orElse(null);
		 
		 System.out.println(name);
				 
		 }

}
