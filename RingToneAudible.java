package array.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RingToneAudible {
	static List<Integer> silentSeconds = new ArrayList<Integer>();
	static List<Integer> ringingSeconds = new ArrayList<Integer>();
	public static void main(String[] args) {
		System.out.println("Enter the no.of Songs : ");
		@SuppressWarnings("resource")
		Scanner scr = new Scanner(System.in);
		int noSongs = scr.nextInt();
		System.out.println("Enter the Song Duration in seconds : ");
		scr = new Scanner(System.in);
		int duration = scr.nextInt();
		System.out.println("Enter the Song waiting time to play next song in seconds : ");
		scr = new Scanner(System.in);
		int waitingTime = scr.nextInt();
		System.out.println("Enter the Ring Delay in seconds : ");
		scr = new Scanner(System.in);
		int ringDelay = scr.nextInt();
		
		silent(noSongs,waitingTime,duration);
		ringTime(noSongs, duration, waitingTime, ringDelay);
		displayAnswer();
	}
	public static void silent(int noSongs, int waitingTime, int duration)
	{
		int m = 0;
		for(int i=0;i<noSongs;i++)
		{
			m = m + duration;
			for(int j=0;j<waitingTime;j++)
			{
				silentSeconds.add(m);
				m++;
			}
		}		
	}
	public static void ringTime(int noSongs, int duration, int waitingTime, int ringDelay)
	{
		int t = noSongs * duration;
		int t1 = noSongs * waitingTime;
		int total = t * t1;
		int y = total / ringDelay;
		int kk = 1;
		for(int i=0;i<y;i++)
		{
			ringingSeconds.add(kk);
			kk = kk + ringDelay;
		}
	}
	public static void displayAnswer()
	{
		System.out.println("Ringing Seconds : " + ringingSeconds);
		System.out.println("Silent Seconds : " + silentSeconds);
		for(int i=0;i<silentSeconds.size();i++)
		{
			for(int j=0;j<ringingSeconds.size();j++)
			{
				if(silentSeconds.get(i) == ringingSeconds.get(j))
					System.out.println(ringingSeconds.get(j) + " th Second We will hear the ring");
			}
		}
	}
}
