package root;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.annotation.*;

public class Main {

    public static void main(String[] args) {

        AutherClass autherClass = new AutherClass();
        try {

            Class<?> c = autherClass.getClass();
            Method m = c.getMethod("getAutherName");
            Field f = c.getDeclaredField("autherName");
            var cons=c.getDeclaredConstructor();
            Author anno = m.getAnnotation(Author.class);
            System.out.println(anno.str()+ " "+ anno.val()+" "+anno.dVal());
            anno = f.getAnnotation(Author.class);
            System.out.println(anno.str()+ " "+ anno.val()+" "+anno.dVal());
            f.setInt(autherClass,12);
            System.out.println(autherClass.autherName);
            m.setAccessible(true);
            m.invoke(autherClass);
            cons.setAccessible(true);
            Object obj = cons.newInstance();


        } catch (NoSuchMethodException exc ) {
            System.out.println("ERROR NOT FOUND.");
        } catch (NoSuchFieldException exc){
            System.out.println("No Such Field ");
        } catch (IllegalAccessException exc) {
            System.out.println("Illegal Access");
        }catch(Exception e){
            
        }


    }
}

