import java.util.Arrays;

/**
 * Created by 154424 on 11/13/2018.
 */
public class TwoDArrays {

    //instance variables:
    private int[][] nums;

    public TwoDArrays(int[][] n){
        nums = n;
    }

    /*
    int[] numbs = new int[(int) Math.pow(nums.length, 2)];

        for(int r = 0; r < nums.length; r++){
            for (int c = 0; c < nums[0].length; c++){
                numbs[(nums[0].length * r) + c] = nums[r][c];
            }
        }
     */
    public int sum(){
        int sum = 0;
        for(int r = 0; r < nums.length; r++){
            for (int c = 0; c < nums[0].length; c++){
                sum += nums[r][c];
            }
        }
        return sum;
    }

    public boolean isSquare(){ return nums.length == nums[0].length; }

    public boolean inSequence(){
        if (!isSquare())
            return false;

        int[] numbs = new int[(int) Math.pow(nums.length, 2)];

        for(int r = 0; r < nums.length; r++){
            for (int c = 0; c < nums[0].length; c++){
                numbs[(nums[0].length * r) + c] = nums[r][c];
            }
        }
        for (int i = 0; i < numbs.length-1; i++){
            if (numbs[i] != numbs[i+1] - 1)
                return false;
        }
        return true;
    }

    public int[] closestToZero(){
        int[] r = new int[2];
        int c = 99999999;
        for (int x = 0; x < nums.length; x++) {
            for (int y = 0; y < nums[x].length; y++) {
                if(nums[x][y] < c) {
                    c = nums[x][y];
                    r[0] = x-1;
                    r[1] = y-1;
                }
            }
        }
        return r;
    }

    public void addMatrix(int[][] other){
        for(int r = 0; r < nums.length; r++){
            for (int c = 0; c < nums[0].length; c++){
                nums[r][c] += other[r][c];
            }
        }
        print();
    }

    private void print(){
        for(int[] i: nums){
            System.out.println(Arrays.toString(i));
        }
    }

    public boolean isValid(int x, int y){
        if(x >= 0 && x <= nums.length - 1){
            if (y >= 0 && y <= nums[x].length - 1){
                return true;
            }
        }
        return false;
    }

    public int columnSum(int c){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if (isValid(i, c)){
                sum++;
            }
        }
        return sum;
    }

    public boolean isColumnMagic(){
        boolean icm = true;
        int s = columnSum(0);
        for(int i = 1; i < nums[0].length; i++){
            if (columnSum(i)!= s){
                icm = false;
            }
        }
        return icm;

    }

    public boolean sameDiagonalSums(){
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i][i];
            sum2 += nums[i][(nums.length - i) - 1];
        }
        return sum1 == sum2;
    }

}





































