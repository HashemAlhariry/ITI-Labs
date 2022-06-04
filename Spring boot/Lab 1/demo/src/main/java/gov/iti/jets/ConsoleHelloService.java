package gov.iti.jets;

public class ConsoleHelloService implements HelloService{
    private String prefix;
    private String suffix;

    public ConsoleHelloService(){
        this.prefix="";
        this.suffix="";
    }
    public ConsoleHelloService(String prefix,String suffix){
        this.prefix=prefix;
        this.suffix=suffix;
    }


    @Override
    public void sayHello(String message) {
        System.out.println(prefix+", "+message+ ", "+suffix);
    }
}
