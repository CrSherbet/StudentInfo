package student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter , Consumer<Student> action , Comparator<Student> sortor) {
		/*for(Student s : students ) {
			if ( filter.test(s))
				action.accept( s );
		}*/
		students.stream().filter( filter ).sorted( sortor ).forEach( action );
	}
	
	/**
	 * Runs the program
	 * @param args was not used
	 */
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		StudentApp app = new StudentApp();
		Predicate<Student> birthdateTest =  (s) -> s.getBirthdate().getMonthValue() == LocalDate.now().getMonthValue() ;
		Predicate<Student> bdNext2WeeksTest = (s) -> s.getBirthdate().getDayOfYear() - LocalDate.now().getDayOfYear()  <= 14 && s.getBirthdate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0 ;	
		Consumer<Student> actionAccept = (s) -> System.out.println( s + " will have brithday on "+ s.getBirthdate().getDayOfMonth() +" "+s.getBirthdate().getMonth());
		Comparator<Student> byName = (a,b) -> a.getFirstname().charAt(0) - b.getFirstname().charAt(0);
		Comparator<Student> byBirthday = (a,b) -> a.getBirthdate().getDayOfMonth() - b.getBirthdate().getDayOfMonth() ;
		app.filterAndPrint(students, bdNext2WeeksTest , actionAccept , byBirthday);
	}
}
