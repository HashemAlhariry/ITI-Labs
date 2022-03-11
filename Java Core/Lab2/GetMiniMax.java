class GetMiniMax {

    public static void main(String[] args) {

        int [] arr= new int [100000];
        for(int i=0;i<100000;i++){
            arr[i]= (int)(Math.random() * 100000);

        }
        long firstTime =System.nanoTime();
        bubbleSort(arr);
        long secondtime =System.nanoTime();
        System.out.println("time taken to sort " + ( (secondtime-firstTime) / 1000 ));

        firstTime =System.nanoTime();
        binarySearch(arr,0,999,800);
        secondtime =System.nanoTime();
        System.out.println("time taken to search number 800 using binary search " + ( (secondtime-firstTime) / 1000));

        /*
        for(int i=0;i<1000;i++) {
            System.out.println(arr[i]+" ");
        }
        */
    }

    static void  bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    static int binarySearch(int arr[], int left, int right, int x)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, left, mid - 1, x);

            return binarySearch(arr, mid + 1, right, x);
        }
        return -1;
    }

}

