package literal;

// See http://gleichmann.wordpress.com/2008/01/13/building-your-own-literals-in-java-lists-and-arrays/

import java.util.Arrays;
import java.util.List;

public class collection {
	public static <T> List<T> List(T...elems) {
		return Arrays.asList(elems);
	}
}
