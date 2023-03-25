public class ExcelSheetColumII {
    public int titleToNumber(String columnTitle) {
        int n=columnTitle.length();
        int j=0,op=0;
        for(int i=n-1;i>=0;i--){
            int v=columnTitle.charAt(i)-65+1;
            op+=(v)*((int)Math.pow(26,j));
            j++;
        }

        return op;
    }
}
