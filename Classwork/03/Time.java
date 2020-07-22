import java.io.*;
import java.util.*;

public class Time {

	private int hour;
	private int minute;
	private double second;

	public Time() {
		this.hour = 0;
		this.minute = 0;
		this.second = 0.0;
	}

	public Time(int hour, int minute, double second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public static void printTime(Time t) {
		System.out.printf("%02d:%02d:%04.1f\n", t.hour, t.minute, t.second);
	}

	// Getter Methods
	public int getHour() {
		return this.hour;
	}

	public int getMinute() {
		return this.minute;
	}

	public double getSecond() {
		return this.second;
	}

	// Setter methods
	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSecond(double second) {
		this.second = second;
	}

	// To String
	public String toString() {
		return String.format("%02d:%02d:%04.1f", this.hour, this.minute, this.second);
	}

	// Equals
	public boolean equals(Time that) {
		return this.hour == that.hour && this.minute == that.minute && this.second == that.second;
	}

	// Increases seconds by 1.
	public void increment(double seconds) {
		this.second += seconds;
		while (this.second >= 60.0) { // If seconds is increased >= 60, reset to 0 and increment minutes by 1.
			this.second -= 60.0;
			this.minute += 1;
		}
		while (this.minute >= 60) { // If minutes is now >= 60, reset to 0 and increase hours by 1.
			this.minute -= 60;
			this.hour += 1;
		}
	}

	// Static add method
	public static Time add(Time t1, Time t2) {
		Time sum = new Time();
		sum.hour = t1.hour + t2.hour;
		sum.minute = t1.minute + t2.minute;
		sum.second = t1.second + t2.second;
		
		if (sum.second >= 60.0) {
	        sum.second -= 60.0;
	        sum.minute += 1;
	    }
	    if (sum.minute >= 60) {
	        sum.minute -= 60;
	        sum.hour += 1;
	    }
	    if (sum.hour >= 240) {
	        sum.hour -= 24;
	    }
		return sum;
	}

	// non-static add method
	public Time add(Time t2) {
	    Time sum = new Time();
	    sum.hour = this.hour + t2.hour;
	    sum.minute = this.minute + t2.minute;
	    sum.second = this.second + t2.second;

	    if (sum.second >= 60.0) {
	        sum.second -= 60.0;
	        sum.minute += 1;
	    }
	    if (sum.minute >= 60) {
	        sum.minute -= 60;
	        sum.hour += 1;
	    }
	    if (sum.hour >= 240) {
	        sum.hour -= 24;
	    }
	    return sum;
	}
} // end Class