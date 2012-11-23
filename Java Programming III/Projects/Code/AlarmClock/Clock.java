import java.util.*;
/**
 *  Clock is a simple representation of an Alarm Clock
 *  @author Shannon Foss
 *  @version Date: Jan 24, 2012
 */
public class Clock {
	/** Clock hour - 0-11 */
	private int hour;	
	/** Clock minute - 0-59 */
	private int min;
	/** Clock second - 0-59 */
	private int sec;
	/** Part of day - am=true, pm=false */
	private boolean am;
	
	/** Alarm hour - 0-11 */
	private int almHour;
	/** Alarm minute - 0-59 */
	private int almMin;
	/** Alarm second - 0-59 */
	private int almSec;
	/** Part of day for alarm - am=true, pm=false */
	private boolean almAm;//true is am
	
	/** Alarm Set? Yes=true, no=false */
	private boolean alarmSet;//true is set
	
	/** Timer object - to count seconds */
	private Timer t;
	/** TimerTask object - to call the increment second method */
	private TimerTask task;
	
	/** Initializes clock and alarm to 00:00:00am. 
	 *	Initializes alarm to off. 
	 *	Creates a new timer and task.
	 *	Schedules the task to be performed once per second.
	 */
	public Clock(){
		hour = 0;
		min = 0;
		sec = 0;
		am = true;
		
		almHour = 0;
		almMin = 0;
		almSec = 0;
		almAm = true;
		alarmSet = false;
		t = new Timer();
		task = new TimerTask(){
			public void run(){
				incSec();
				displayTime();
				testAlarm();
			}
		};
		t.schedule(task,0, 1000);
	}
	/** Allows the clock's time to be set. 	 
	 * 	@param h	The hour the clock is going to be set to.
	 * 	@param m	The minute the clock is going to be set to.
	 * 	@param s	The second the clock is going to be set to.
	 * 	@param a	The part of the day the clock is going to be set to.
	 */
	public void setClock(int h, int m, int s, boolean a){
		hour = h;
		min = m;
		sec = s;
		am = a;
	}
	/** Allows the alarm's time to be set. 
	 * 	@param h	The hour the alarm is going to be set to.
	 * 	@param m	The minute the alarm is going to be set to.
	 * 	@param s	The second the alarm is going to be set to.
	 * 	@param a	The part of the day the alarm is going to be set to.
	 */
	public void setAlarm(int h, int m, int s, boolean a){
		almHour = h;
		almMin = m;
		almSec = s;
		almAm = a;
	}
	/** Turns the alarm on or off. */
	public void toggleAlarmSwitch(){
		alarmSet = !alarmSet;
	}
	/** Increments the seconds. */
	private void incSec(){
		sec++;
		if (sec == 60){
			sec = 0;
			min++;
			if (min == 60){
				min = 0;
				hour++;
				if(hour == 12){
					am = !am;
					hour=0;
				}
			}
		}
	}
	/** Tests to see if the alarm time has been reached. */
	private void testAlarm(){
		if(alarmSet && hour == almHour && min == almMin && sec == almSec && am == almAm){
			System.out.println("BEEP BEEP BEEP");
		}
	}
	/** Displays the formatted time. */
	public void displayTime(){
		System.out.print("The Time is: ");
		if(hour == 0){
			System.out.print("12:");
		}else{
			System.out.print(hour+":");
		}
		if(min < 10){
			System.out.print("0");
		}
		System.out.print(min+":");
		if(sec < 10){
			System.out.print("0");
		}
		System.out.print(sec+" ");
		if(am){
			System.out.println("am");
		}else{
			System.out.println("pm");
		}
	}
}
