import annotation.Instantiate;
import annotation.Connect;

import java.lang.reflect.Field;
import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Initializer {

	public static Collection<Object> init(List<String> classNames1){
		List<Object> ans = new LinkedList<>();
		List<String>  classNames = classNames1.stream().distinct().collect(java.util.stream.Collectors.toList());
		try {
				for (String className : classNames ) {
					Class cls = Class.forName(className);
				//	System.err.println("class name: " + cls.getSimpleName());
					for (Object a : cls.getDeclaredAnnotations() ) {
						if(a.toString().equals("@annotation.Instantiate()")) {
							Object testObject = cls.getConstructor().newInstance();
							//System.out.println("adding.. "+testObject);
							ans.add( testObject );

							break;
						}
					}
				}
					//System.out.println("--------");
				for(Object o: ans){ //every class of input
					List <Field> fieldsFiltered = new LinkedList<>();
					Field[] fields = o.getClass().getDeclaredFields();
					Arrays.stream(fields).filter(a-> a.getAnnotation(Connect.class) != null ).forEach(a->fieldsFiltered.add(a));
					fieldsFiltered.stream().forEach(a->a.setAccessible(true));
					//System.err.println("going to foreach in fileds");
					for(Field f :  fieldsFiltered){
						Class fieldClass = f.getType();
						Object newins = null;
						for(Object o2:ans){
							if (o2.getClass().equals(fieldClass) ) newins = o2;
						}
						//System.out.println("filed class type:"+fieldClass.getSimpleName());

						if (newins == null ) throw new InitializeException();
						//System.err.println("new instance complaete");
						f.set(o,newins);
					}
					//System.out.println("main: " + o.getClass().getSimpleName());
					//System.out.println("connects to: " + fieldsFiltered);
				}

		} catch(Exception e) {
			throw new InitializeException();
		}
		return ans;
	
	}

}
