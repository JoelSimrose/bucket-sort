//Joel Simrose
//Bucket Sort Algorithm
//December 3rd, 2018

import java.util.Random;
import java.util.*;
import java.lang.*;

public class BucketSort
{
	public static void main(String[] args)
	{

		int dataSize = 245760000;

		int[] array = RandomArrayGen(dataSize);

		int max = maxValue(array);

		//System.out.println("Before Sort: ");
		//printArray(array);

		long runTime = sort(array, max);

		//System.out.println("After Sort: ");
		//printArray(sortedArray);

		System.out.println("Data Size: " + dataSize);
		System.out.println("Runtime is: " + runTime);

	}

	/**
	*Sort input array using bucket sort
	*@param inputArray the array to be sorted 
	*@param n is the largest number in the array to know how to divide buckets
	*/
	public static long sort(int[] inputArray, int n)
	{	

		long startTime = PrintTime();

		//Create n buckets
		int[] bucketArray = new int[n + 1];
		int[] sortedArray = new int[inputArray.length];

		for(int i=0; i<inputArray.length; i++)
		{
			bucketArray[inputArray[i]]++;
		}

		int position = 0;

		for(int i=0; i<bucketArray.length; i++)
		{
			for(int j=0; j<bucketArray[i]; j++)
			{
				sortedArray[position++] = i;
			}
		}
	
		//printArray(sortedArray);

		long endTime = PrintTime();			//get the finishing run time
		long runTime = endTime - startTime;		//get total running time for selection sort

		return runTime;

	}
	/**
	*Prints the specified array to the terminal
	*@param array the array to be printed 
	*/
	public static void printArray(int[] array)
	{
		for(int i=0; i<array.length; i++)
		{
			System.out.print(array[i] + ",");
		}

		System.out.println("\n");
	}
	
	/**
	*This is a method to return the current time in milliseconds
	*/
	public static long PrintTime()
	{
		return System.currentTimeMillis();		//return current time 
	}

	/**
	*Takes in an array and finds the largest value 
	*@param inputArray the array to find the largest number
	*@return returns an integer which is the largest number
	*/
	public static int maxValue(int[] inputArray)
	{
		int maxValue = 0;

		for(int i=0; i<inputArray.length; i++)
		{
			if(inputArray[i] > maxValue)
			{
				maxValue = inputArray[i];
			}
		}

		return maxValue;
	}

	/**
	*Creates a random array of the specified size
	*@param size the size of random array to make 
	*@return returns an integer array of random numbers between 1 and 100
	*/
	public static int[] RandomArrayGen(int size)
	{
		int[] randArray = new int[size];	//initialize array

		for(int i=0; i<size; i++)	
		{
			
			Random number = new Random();		//get a random number and add it to the array
			randArray[i] = number.nextInt(100); 
		
		}

		return randArray;

	}

}
