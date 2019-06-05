import annotation.Instantiate;
import annotation.Connect;

import java.lang.reflect.Field;
import java.lang.reflect.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Initializer {

	public static Collection<Object> init(List<String> classNames){
		Collection<Object> collection = new LinkedHashSet<>();
		for (String name : classNames){
			try {
				Class c = Class.forName(name);
				for(Object an : c.getDeclaredAnnotations() ){ //TODO
					if (an instanceof Instantiate){
						Constructor constructor = c.getDeclaredConstructor();
						collection.add(constructor.newInstance());
						break;
					}
				}
			} catch(Exception e) {
					throw new InitializeException();
			}
		}
		for (Object obj : collection){
			try{
				Field[] fields = obj.getClass().getDeclaredFields();
				for(Field field : fields){
					for(Object annotation : field.getDeclaredAnnotations()){ //TODO
						if(annotation instanceof Connect){
							field.setAccessible(true);
							boolean exists = false;
							for(Object instance : collection){
								if(field.getType().equals(instance.getClass())){
									field.set(obj,instance);
									exists = true;
									break;
								}
							}
							field.setAccessible(false);
							if(!exists){
								throw new InitializeException();
							}
						}
					}
				}
			}
			catch(Exception e){
				throw new InitializeException();
			}
		}
		return collection;
	}
		//-----------
/*
		try {
				for (String className : classNames ) {
					Class cls = Class.forName(className);
					for (Object a : cls.getDeclaredAnnotations() ) {
						if(a instanceof Instantiate) {
							Object testObject = cls.getConstructor().newInstance();
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
		*/

}
