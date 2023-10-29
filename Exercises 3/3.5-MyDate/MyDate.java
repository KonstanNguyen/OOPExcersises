import java.time.*;

class MyDate{
  private int year;
  private int month;
  private int day;

  private static final String[] strMonths = {
    "Jan", "Feb", "Mar", "Apr", "May", "Jun",
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
  };

  private static final String[] strDays = {
    "Sunday", "Monday", "Tuesday", "Wednesday",
    "Thursday", "Friday", "Saturday"
  };
  
  private static final int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public static boolean isLeapYear(int year){
    if(year % 400 == 0)
      return true;

    return year%4 == 0 && year%100 != 0;
  }

  public static boolean isValidDate(int year, int month, int day){
    if(year < 1 || year > 9999)
      return false;

    if(month < 1 || month > 12)
      return false;

    if(isLeapYear(year)){
      daysInMonths[1] = 29;
    }else{
      daysInMonths[1] = 28;
    }

    return (day >= 1) && (day <= daysInMonths[month-1]);
  }

  public static int getDayOfWeek(int year, int month, int day){
    if(month < 3){
      month += 12;
      --year;
    }

    int cetury = year / 100;
    year %= 100;
    return (cetury/4 - 2*cetury + year + year/4 + (13*(month+1)/5) + day - 1)%7;
  }

  public MyDate(int year, int month, int day){
    this.setDate(year, month, day);
  }

  public final void setDate(int year, int month, int day){
    setYear(year);
    setMonth(month);
    setDay(day);
  }

  public int getYear(){
    return year;
  }

  public int getMonth(){
    return month;
  }

  public int getDay(){
    return day;
  }

  public void setYear(int year){
    if(year < 1 || year > 9999){
      throw new DateTimeException("Invalid year!");
    }

    this.year = year;
  }

  public void setMonth(int month){
    if(month < 1 || month > 12){
      throw new DateTimeException("Invalid month!");
    }

    this.month = month;
  }

  public void setDay(int day){
    if(!isValidDate(this.year, this.month, day))
      throw new DateTimeException("Invalid day!");

    this.day = day;
  }

  @Override
  public String toString(){
    int index = getDayOfWeek(year, month, day);
    return strDays[index] + " " + day + " " + strMonths[month-1] + " " + year;   
  }

  public MyDate nextDay(){
    ++day;
    if(!isValidDate(year, month, day)){
      day = 1;
      nextMonth();
    }
    return this;
  }

  public MyDate nextMonth(){
    ++month;

    if(month > 12){
      month = 1;
      nextYear();
    }

    if(!isValidDate(year, month, day)){
      day = daysInMonths[month-1];
    }

    return this;
  }

  public MyDate nextYear(){
    ++year;
    return this;
  }

  public MyDate previousDay(){
    --day;
    if(day < 1)
      previousMonth();
    
    return this;
  }

  public MyDate previousMonth(){
    --month;
    if(month < 1){
      previousYear();
      month = 12;
    }

    if(!isValidDate(year, month, day)){
      day = daysInMonths[month-1];
    }

    return this;
  }

  public MyDate previousYear(){
    --year; 
    return this;
  }
  
  public static void main(String[] args){
    try{
        MyDate d1 = new MyDate(2020, 10, 28);
        System.out.println(d1.toString());             // Tuesday 28 Feb 2012
        System.out.println(d1.nextDay().toString()); 
        System.out.println(d1.nextMonth().toString());// Wednesday 29 Feb 2012
        System.out.println(d1.nextDay().toString());   // Thursday 1 Mar 2012
        System.out.println(d1.nextMonth().toString()); // Sunday 1 Apr 2012
        System.out.println(d1.nextYear().toString());  // Monday 1 Apr 2013
        
        System.out.println("=====");
        MyDate d2 = new MyDate(2023, 1, 2);
        System.out.println(d2.toString());                 // Monday 2 Jan 2012
        System.out.println(d2.previousDay().toString());   // Sunday 1 Jan 2012
        System.out.println(d2.previousDay().toString());   // Saturday 31 Dec 2011
        System.out.println(d2.previousMonth().toString()); // Wednesday 30 Nov 2011
        System.out.println(d2.previousYear().toString());  // Tuesday 30 Nov 2010
        
        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear().toString());  // Monday 28 Feb 2011

        // MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
        // MyDate d5 = new MyDate(2011, 2, 29);  // Invalid year, month, or day!
    }
    catch(DateTimeException e){
        System.out.println(e.getMessage());
    }
  }
}
