package cst438.service;

public class TimeAndTemp {

   private double temp;
   private long time;
   private int timezone;
   
   
   
   public TimeAndTemp(double temp, long time, int timezone) {
      super();
      this.temp = temp;
      this.time = time;
      this.timezone = timezone;
   }

   
   public double getTemp() {
      return temp;
   }
   public void setTemp(double temp) {
      this.temp = temp;
   }
   public long getTime() {
      return time;
   }
   public void setTime(long time) {
      this.time = time;
   }
   public int getTimezone() {
      return timezone;
   }
   public void setTimezone(int timezone) {
      this.timezone = timezone;
   }
   
}
