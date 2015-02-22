package Candy;

import java.util.Arrays;

public class Solution {
	public int candyShort(int[] ratings) {
        if(ratings==null){
        	return 0;
        }        
        int[] num = new int[ratings.length];
        Arrays.fill(num, 1);
        //+1 if increasing        
        for (int i = 0; i < ratings.length-1; i++){
        	if (ratings[i+1]>ratings[i]){
        		num[i+1] = num[i]+1;
        	}
        }
        // backward+1; sum
        int sum = num[ratings.length-1];
        for (int i = ratings.length-1; i >0 ; i--){
        	if (ratings[i-1]>ratings[i]){
        		num[i-1]= Math.max (num[i-1],num[i]+1);
        	}
        	sum += num[i-1];
        }
        return sum;
    }
    public int candy(int[] ratings) {
        if(ratings==null){
        	return 0;
        }        
        if(ratings.length==1){
        	return 1;
        }
        int[] num = new int[ratings.length];
        Arrays.fill(num, 0);
        // find local min ratings
        if(ratings[0] <= ratings[1]){
        	num[0] = 1;
        }
        if(ratings[ratings.length-1 ] <= ratings[ratings.length-2]){
        	num[ratings.length-1 ] = 1;
        }
        for(int i = 1; i < ratings.length-1; i++){
        	if(ratings[i] <= ratings[i-1] && ratings[i] <=ratings[i+1]){
        		num[i]=1;
        	}
        }
        //+1 if increasing        
        int i = 0;
        while(num[i]!=1){
        	i++;
        }
        int cur=num[i];
        for(; i < ratings.length-1;i++){
        	if(num[i+1]==1){
        		cur =1;
        	}
        	else if(ratings[i+1]>ratings[i]){
        		num[i+1]=++cur;
        	}
        }
        // backward+1
        i = ratings.length-1;
        while(num[i]!=1){
        	i--;
        }
        cur=num[i];
        for(; i > 0;i--){
        	if(num[i-1]==1){
        		cur =1;
        	}
        	else if(ratings[i-1]>ratings[i]){
        		cur = Math.max (num[i-1],++cur);
        		num[i-1]=cur;
        	
        	}
        }
        cur = 0;
        for(i = 0; i < ratings.length; i++){
        	cur += num[i];
        }
        return cur;
        
    }
}
