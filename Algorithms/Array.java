package LOO3;

import java.util.Scanner;

public class Array {
	
 private static Scanner scn= new Scanner(System.in) ;  
	
 	public static void main(String[] args) 
 	{  
	  int n=scn.nextInt()  ; 
	  int[] arr=input(n);
	  int[] arr1= new int[arr.length]; 
	  
	//  int element=scn.nextInt() ; 
      //System.out.println(linearsearch(arr, element));
	  //  reverse(arr) 
	    // inverse(arr, arr1);
	   
    	
//		inversetf(arr, arr1);
//		rotate(arr, arr1, 3);
//		display(arr1);
 	} 
    
 	public static int[] input(int n)
 	{   
 		int[] arr = new int[n] ;
 		
 		for(int i=0 ; i<n ; i++)
 		{ 
 			arr[i]=scn.nextInt() ;
 		}
 		return arr ; 
 	} 
 	
 	public static void display(int[] arr)
 	{ 
 		for(int i=0 ; i<arr.length  ;i++)
 		{ 	
 			System.out.print(arr[i]+" ");
 		} 		
 	}
 	 public static int linearsearch(int[] arr, int element)
 	 {  
 		for(int i=0 ;i<arr.length ;i++)
 		{ 
 			 if(arr[i]==element)
 			 { 
 				return i ;
 			 }
 		} 
 		 return -1 ; 
 	 } 
 	 public static void swap(int[] arr, int i ,int j)
 	 {	 int temp ; 
 		 temp=arr[i] ; 
 		 arr[i]=arr[j] ; 
 		 arr[j]=temp ; 
 		 
 	 }
 	 
 	 public static void reverse(int[] arr)
 	 {   int i= 0 ;
 	     int j= arr.length-1 ; 
 	     
 		 while(i<j)
 		 { 
 			 swap(arr,i,j) ; 
 			 i++ ; 
 			 j-- ; 
 		 } 		 
 	 }  
 	  
 	private static void inverse(int[] arr, int[] arr1) { 		//doubt

		for (int i = 0; i < arr.length; i++) {
			int index = arr[i];
			arr1[index] = i;
		}
	}
 	
 	private static boolean inversetf(int[] arr, int[] arr1) {
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i];
			if (arr1[index] != i) {
				return false;

			}
		}
		return true;
	}

	private static void rotate(int[] arr, int[] arr1, int m) {
		int mode = m % arr.length;

		int index = 0;
		for (int i = mode; i < arr.length; i++) {
			arr1[i - mode] = arr[i];
			index++;

		}

		for (int j = 0; j < mode; j++) {
			arr1[index] = arr[j];
			index++;
		}

	}

	private static int BinarySearch(int[] arr, int data) {

		int le = 0;
		int ri = arr.length - 1;
		while (le <= ri) {
			int mid = (le + ri) / 2;

			if (arr[mid] == data) {
				return mid;
			} else if (arr[mid] > data) {
				ri = mid - 1;
			} else if (arr[mid] < data) {
				le = mid + 1;
			}

		}
		return -1;
	}

	private static void BubbleSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {

				if (arr[j - 1] > arr[j])
					swap(arr, j - 1, j);

			}
		}

	}
    
	 private static void SelectionSort(int[] arr)
	 {  
		  
		 for(int i=0;i<arr.length;i++)
		 { 
			 for(int j=i+1;j<arr.length ;j++)
			 {  
				 if(arr[i]>arr[j])

					 swap(arr,i,j) ; 
			 }
			 
			 
		 }  
		  
	 } 
 	
	 
	 public static boolean inversef(int[] arr , int[] arr1 ){ 
		 
		 for(int i=0;i<arr.length ;i++)
		 {  
		     int index=arr[i] ; 
			 arr1[index]=i; 
			 
			 if(arr[i]!=arr1[i])
			 {  return false ; 
			 }
		
	     } 
		 return true ;
	
	 }

}
