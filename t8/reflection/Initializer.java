import annotation.Instantiate;
import annotation.Connect;

import java.lang.reflect.Field;
import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import user.*; //TODO
public class Initializer {

	public static Collection<Object> init(List<String> classNames){
		List<Object> ans = new LinkedList<>();
		try {
				for (String className : classNames ) {
					Class cls = Class.forName(className);
					System.err.println("class name: " + cls.getSimpleName());
					for (Object a : cls.getDeclaredAnnotations() ) {
						if(a.toString().equals("@annotation.Instantiate()")) {
							Object testObject = cls.getConstructor().newInstance();
							System.out.println("adding.. "+testObject);
							ans.add( testObject );

							break;
						}
					}
				}
					System.out.println("--------");
				for(Object o: ans){ //every class of input
					List <Field> fieldsFiltered = new LinkedList<>();
					Field[] fields = o.getClass().getDeclaredFields();
					Arrays.stream(fields).filter(a-> a.getAnnotation(Connect.class) != null ).forEach(a->fieldsFiltered.add(a));
					fieldsFiltered.stream().forEach(a->a.setAccessible(true));
					System.err.println("going to foreach in fileds");
					for(Field f :  fieldsFiltered){
						Class fieldClass = f.getClass();
						System.err.println("getclass compalete");
						Object newins = fieldClass.getConstructor().newInstance();

						System.err.println("new instance complaete");
						f.set(o,newins);
					}
					System.out.println("main: " + o.getClass().getSimpleName());
					System.out.println("connects to: " + fieldsFiltered);
				}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			throw new InitializeException();
		}
		return ans;
	}
	public static void main(String[] args) {
		//user.Developer a = new user.Developer();
		//user.Service b = new user.Service();
		Collection<Object> objects = Initializer.init(
            Arrays.asList("user.Manager", "user.Service", "user.Developer"));
		System.out.println(objects.size());
		 for (Object obj : objects) {
        if (obj instanceof Manager) {
            // there is a "Connect" annotation for Manager.developer
						System.out.println("obj is:"+obj);
            System.out.println(((Manager) obj).getDeveloper()!=null);
        } else if (obj instanceof Service) {
            // there is a "Connect" annotation for Service.manager
            // TODO assertNotNull(((Service) obj).getManager());
            // there is no "Connect" annotation for Service.employee
            //TODO assertNull(((Service) obj).getEmployee());
        } else if (obj instanceof Developer) {
            // an instance of Developer is created!
        } else {
            // anything else should fail
            System.out.println("fail");
        }
			}
	}

}
