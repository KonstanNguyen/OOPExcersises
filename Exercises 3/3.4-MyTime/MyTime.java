class MyTime {
  private int hour = 0;
  private int minute = 0;
  private int second = 0;

  public MyTime(int hour, int minute, int second) {
    setTime(hour, minute, second);
  }

  public void setTime(int hour, int minute, int second) {
    setHour(hour);
    setMinute(minute);
    setSecond(second);
  }

  public int getHour() {
    return hour;
  }

  public int getMinute() {
    return minute;
  }

  public int getSecond() {
    return second;
  }

  public void setHour(int hour) {
    if (hour >= 0 && hour <= 23) {
      this.hour = hour;
    } else {
      throw new IllegalArgumentException("Invalid hour!");
    }
  }

  public void setMinute(int minute) {
    if (minute >= 0 && minute <= 59) {
      this.minute = minute;
    } else {
      throw new IllegalArgumentException("Invalid minute!");
    }
  }

  public void setSecond(int second) {
    if (second >= 0 && second <= 59) {
      this.second = second;
    } else {
      throw new IllegalArgumentException("Invalid second!");
    }
  }

  @Override
  public String toString() {
    return String.format("%02d:%02d:%02d", hour, minute, second);
  }

  public MyTime nextSecond() {
    ++second;
    if (second == 60) {
      second = 0;
      nextMinute();
    }
    return this;
  }

  public MyTime nextMinute() {
    ++minute;

    if (minute == 60) {
      minute = 0;
      nextHour();
    }

    return this;
  }

  public MyTime nextHour() {
    ++hour;

    if (hour == 24) {
      hour = 0;
    }

    return this;
  }

  public MyTime previousSecond() {
    --second;
    if (second < 0) {
      second = 59;
      previousMinute();
    }

    return this;
  }

  public MyTime previousMinute() {
    --minute;

    if (minute < 0) {
      minute = 59;
      previousHour();
    }

    return this;
  }

  public MyTime previousHour() {
    --hour;

    if (hour < 0) {
      hour = 23;
    }

    return this;
  }

  public static void main(String[] args) {
    MyTime time = new MyTime(12, 30, 45);

    System.out.println("Initial Time: " + time);
    time.nextSecond();
    System.out.println("Next Second: " + time);
    time.nextMinute();
    System.out.println("Next Minute: " + time);
    time.nextHour();
    System.out.println("Next Hour: " + time);

    time.previousSecond();
    System.out.println("Previous Second: " + time);
    time.previousMinute();
    System.out.println("Previous Minute: " + time);
    time.previousHour();
    System.out.println("Previous Hour: " + time);

    // Testing invalid input
    try {
      time.setTime(25, 70, 80); // Invalid input
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}