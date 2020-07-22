import java.io.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Time t = new Time();
		System.out.println(t);
		Time time = new Time(11, 59, 59.9);
		System.out.println(time.getHour());

		time = new Time(11, 59, 59.9);
		System.out.println(time);

		time = new Time(11, 59, 59.9);
		String s = time.toString();
		System.out.println(s);

		Time time1 = new Time(9, 30, 0.0);
		Time time2 = time1;
		Time time3 = new Time(9, 30, 0.0);

		System.out.println(time1.equals(time3));

		Time startTime = new Time(18, 50, 0.0);
		Time runningTime = new Time(2, 16, 0.0);
		Time endTime = Time.add(startTime, runningTime);
		System.out.println(endTime);

		endTime = startTime.add(runningTime);
		System.out.println(endTime);

	} // end main
} // end Class