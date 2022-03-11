import java.math.BigDecimal;
public class Main {


    public static void main(String[] args) {

        /*
        ComplexNumber<Integer,Integer> intObjOne = new ComplexNumber<>(50,40);
        ComplexNumber<Integer,Integer> intObjTwo= new ComplexNumber<>(10,20);

        intObjOne.sum(intObjOne,intObjTwo);
        System.out.println("Sum Real "+intObjOne.real +" Imag "+ intObjOne.imag );
        intObjOne.subtract(intObjOne,intObjTwo);
        System.out.println("Subtract Real "+intObjOne.real +" Imag "+ intObjOne.imag );
        intObjOne.multiply(intObjOne,intObjTwo);
        System.out.println("Multiply Real "+intObjOne.real +" Imag "+ intObjOne.imag );

        ComplexNumber<Double,Double> doubleObjOne = new ComplexNumber<>(5.0, 6.0);
        ComplexNumber<Double,Double> doubleObjTwo= new ComplexNumber<>(10.0, 40.0);

        doubleObjOne.sum(doubleObjOne,doubleObjTwo);
        System.out.println("Sum Real "+doubleObjOne.real +" Imag "+ doubleObjOne.imag );
        doubleObjOne.subtract(doubleObjOne,doubleObjTwo);
        System.out.println("Subtract Real "+doubleObjOne.real +" Imag "+ doubleObjOne.imag );
        doubleObjOne.multiply(doubleObjOne,doubleObjTwo);
        System.out.println("Multiply Real "+doubleObjOne.real +" Imag "+ doubleObjOne.imag );
        */

		ComplexNumber<BigDecimal,BigDecimal> c=new ComplexNumber(new BigDecimal(2),new BigDecimal(1));
		ComplexNumber<BigDecimal,BigDecimal> x=new ComplexNumber(new BigDecimal(5.5),new BigDecimal(4.3));
		System.out.println(c.real+" "+c.imag);
		c.add(x);
		System.out.println(c.real+" "+c.imag);
		c.subtract(x);
		System.out.println(c.real+" "+c.imag);
		c.multiply(x);
		System.out.println(c.real+" "+c.imag);

    }
}
