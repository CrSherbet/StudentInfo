package tasktimer;

import java.io.InputStream;

/**
 * Class Dictionary will read "wordlist.text" file and return InputStream 
 * @author Warisara
 *
 */
public class Dictionary {
	/**
	 * Return InputStream that contains word list 
	 * @return instream is InputStream that contains word list
	 */
	public static InputStream getWordsAsStream(){
		InputStream instream = TaskTimer.class.getClassLoader().getResourceAsStream("wordlist.txt");
		return instream ;
	}
}
