package ComparatorExample;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSorting {

    public static void main(String[] args) {
        List<Developer> developers = getDevelopers();

        System.out.println("Before Sort");
        developers.forEach(System.out::println);

//		//sort by age
//		Collections.sort(developers, new Comparator<Developer>(){
//
//			@Override
//			public int compare(Developer arg0, Developer arg1) {
//				return arg0.getSalary().compareTo(arg1.getSalary());
//			}
//		});
//		
        developers.sort(Comparator.comparingInt(Developer::getAge));

        System.out.println("After Sort");
        developers.forEach(System.out::println);

    }

    public static List<Developer> getDevelopers() {
        List<Developer> result = new ArrayList<>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;
    }

}
