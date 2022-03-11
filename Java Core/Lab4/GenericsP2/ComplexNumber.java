import java.math.BigDecimal;

/*
public class ComplexNumber <T extends  Number,R extends Number> {

    public T real;
    public R imag;

    public ComplexNumber(T real, R imag) {
        this.real = real;
        this.imag = imag;
    }

    public void sum(ComplexNumber c1 ,ComplexNumber c2){

        if(c1.real instanceof Double)
            c1.real = c1.real.doubleValue() + c2.real.doubleValue();
        else if (c1.real instanceof Integer)
            c1.real = c1.real.intValue() + c2.real.intValue();

        if(c1.imag instanceof Double)
            c1.imag = c1.imag.doubleValue() + c2.imag.doubleValue();
        else if (c1.imag instanceof Integer)
            c1.imag = c1.imag.intValue() + c2.imag.intValue();

    }

    public void  subtract(ComplexNumber  c1 , ComplexNumber c2){
        if(c1.real instanceof Double)
            c1.real = c1.real.doubleValue() - c2.real.doubleValue();
        else if (c1.real instanceof Integer)
            c1.real = c1.real.intValue() - c2.real.intValue();

        if(c1.imag instanceof Double)
            c1.imag = c1.imag.doubleValue() - c2.imag.doubleValue();
        else if (c1.imag instanceof Integer)
            c1.imag = c1.imag.intValue() - c2.imag.intValue();
    }

    public void  multiply(ComplexNumber  c1 , ComplexNumber c2){

        if(c1.real instanceof Double)
            c1.real = c1.real.doubleValue() * c2.real.doubleValue() - c1.imag.doubleValue() *  c2.imag.doubleValue();
        else if (c1.real instanceof Integer)
            c1.real = c1.real.intValue() * c2.real.intValue() - c1.imag.intValue() *  c2.imag.intValue();

        if(c1.imag instanceof Double)
            c1.imag = c1.real.doubleValue() * c2.real.doubleValue() + c1.imag.doubleValue() *  c2.imag.doubleValue();
        else if (c1.imag instanceof Integer)
            c1.imag = c1.real.intValue() * c2.real.intValue() +  c1.imag.intValue() *  c2.imag.intValue();

    }


        //  double real = this.real * b.real - this.img * b.img;
        //  double img = this.real * b.img + this.img * b.real;


}
*/
                
class ComplexNumber<T extends BigDecimal,R extends BigDecimal>{

    T real;
    R imag;
    public ComplexNumber(T r,R i){
        real=r;
        imag=i;
    }
    public void add(ComplexNumber<T,R> c){
        real=(T)(real.add(c.real));
        imag=(R)(imag.add(c.imag));
    }
    public void subtract(ComplexNumber<T,R> c){
        real=(T)(real.subtract(c.real));
        imag=(R)(imag.subtract(c.imag));
    }
    public void multiply(ComplexNumber<T,R> c){
        real=(T)(real.multiply(c.real).add(((imag.multiply(c.imag)).multiply(new BigDecimal(-1)))));
        imag=(R)((real.multiply(c.imag)).add((imag.multiply(c.real))));
    }


}
