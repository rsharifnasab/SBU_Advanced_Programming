import annotation.Instantiate;
import annotation.Connect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Initializer {

	public static Collection<Object> init(List<String> classNames) {
		try {
				List<Object> ans = new LinkedList<>();
				for (String className : classNames ) {
					Class cls = Class.forName(className);
					System.out.println("class name:" + cls.getSimpleName());
					System.out.println(cls.getAnnotations());
				}
		} catch(Exception e) {
			throw new InitializeException();
		}
		finally{
				return ans;
		}
	}
	public static void main(String[] args) {
		Collection<Object> objects = Initializer.init(
            Arrays.asList("user.Manager", "user.Service", "user.Developer"));

	}

}
