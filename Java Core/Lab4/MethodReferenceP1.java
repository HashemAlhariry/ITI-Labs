
public class MethodReferenceP1 {

    public static boolean betterString(String one , String two, StringFunctionalInterface lambda ){
        return  lambda.stringChecker(one,two);
    };
    public static void main(String[] args) {

        String one = "Hazem Khaled";
        String two = "Hashem Khaled";

        StringFunctionalInterface stringFunctionalInterface=(s1,s2) -> {
            if(s1.length()>s2.length())
                return true;
            return false;
        };

        System.out.println(betterString(one,two,stringFunctionalInterface));

    }
    interface StringFunctionalInterface {
        boolean  stringChecker(String one,String two);
    }
}
