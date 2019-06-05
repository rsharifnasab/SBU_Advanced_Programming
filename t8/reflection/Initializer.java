import annotation.Instantiate;
import annotation.Connect;

import java.lang.reflect.Field;
import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Initializer {

	public static Collection<Object> init(List<String> classNames){
		Collection<Object> ans = new HashSet<>();
		try {
				for (String className : classNames ) {
					Class cls = Class.forName(className);
				//	System.err.println("class name: " + cls.getSimpleName());
					for (Object a : cls.getDeclaredAnnotations() ) {
						if(a instanceof Instantiate) {
							Object testObject = cls.getConstructor().newInstance();
							//System.out.println("adding.. "+testObject);
							ans.add( testObject );

							break;
						}
					}
				}
					//System.out.println("--------");
				for(Object o: ans){ //every class of input
					//List <Field> fieldsFiltered = new LinkedList<>();
					Field[] fields = o.getClass().getDeclaredFields();
					//Arrays.stream(fields).filter(a-> a.getAnnotation(Connect.class) != null ).forEach(a->fieldsFiltered.add(a));
					//fieldsFiltered.stream().forEach(a->a.setAccessible(true));
					//System.err.println("going to foreach in fileds");
					for(Field f :  fields){
						for(Object anot : f.getDeclaredAnnotations() ){
							if (anot instanceof Connect == false) continue;
							f.setAccessible(true);
							int tedad = 0;
							for(Object o2 : ans){
								if(f.getType().equals(o2.getClass()) == false) continue;
								f.set(o,o2);
								tedad++;
								break;
							}
							f.setAccessible(false);
							if(tedad == 0) throw new InitializeException();
						}
					}
				}
						//Class fieldClass = f.getType();
						//Object newins = null;
						//for(Object o2:ans){
						//	if (o2.getClass().equals(fieldClass) ) newins = o2;
						//}
						//System.out.println("filed class type:"+fieldClass.getSimpleName());

						//if (newins == null ) throw new InitializeException();
						//System.err.println("new instance complaete");
						//f.set(o,newins);

					//System.out.println("main: " + o.getClass().getSimpleName());
					//System.out.println("connects to: " + fieldsFiltered);


		} catch(Exception e) {
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
        if (obj instanceof user.Manager) {
            // there is a "Connect" annotation for Manager.developer
						System.out.println("obj is:"+obj);
            System.out.println(((user.Manager) obj).getDeveloper()!=null);
        } else if (obj instanceof user.Service) {
            // there is a "Connect" annotation for Service.manager
            // TODO assertNotNull(((Service) obj).getManager());
						System.out.println( ((user.Service) obj).getManager() != null);
            // there is no "Connect" annotation for Service.employee
            //TODO assertNull(((Service) obj).getEmployee());
						System.out.println(((user.Service) obj).getEmployee()==null);
        } else if (obj instanceof user.Developer) {
            // an instance of Developer is created!
        } else {
            // anything else should fail
            System.out.println("fail");
        }
			}
	}

}
