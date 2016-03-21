package array.sample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindNonDuplicate {
	public static int findNonDuplicateWithHM(int data[]) // with use of HashMap
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : data)
		{
			if(map.containsKey((Integer)i))
			{
				map.put((Integer)i, (map.get((Integer)i)+ 1));
			}
			else
			{
				map.put((Integer)i, 1);
			}
		}
		if(map.containsValue(1))
		{
			for(Integer key : map.keySet())
			{
				if(map.get(key) == 1)
					return key.intValue();
			}
		}
		return -1;
	}
	public static int findNonDuplicateWithoutHM(int data[]) // without use of HashMap [Sorting]
	{
		for(int i=0; i<data.length;i++)
		{
			for(int j=i;j<data.length;j++)
			{
				if(data[i] > data[j])
				{
					data[i] = data[i] + data[j];
					data[j] = data[i] - data[j];
					data[i] = data[i] - data[j];
				}
			}
		}
		System.out.println(Arrays.toString(data));
		for(int i=0; i<data.length;i+=2)
		{
			if(i == data.length-1)
				return data[i];
			if(data[i] != data[i+1])
			{
				return data[i];
			}
		}
		return -1;
	}
	public static void main(String a[])
	{
		int data[] = {20,12,13,15,10,15,12,13,7,10,7};
		System.out.println(" Non Duplicate No With use of HashMap: "+ findNonDuplicateWithHM(data));
		System.out.println(" Non Duplicate No With out use of HashMap : "+ findNonDuplicateWithoutHM(data));
	}
}
