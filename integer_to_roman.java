import java.util.HashMap;

class Solution {
    public String intToRoman(int num) {
        int length = String.valueOf(num).length();
        HashMap<Integer, String> intConst = new HashMap<>();
        intConst.put(1, "I");
        intConst.put(5, "V");
        intConst.put(10, "X");
        intConst.put(50, "L");
        intConst.put(100, "C");
        intConst.put(500, "D");
        intConst.put(1000, "M");
        
        int[] arr = new int[length];
        int x = num;
        int i = 0;
        while(x != 0){
            int digit = x%10;
            arr[i] = digit;
            x = x/10;
            i++;
        }
        String finalVal = "";
        for(int j = length-1 ; j>=0 ; j--){
            String r = getRoman(arr[j], j, intConst);
            //System.out.println(arr[j]+ " - "+ r);
            finalVal +=r;
        }
        return finalVal;
    }

    private static String getRoman(int digit, int position, HashMap<Integer, String> intConst){
     String romanVal = "";
        int nrd = 0;
        switch(digit){
            case 2:
            case 3:
                nrd = (int)(1 * Math.pow(10, position));
                break;
            case 4:
            case 8:
            case 6:
            case 7:
                nrd = (int)(5 * Math.pow(10, position));
                break;
            case 9:
                nrd = (int)( 10 * Math.pow(10, position));
                break;
            case 1:
                nrd = 1;
        }
        String rom = intConst.get(nrd);
        //System.out.println("nearest rom:"+rom);
        //perform next operation
        switch(digit){
            case 2:
                romanVal = rom + rom;
                break;
            case 3:
                romanVal = rom + rom + rom;
                break;
            case 4:
                romanVal = intConst.get((int)(1*Math.pow(10,position))) + rom;
                break;
            case 5:
                romanVal = intConst.get((int)(5*Math.pow(10,position)));
                break;
            case 6:
                romanVal = rom + intConst.get((int)(1*Math.pow(10,position)))  ;
                break;
            case 7:
                romanVal = rom + intConst.get((int)(1*Math.pow(10,position)))  +  intConst.get((int)(1*Math.pow(10,position))) ;
                break;
            case 8:
                romanVal = rom + intConst.get((int)(1*Math.pow(10,position)))  + intConst.get((int)(1*Math.pow(10,position))) 
                + intConst.get((int)(1*Math.pow(10,position) ));
                break;
            case 9:
                romanVal = intConst.get((int)(1*Math.pow(10,position)))  + rom;
                break;
            case 1:
                romanVal = intConst.get((int)(1*Math.pow(10,position))) ;
                
        }
        
        
        
        return romanVal;
    }
}
