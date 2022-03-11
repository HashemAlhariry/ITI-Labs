

public class MethodReferenceP2 {

    public static boolean checkStringFromStaticMethod(String s) {
        boolean check = true;
        for(int i=0;i<s.length();i++){

            if(!Character.isLetter(s.charAt(i)))
            {
                check=false;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) {

        String string = "ahshas312jsaasadads";
        //using anonymous class
        Check check = new  Check() {
            public boolean checkString(String s) {
                boolean check = true;
                for(int i=0;i<s.length();i++){

                    if(!Character.isLetter(s.charAt(i)))
                    {
                        check=false;
                        break;
                    }
                }
                return check;
            }
        };
        //using lambda expression
         Check checkLambd = (s) -> {
            boolean newcheck = true;
            for(int i=0;i<s.length();i++){

                if(!Character.isLetter(s.charAt(i)))
                {
                    newcheck=false;
                    break;
                }
            }
            return newcheck;
        };
        //using lambda static method
        Check checkLambda= (s) ->checkStringFromStaticMethod(s);
        //using reference to a static method
         Check checkReference=  MethodReferenceP2::checkStringFromStaticMethod;

        System.out.println(check.checkString(string));
        System.out.println(checkLambd.checkString(string));
        System.out.println(checkReference.checkString(string));

    }

    interface Check{
        public boolean checkString(String s);
    }



}
