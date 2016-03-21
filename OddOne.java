package array.sample;

public class OddOne {

	public static void main(String[] args) {
		// Finding the non duplicate value
		int[] arr = {20,12,13,15,10,15,12,13,7,20,10};
		int length=arr.length;
		for (int i=0; i<length; i++){
			for(int j=0; j<length; j++){
				if(arr[i] > arr[j]){
					arr[i]=arr[i]+arr[j];
					arr[j]=arr[i]-arr[j];
					arr[i]=arr[i]-arr[j];
				}
			}
		}
		System.out.println("The array is : ");
		for(int a:arr){
			System.out.print(a + ",");
		}
	    for(int i=0;i<length;i+=2){
	    	if(arr[i] != arr[i+1])
			{
	    		System.out.println("\nThe unique number is : "+ arr[i]);
			}
	    	else
	    		System.out.println("\nThe unique number is : "+ arr[i]);
	    	/*if(i==length-1){
	    		System.out.println("\nThe unique number is : "+arr[i]);
	    		break;
	    	}
	    	if(arr[i] == arr[i+1]){
	    		i++;
	    	}
	    	else{
	    		System.out.println("\nThe unique number is : "+arr[i]);
	    		break;
	  	    	}*/
	    }
	}

}
