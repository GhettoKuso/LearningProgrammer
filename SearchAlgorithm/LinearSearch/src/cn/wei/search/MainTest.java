package cn.wei.search;

/**
 * @Author :sunwei
 * @Description:
 * @Date create in 22:34  2020/7/23
 * @Modified by:
 */
public class MainTest {

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int[] arr = new int[]{-1,5,8,7,4,2,6,6,7};

        int index = linearSearch.search(arr, 5);
        if(index==-1){
            System.out.println("can't find this target");
        }else{
            System.out.println("find target : "+index);
        }
    }
}
