public class ExcelSheetColumI {
    public String convertToTitle(int columnNumber) {
        String result="";
        int temp=columnNumber;
        while(temp!=0){
            char ch=(char)((temp-1)%26+65);
            result=ch+result;
            temp=(temp-1)/26;
        }

        return result;
    }
}
