public class TrapingRainWater {

    public int trapingRain(int[] height){
        int n=height.length;
        int waterAmnt=0;
        int l=0,h=n-1;
        int lh=Integer.MIN_VALUE;
        int rh=Integer.MIN_VALUE;
        while(l<h){
            if(height[l]<=height[h]){
                if(lh<height[l]) lh=height[l];
                else waterAmnt+=lh-height[l];
                l++;
            }else{
                if(rh<height[h]) rh=height[h];
                else waterAmnt+=rh-height[h];
                h--;
            }
        }
        return waterAmnt;
    }
}
