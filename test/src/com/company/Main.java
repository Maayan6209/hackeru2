package com.company;

public class Main {

    public static void main(String[] args) {

        int [] arr={7,3,2,4,9,12,56};
        int [] arr2={1,2,3,4,5};
        int [][] arrmat={{-1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
       // t2(arrmat,6);
        int m=3;
        System.out.println(t2(arrmat,-1));
       // System.out.println(t1(arr,m));

    }
    static  int  t1(int []arr,int m){
        int min=Integer.MAX_VALUE;
        mergeSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length-m;i++)
            if(arr[i+m-1]-arr[i]<min)
                min=arr[i+m-1]-arr[i];
        return min;
    }
    static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        int i=0, j=0;
        int k = l;
        while (i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    static boolean tempt2(int[][] arr, int l, int r,int x,int i){
        int m=(r+l)/2;


        if(arr[i][m]==x)
            return true;
        if(l==r)
            return false;
        if(arr[i][m] > x)
            return tempt2(arr, l, m - 1, x, i);
        else
            return tempt2(arr, m + 1, r, x, i);
        /*if (arr[i][m] > x)
            tempt2(arr, l, m - 1, x, i);
        else {
            if (arr[i][m] < x)
                    tempt2(arr, m + 1, r, x, i);
                return true;
        }   */

    }
    static boolean t2(int [][] arr,int x){
        for(int i=0;i<arr.length;i++)
            if(arr[i][0]<=x&&arr[i][arr[i].length-1]>=x)
            {
                if(  tempt2(arr,0,arr.length-1,x,i))
                    return true;
            }
        return false;


    }
    static boolean t2good(int [][] arr,int x){

     /*   int i,j=arr.length-1;//לעבור על האלחסון( מהנקודה הימנית לשמאלית) ולבדוק אם גדול לבדוק רק את המשולש של הגדולים(מתחת לאלחסון) אם קטן לבדוק רק את המשולש של הקטנים (מעל האלחסון)
        //1 התחל באיבר בפינה הימנית העליונה של המטריצה
        //2 לולאה
        //אם שווים החזר את המיקום אחרת אם קטן
        for(i=0;i<arr.length;i++,j--)
        {

        }*/
        int n=arr.length;
        int i=0,j=n-1;
        while (i<j){

        }
        return false;

    }

}
