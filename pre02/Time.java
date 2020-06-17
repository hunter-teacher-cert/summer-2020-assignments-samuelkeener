import java.io.*;
import java.util.*;

public class Time {
	public static void main(String[] args){
		int hour = 11;
		int minute = 17;
		int second = 30;
		int secSinceMidnight = hour*3600+minute*60+second;
		System.out.println("Seconds since midnight: "+secSinceMidnight);
		int secRemaining = 86400-secSinceMidnight;
		System.out.println("Seconds remaining: "+secRemaining);
		double percentRemain = secSinceMidnight/86400.0;
		System.out.println("Percent of day passed: "+(percentRemain*100)+"%");
		hour = 11;
		minute = 21;
		second = 40;
		int tempSec = hour*3600+minute*60+second;
		int timePassed = tempSec - secSinceMidnight;
		System.out.println("Seconds worked on program: "+secSinceMidnight);
	}
}
		