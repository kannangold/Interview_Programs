package array.sample;

public class ArrangeNumbers_2 {
 public static void main(String[] args) {
	int[] arr = {20,14,13,15,10,5,2,3,4,1};
	int length=arr.length;
	for(int i=0;i<length;i++){
		for(int j=i;j<length;j++){
			if(arr[j]%2 == (i+1)%2){
			   	if(i==j){
			   		break;
			   	}
			   	else{
			   		arr[i]=arr[i]+arr[j];
			   		arr[j]=arr[i]-arr[j];
			   		arr[i]=arr[i]-arr[j];
			   		break;
			   	}
			}
		}
	}
	System.out.println("The array is : ");
	for(int a:arr){
		System.out.print(a + ",");
	}
 }
}



