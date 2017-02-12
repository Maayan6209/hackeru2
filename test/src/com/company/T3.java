package com.company;

import java.util.Random;

/**
 * Created by hackeru on 2/12/2017.
 */
public class T3 {
    private int[] arr;
    private int size;
   static Random random = new Random(System.currentTimeMillis());
  public  int quickSelect(int[] arr, int l, int r, int k){
        if(k>0 && k <= r-l+1){
            int pos = randomizedPartition(arr, l, r);
            if(pos-l == k-1)
                return arr[pos];
            if(pos-l > k-1)
                return quickSelect(arr, l, pos-1, k);
            return quickSelect(arr, pos+1, r, k-pos+l-1);
        }
        return Integer.MAX_VALUE;

    }
    static int randomizedPartition(int[] arr, int low, int high){
        if(high == low)
            return low;

        int pos = random.nextInt(high-low) + low;
        int temp = arr[high];
        arr[high] = arr[pos];
        arr[pos] = temp;
        return partition(arr, low, high);
    }
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
    private void heapify(int i){
        int largest = i;
        int l = leftChild(i);
        int r = rightChild(i);
        if(l<size && arr[l] > arr[largest])
            largest = l;
        if(r<size && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(largest);
        }
    }
    private int leftChild(int i){
        return 2*i + 1;
    }

    private int rightChild(int i){
        return 2*i + 2;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private void bubbleUp(int i){
        int p;
        while(i != 0 && arr[(p=parent(i))] > arr[i]){
            int temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
            i = p;
        }
    }
    public void insert(int x){
    /*    if(size == arr.length){
            int[] temp = new int[size * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }*/
        //arr[size++] = x;
        int i = size;
        size++;
        arr[i] = x;
        bubbleUp(i);
    }

}
