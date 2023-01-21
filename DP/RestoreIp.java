import java.util.ArrayList;
import java.util.List;

public class RestoreIp {
        public boolean isValid(String t){
            if(t.length()>3) return false;
            if(t.length()>1 && t.charAt(0)=='0') return false;
            int num=Integer.parseInt(t);
            if(num>=0 && num<=255) return true;
            return false;
        }

        public void restoreIp(String s,List<String> res,List<String> temp,int n,int index,int dotCount){

            if(index==n && dotCount==4){
                String t="";
                for(int j=0;j<temp.size();j++){
                    if(j==temp.size()-1){
                        t+=temp.get(j);
                    }else{
                        t+=temp.get(j)+".";
                    }
                }
                res.add(t);
                return;
            }

            if(dotCount>=4 && index<=n-1) return;


            for(int i=index;i<n;i++){
                String tempString=s.substring(index,i+1);
                if(isValid(tempString)){
                    temp.add(tempString);
                    restoreIp(s,res,temp,n,i+1,dotCount+1);
                    temp.remove(temp.size()-1);
                }
            }
        }

        public List<String> restoreIpAddresses(String s) {
            int n=s.length();
            List<String> res=new ArrayList<>();
            List<String> temp=new ArrayList<>();
            if(n>12) return res;
            restoreIp(s,res,temp,n,0,0);
            return res;
        }
}
