/* 	Author: Shannon Foss
	Date: Jan 24, 2012
	Program: TestAlarm.java - Tester for Clock class.
	Desc: Example of writing a class.
*/
public class TestAlarm {
	public static void main(String[] args) {
		Clock c = new Clock();
		c.setClock(12, 0, 0, true);
		c.setAlarm(12, 1, 0, true);
		c.toggleAlarmSwitch();
	}
}
/*Output
The Time is: 12:00:01 am
The Time is: 12:00:02 am
The Time is: 12:00:03 am
The Time is: 12:00:04 am
...
The Time is: 12:00:59 am
The Time is: 12:01:00 am
BEEP BEEP BEEP
The Time is: 12:01:01 am
...
*/