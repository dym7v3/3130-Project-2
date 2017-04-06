
import java.util.ArrayList; //Will be used to have an array of arrays 
import java.util.Random; //Will be used to generate random numbers. 




public class QuickSort {

	//Will be used to count comparisions and swaps that have in the quick sort function. 
	static int swap=0;
	static int compare=0;
	
	//Will be used to calculate the time required to run the function.
	static long endTime;
	static long startTime;
	
	public static void main(String [] args)
	{
		//Three different array one is going to have the 1000 elements randomized.
		//The other one will be in descending order and the last one in ascending order. 
		int [] ran_array= new int[1000];
		int [] desArray= new int [1000];
		int [] ascArray= new int [1000];
		
		//This is a list of arrays that will hold four separate copies of the random array. 
		ArrayList<int[]> listofArrays = new ArrayList<int[]>();
		
		//This will get the randomize array back after calling this function.
		ran_array=random();
		
		//This will have the descending array filled with descending elements and the 
		//ascending array will have it filled with the elements from 1-1000.
		desArray=descending();
		ascArray=ascending();
		
		//Adds the same random array 4 times for the four different functions. 
		for(int p=0; p<4; p++){
			int [] copy= new int[1000];
			int [] copy1=new int[1000];
			int [] copy2=new int[1000];
			//This performs a deep copy. 
			for(int i=0; i<copy.length; i++)
			{
				copy[i]=ran_array[i];
				copy1[i]=desArray[i];
				copy2[i]=ascArray[i];
			}
			
			//This adds the copy to the list of arrays.
			listofArrays.add(copy);
			listofArrays.add(copy1);
			listofArrays.add(copy2);
		}
		

		//Prints the unsorted array, in other words the randomized array.
		System.out.println("The unsorted array.\n");
		print(listofArrays.get(0));
		
		
		System.out.println("This is sorted array when we use original quicksort!\n");
		
		//this runs the original quick sort on the random array. and shows the results. 
		startTime=System.nanoTime();
		quickSort(listofArrays.get(0), (listofArrays.get(0).length-1),0 );
		endTime=System.nanoTime();
		
		print(listofArrays.get(0));
		
		//This will display the statistics. 
		System.out.println("\t Statistics for Orginal Quicksort:\n");
		System.out.println("Random Array Comparisions: "+compare+" Random Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");

		reset();
		
		//this runs the original quick sort on the Descending array. and shows the results. 
		startTime=System.nanoTime();
		quickSort(listofArrays.get(1), (listofArrays.get(1).length-1),0);
		System.out.println("Descending Array Comparisions: "+compare+" Descending Array Swaps: "+swap);
		endTime=System.nanoTime();
		
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();

		//this runs the original quick sort on the ascending array. and shows the results. 
		startTime=System.nanoTime();
		quickSort(listofArrays.get(2), (listofArrays.get(2).length-1),0);
		endTime=System.nanoTime();
		System.out.println("Ascending Array Comparisions: "+compare+" Ascending Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
		//This will run the randomized quick sort on the 3 arrays.
		
		System.out.println("This is sorted array when we use Randomization quicksort!\n");
		
		//this runs the randomized quick sort on the random array. and shows the results. 
		startTime=System.nanoTime();
		quickSortRandom(listofArrays.get(3), (listofArrays.get(3).length-1),0 );
		endTime=System.nanoTime();
		print(listofArrays.get(3));
		
		//This will display the statistics. 
		System.out.println("\tStatistics for Randomization Quicksort:\n");
		System.out.println("Random Array Comparisions: "+compare+" Random Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
		
		//this runs the randomized quick sort on the Descending array. and shows the results. 
		startTime=System.nanoTime();
		quickSortRandom(listofArrays.get(4), (listofArrays.get(4).length-1),0);
		endTime=System.nanoTime();
		System.out.println("Descending Array Comparisions: "+compare+" Descending Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
		
		//this runs the randomized quick sort on the ascending array. and shows the results. 
		startTime=System.nanoTime();
		quickSortRandom(listofArrays.get(5), (listofArrays.get(5).length-1),0);
		endTime=System.nanoTime();		
		
		System.out.println("Ascending Array Comparisions: "+compare+" Ascending Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
		
		//This will run the Median of Three quick sort on the 3 arrays.
		
		System.out.println("This is sorted array when we use The Median of Three quicksort!\n");

		//this runs the Median of Three quick  sort on the random array. and shows the results. 
		startTime=System.nanoTime();
		quickSortMedianofThree(listofArrays.get(6), (listofArrays.get(3).length-1),0 );
		endTime=System.nanoTime();
		print(listofArrays.get(6));
				
		
		//This will display the statistics. 
		System.out.println("\tStatistics for Median of Three Quicksort:\n");
		System.out.println("Random Array Comparisions: "+compare+" Random Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
		
		//this runs the Median of Three quick sort on the Descending array. and shows the results. 
		startTime=System.nanoTime();
		quickSortMedianofThree(listofArrays.get(7), (listofArrays.get(7).length-1),0);
		endTime=System.nanoTime();
		System.out.println("Descending Array Comparisions: "+compare+" Descending Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
		
		//this runs the Median of Three quick sort on the ascending array. and shows the results. 
		startTime=System.nanoTime();
		quickSortMedianofThree(listofArrays.get(8), (listofArrays.get(8).length-1),0);
		endTime=System.nanoTime();				
		System.out.println("Ascending Array Comparisions: "+compare+" Ascending Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
		
		
		System.out.println("This is sorted array when we use The Median of Five quicksort!\n");

		//this runs The Median of Five  quick sort on the random array. and shows the results. 
		startTime=System.nanoTime();
		quickSortMedianofFive(listofArrays.get(9), (listofArrays.get(9).length-1),0 );
		endTime=System.nanoTime();
		print(listofArrays.get(9));
				
				
		//This will display the statistics. 
		System.out.println("\tStatistics for Median of Five Quicksort:\n");
		System.out.println("Random Array Comparisions: "+compare+" Random Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
		
		//this runs The Median of Five  quick sort on the Descending array. and shows the results. 
		startTime=System.nanoTime();
		quickSortMedianofFive(listofArrays.get(10), (listofArrays.get(10).length-1),0);
		endTime=System.nanoTime();
		System.out.println("Descending Array Comparisions: "+compare+" Descending Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();		
		//this runs the Median of Three quick sort on the ascending array. and shows the results. 
		startTime=System.nanoTime();
		quickSortMedianofFive(listofArrays.get(11), (listofArrays.get(11).length-1),0);
		endTime=System.nanoTime();				
		System.out.println("Ascending Array Comparisions: "+compare+" Ascending Array Swaps: "+swap);
		System.out.println("It took: "+(endTime-startTime)+" nanoseconds to run that function!\n");
		
		reset();
	}
	
	
	//used to fill a 1000 element array will random elements. 
	//This function generates random numbers between 1-1000.
	public static int [] random()
	{
		//creates an thousand element array which will be filled with integers between
		//1-1000.
		int [] array= new int[1000];
		
		//This will be used to generate the random numbers. The class random'
		Random r = new Random();
		int Low = 1;
		int High = 1000;
			
		//This will fill the array with random numbers between 1-1000.
		for(int i=0; i<array.length; i++)
			array[i] = r.nextInt(High-Low) + Low;
		
		return array; //Returns the thousand element array.
	}
	
	//used to print an array of any size. 
	//The print function. 
	public static void print(int [] array)
	{
		int count=0;
		
		for(int i=0; i<array.length; i++)	
		{
			
			//If the count is 20 then it will put the numbers on a new line.
			if(count==20)
			{
				System.out.println();
				count=0; //resets the count 
			}
			System.out.print(array[i]+","); //This prints a number and a comma in between the numbers. 
			count++; //This adds one to the count until it reaches 20 then it adds a new line. 
			
		}
		//This will print an two spaces between the sorted and unsorted array. 
		System.out.println("\n");
	}

	//the original quick sort. 
	//This is the original quick-sort function.
	public static void quickSort(int[] array,  int highest, int lowest) {
	
		
		//This will check if the array is empty or its length is 0 which would still make
		//it empty. 
		if (array == null || array.length == 0)
			return; //Automatically returns the array and doesn't move forward in the function. 
 
		//This checks if the lowest is greater than or equal to highest then it will automatically 
		//return the array. This two checks are required for the quick-sort to work.
		if (lowest >= highest)
			return;
 
		
	    //picks the last element as the pivot
		int pivot = array[highest];
 
		//Sets the lower element to left and the higher element to right. 
		int left = lowest;
		int right = highest;
		
		
		while (left <= right) 
		{
			compare++;
			while (array[left] < pivot) 
			{
				
				left++;
			}
			compare++;
			while (array[right] > pivot)
			{
				
				right--;
			}
			
			//This swaps the two elements. To make 
			//sure the elements that are smaller then the pivot are on the right and
			//elements that are greater then the pivot are on the right.
			compare++;
			if (left <= right) 
			{
				
				swap++;
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		
		} //closing brace for the while loop. 
 
		// recursively sort two sub parts
		if (lowest < right)
			quickSort(array, right, lowest);
 
		
		if (highest > left)
			quickSort(array,highest, left);
	}

	// the quick sort with randomization. 
	//This is the original quick-sort function.
	public static void quickSortRandom(int[] array,  int highest, int lowest) {
			
			//This will check if the array is empty or its length is 0 which would still make
			//it empty. 
			if (array == null || array.length == 0)
				return; //Automatically returns the array and doesn't move forward in the function. 
	 
			//This checks if the lowest is greater than or equal to highest then it will automatically 
			//return the array. This two checks are required for the quick-sort to work.
			if (lowest >= highest)
				return;
	 
			
			//This generates a random num which will be used as the index for the pivot element. 
			Random num= new Random();
			int range=highest - lowest +1;
			
			
		    //picks a random index in he range of the sub array. 
			int pivot =array[num.nextInt(range)+lowest];
	 
			//Sets the lower element to left and the higher element to right. 
			int left = lowest;
			int right = highest;
			
			
			while (left <= right) 
			{
				compare++;
				while (array[left] < pivot) {
					left++;
					
				}
				compare++;
				while (array[right] > pivot) {
					right--;
					
				}
				
				//This swaps the two elements. To make 
				//sure the elements that are smaller then the pivot are on the right and
				//elements that are greater then the pivot are on the right.
				compare++;
				if (left <= right) {
					int temp = array[left];
					array[left] = array[right];
					array[right] = temp;
					left++;
					right--;
					
					swap++;
				}
			
			} //closing brace for the while loop. 
	 
			// recursively sort two sub parts
			if (lowest < right)
				quickSortRandom(array, right, lowest);
	 
			
			if (highest > left)
				quickSortRandom(array,highest, left);
		}
	
	//used to generate an array with that has ascending order. 
	//This produces an array with ascending order. 
	public static int [] ascending()
		{
			int[] array= new int[1000];
			
			for(int i=0; i<1000; i++)
				array[i]=i+1;
			
			return array; //the array. 
		}
	
	//used to generate an array with descending order. 
	//this produces an array with descending order.
	public static int [] descending()
	{
		int [] array=new int [1000];
		
		//this will store in the 1000 element array the descending order.
		for(int i=0; i<1000; i++)
			array[i]=1000-i;
		
		return array; // this returns a ordered array with descending order. 
	}
	
	//function used to find the median of three elements. 
	//this method find the median of 3. 
	public static int medThree(int[] array,  int highest, int lowest)
	{
		//This randomly generates numbers to randomly select from the pivot element.
		Random ran = new Random();
		int [] index= new int[3]; //creates an array later will be use to find the pivot
		
		int number=ran.nextInt((highest - lowest) + 1) + lowest;
		
		//Fills up the newly created array will -1 ones. 
		for(int i=0; i<index.length; i++)
			index[i]=-1;
		
	
		//This generates random number and makes sure they are not the same 
		//because they will be used to get the index in the array. 
		for(int j=0; j<index.length; j++)
		{	
			//if the index generated by the random number is the same as 
			//any other index then it will generate another index and try again. 
			while(index[0]==number || index[1]==number || index[2]==number)
			{
				number=ran.nextInt((highest - lowest) + 1) + lowest;
			}
			
			//After it generates a random index number that that is not the
			//same as the other indices it will save it in the 3 element array.
			index[j]=number;
		}
		
		//This find the median of the three elements by using subtraction. 
		// index 1 >= index 2 and index 1 <= index 3 OR index 1 <= index 2 and index 1 >= index 3
		compare++;
		if ( (array[index[0]] - array[index[1]]) * (array[index[2]] - array[index[0]]) >= 0 ) 
		{
			  return array[index[0]]; //returns the pivot element. it will return index 1
		}
	      
		
		compare++;
		// index 2 >= index 1 and index 2 <= index 3 OR index 2 <= index 1 and index 2 >= index 3
		if ( (array[index[1]] - array[index[0]]) * (array[index[2]] - array[index[1]]) >= 0 ) 
		{
			
			 return array[index[1]]; //returns the pivot element. returns index 2 then
		}
	       
	    //otherwise it will return index 3. 
	        return array[index[2]];//returns the 
		
		
	}
	
	//This will do quick sort with the median of three. 
	public static void quickSortMedianofThree(int[] array,  int highest, int lowest) {
		
		//This will check if the array is empty or its length is 0 which would still make
		//it empty. 
		if (array == null || array.length == 0)
			return; //Automatically returns the array and doesn't move forward in the function. 
 
		//This checks if the lowest is greater than or equal to highest then it will automatically 
		//return the array. This two checks are required for the quick-sort to work.
		if (lowest >= highest)
			return;
 
		//This will check the size of the sub-array.
		int size=highest-lowest+1;
		
		
		//If the size is less then 2 then we will just sort it directly. 
		if(size==2)
		{
			//This will sort the two elements in the array. 
			//if the first element is bigger then the second then they will be swapped. 
			compare++;
			if(array[lowest]>array[lowest+1])
			{
				swap++;
				int temp=array[lowest];
				array[lowest]=array[lowest+1];
				array[lowest+1]=temp;
				return;	
			
			}
			
		}
		else if(size<=1)
		{
			return;//This will do nothing if the array size is one. 
		}
		else
		{
	    //picks a pivot that will will be chosen from a median of three elements. 
		int pivot = medThree(array, highest, lowest);
 
		//Sets the lower element to left and the higher element to right. 
		int left = lowest;
		int right = highest;
		
		//This will organize the elements to be either on the left or right side of the 
		//pivot element. 
		while (left <= right) 
		{
			compare++;
			while (array[left] < pivot) 
			{
				
				left++;
			}
			compare++;
			while (array[right] > pivot) {
				right--;
			}
			
			//This swaps the two elements. To make 
			//sure the elements that are smaller then the pivot are on the right and
			//elements that are greater then the pivot are on the right.
			compare++;
			if (left <= right) {
				swap++;
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		
		} //closing brace for the while loop. 
 
		// recursively sort two sub parts
		if (lowest < right)
			quickSortMedianofThree(array, right, lowest);
 
		
		if (highest > left)
			quickSortMedianofThree(array,highest, left);
		}
	}
	
	//function will find the median of five elements in an array. 
	//This will find a median of 5 and return the median of five as the pivot element. 
	public static int findMedianOfFive(int [] array, int highest, int lowest)
	{
		//This randomly generates numbers to randomly select from the pivot element.
		Random ran = new Random();
		int [] index= new int[5]; //creates an array later will be use to find the pivot
	
		//generates a random number and between the highest and lowest index and stores it in 
		//number later to be stored in index array as long as it doesn't match any of the other indices. 
		int number=ran.nextInt((highest - lowest) + 1) + lowest;
		
		//stores the median of 5 elements. 
		int median;
		
		//Fills up the newly created array will -1 ones. 
		for(int i=0; i<index.length; i++)
		index[i]=-1;
	

		//This generates random number and makes sure they are not the same 
		//because they will be used to get the index in the array. 
		for(int j=0; j<index.length; j++)
		{	
		//if the index generated by the random number is the same as 
		//any other index then it will generate another index and try again. 
		while(index[0]==number || index[1]==number || index[2]==number || index[3]==number || index[4]==number)
		{
			number=ran.nextInt((highest - lowest) + 1) + lowest;
		}
		
		//After it generates a random index number that that is not the
		//same as the other indices it will save it in the 3 element array.
		index[j]=number;
		}

	
		//this will copy five elements which will be selected from the bigger array into the index array.
		for(int i=0; i<index.length; i++)
		{
			index[i]=array[index[i]];
		} 
	
		//This goes through a series of comparisons to find the median of five elements.
		compare++;
		
        if (index[0] > index[1]) //Comparison #1
        {
        	swap(index,0,1);
        	 swap++;
        }
       
        compare++;
        if (index[2] > index[3]) //Comparison #2
        {
        	swap++;
        	swap(index,2,3);
        }
        	
        compare++;
        if (index[0] > index[2]) //Comparison #3
        { 
        	swap++;
        	swap(index,1,3);
            index[2] = index[0];
        }

        //This gets the fifth element and gets rid of the 1 element because it is not needed anymore. 
        index[0] = index[4];
        compare++;
        if (index[0] > index[1]) //Comparison #4
        {
        	swap++;
        	swap(index,0,1);
        }
        	
        compare++;
        if (index[2] > index[0]) //Comparison #5
        { 
        	swap++;
        	swap(index,1,3);
            index[0] = index[2];
        }
        compare++;
        if (index[3] > index[0]) //Comparison #6
            median = 0;
        
        else 
            median = 3;
        

        //returns the median back to the caller. 
        return index[median];
	
	}
	
	//This will do the quick sort with a median of five.
	//This will do quickSort with the median of 5.
	public static void quickSortMedianofFive(int [] array, int highest, int lowest)
	{
		
		//This will check if the array is empty or its length is 0 which would still make
		//it empty. 
		if (array == null || array.length == 0)
			return; //Automatically returns the array and doesn't move forward in the function. 
		 
		//This checks if the lowest is greater than or equal to highest then it will automatically 
		//return the array. This two checks are required for the quick-sort to work.
		if (lowest >= highest)
			return;
		 
		//This will check the size of the sub-array.
		int size=highest-lowest+1;
				
		if(size==4)
		{
			//This will do selection sort.
			for (int i = lowest; i < lowest+4; i++)
			{
			  int index = i;
			    for (int j = i + 1; j < lowest+4; j++)
			    {	compare++;
			    	if (array[j] < array[index])
			              index = j;
			    }  
			       int smallerNumber = array[index]; 
			       array[index] = array[i];
			       array[i] = smallerNumber;
			       swap++;
			}
				return;
		}
		else if(size==3)
		{
		//This will do selection sort.
			for (int i = lowest; i < lowest+3; i++)
			 {
			     int index = i;
			     for (int j = i + 1; j < lowest+3; j++)
			      {
			    	 compare++;
			    	 if (array[j] < array[index])
			            index = j;
			      }
			       
			     swap++;
			     int smallerNumber = array[index]; 
			       array[index] = array[i];
			       array[i] = smallerNumber;
			  }
				return;
		}
		else if(size==2)
				{
					//This will sort the two elements in the array. 
					//if the first element is bigger then the second then they will be swapped. 
					compare++;
					if(array[lowest]>array[lowest+1])
					{
						swap++;
						int temp=array[lowest];
						array[lowest]=array[lowest+1];
						array[lowest+1]=temp;
								
					}
					
					return;
		}
		else if(size<=1)
		{
					return;//this just does nothing. 
		}
		else
		{		
		//picks a pivot that will will be chosen from a median of three elements. 
		int pivot = findMedianOfFive(array, highest, lowest);
		 
		//Sets the lower element to left and the higher element to right. 
		int left = lowest;
		int right = highest;
				
		//This will organize the elements to be either on the left or right side of the 
		//pivot element. 
				while (left <= right) 
				{
					compare++;
					while (array[left] < pivot) 
					{
						left++;
					}
					compare++;
					while (array[right] > pivot) {
						right--;
					}
					
					//This swaps the two elements. To make 
					//sure the elements that are smaller then the pivot are on the right and
					//elements that are greater then the pivot are on the right.
					compare++;
					if (left <= right) {
						int temp = array[left];
						array[left] = array[right];
						array[right] = temp;
						left++;
						right--;
						swap++;
					}
				
				} //closing brace for the while loop. 
		 
				// recursively sort two sub parts
				if (lowest < right)
					quickSortMedianofFive(array, right, lowest);
		 
				
				if (highest > left)
					quickSortMedianofFive(array,highest, left);		
		}
	}
	//this will be my swap function. 
	
	//swap function will be used when find the median of five. 
	public static void swap(int[]a,int i,int j)
	{
		int temp=a[i];
		a[i]= a[j];
		 a[j]=temp;
	}
	
	//functions will reset the start time and the endtime and the compare and swap variables to zero. 
	public static void reset()
	{
		compare=0;
		swap=0;
		startTime=0;
		endTime=0;
	}
}
