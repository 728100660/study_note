public class QuickSort {
    public static void main(String[] args) {
        int arrs[] = {12,3,34,3,67,54,2,8};
        quickSort(0,arrs.length-1,arrs);
        for(int num : arrs){
            System.out.println(num);
        }
    }

    public static void quickSort(int left, int right, int[] arrs) {

        if(left < right){
            int i = doSort(left, right, arrs);
            quickSort(i + 1, right, arrs);
            quickSort(left, i - 1, arrs);
        }
    }

    public static int doSort(int left, int right, int[] arrs) {
        int x = arrs[left];
        while (left < right) {
            while (left < right && arrs[right] >= x) right--;
//            如果left比right还小就说明  arrs[right] < x
            if(left < right){
                arrs[left] = arrs[right];
            }

            while (left < right && arrs[left] < x) left++;
            if(left < right){
                arrs[right] = arrs[left];
            }
        }
        arrs[left] = x;
        return left;
    }
}
