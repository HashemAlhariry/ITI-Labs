package restproj;

import java.time.LocalDate;

public class MyDate {
    
    private int day;
    private int month;
    private int year;

    public MyDate(LocalDate date) {
        this.day = date.getDayOfMonth();
        this.month = date.getMonthValue();
        this.year = date.getYear();
     }

    public void setDay(int day){
        this.day=day;
    }

    public int getDay(){
        return day;
    }    

    public void setMonth(int month){
        this.month=month;
    }

    public int getMonth(){
        return month;
    }    

    public void setYear(int year){
        this.year=year;
    }

    public int getYear(){
        return year;
    }

    @Override
    public String toString() {
        return this.day+" "+this.month+" "+this.year;
    }    

    
}