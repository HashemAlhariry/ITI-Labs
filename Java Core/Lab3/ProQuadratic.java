import java.util.function.Function;

public class ProQuadratic {

        public static void main(String[] args) {

                Function<FirstClass,SecondClass> pQuadraticFunction = (FirstClass) -> {

                        double determinant = (FirstClass.getB()*FirstClass.getB())-( 4*FirstClass.getA()*FirstClass.getC());
                        double sqrt = Math.sqrt(determinant);
                        SecondClass secondClass = new SecondClass((-FirstClass.getB() + sqrt)/(2*FirstClass.getA()), (-FirstClass.getB() - sqrt)/(2*FirstClass.getA()));
                        return  secondClass;
                };


                FirstClass firstClass = new FirstClass(15,68,12);
                SecondClass class1 = pQuadraticFunction.apply(firstClass);
                
                System.out.println("Roots are " +class1.pValue);
                System.out.println("Roots are " +class1.pValue);
        }

        static class FirstClass {
                
                int a;
                int b;
                int c;

                public FirstClass(int a, int b, int c) {
                        this.a = a;
                        this.b = b;
                        this.c = c;
                }

                public int getA() {
                        return a;
                }
                public void setA(int a) {
                        this.a = a;
                }
                public int getB() {
                        return b;
                }
                public void setB(int b) {
                        this.b = b;
                }
                public int getC() {
                        return c;
                }
                public void setC(int c) {
                        this.c = c;
                }

        }

        static class SecondClass {

                double pValue;
                double nValue;
                public SecondClass(double a, double b) {
                        pValue=a;
                        nValue=b;
                }




        }





}