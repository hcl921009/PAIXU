public class Main {

    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        sortCharuXier(a);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void sortCharuZhijie(int[] a){
        for (int i=1;i<a.length;i++){
            int temp = a[i];
            int j;
            for(j = i-1;j>=0;j--){
                if(a[j]>temp){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = temp;
        }
    }

    public static void sortCharuErfen(int[] a){
        for(int i = 0;i<a.length;i++){
            int left = 0;
            int right = i-1;
            int mid = 0;
            int temp = a[i];
            while (left < right){
                mid = (right + left)/2;
                if(temp<a[mid]){
                    right = mid-1;/*mid如果不减一，则边界总是在最后相邻的状态永远不变，成为死循环*/
                }else {
                    left = mid-1;
                }

            }
            for(int j = i-1;j>=left;j--){
                a[j+1] = a[j];
            }
            if(left !=i){
                a[left] = temp;
            }

        }
    }

    public static void sortCharuXier(int[] a){
        int d = a.length;
        while(true){
            d = d/2;
            for(int x=0;x<d;x++){/*按照间距为d的元素为一组，分组后得到的组数为d*/
                for(int i=x+d;i<a.length;i=i+d){/*遍历每组的数据,直接插入排序*/
                    int temp = a[i];
                    int j;
                    for(j = i-d;j>0&&a[j]>temp;j=j-d){
                        a[j+d] = a[j];
                    }
                    a[j+d] = temp;
                }
            }
            if (d == 1){
                break;
            }
        }
    }

}
