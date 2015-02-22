package WildcardMatching;

public class Solution {
	/*
Input:	"hi", "*?"
Output:	false
Expected:	true

=> 

pi < plen 写在里面，不是最外面的while循环的判断条件，而是里面的if的条件，万一到最后 回pstart
	 */
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        if(plen == 0 && slen > 0) return false; /////////////
        
        int pstart = -1;
        int sstart = -1;
        int si = 0;
        int pi = 0;
        while(si < slen){
            if( pi < plen && p.charAt(pi) == '*' ){
                while( pi < plen && p.charAt(pi) == '*') pi++;
                pstart = pi;
                sstart = si;
            }
            else{
                if( pi < plen && (p.charAt(pi) == '?' || p.charAt(pi) == s.charAt(si)) ){
                    pi++;
                    si++;
                }
                else if(pstart == -1) return false;
                else{
                    pi = pstart;
                    si = ++sstart;
                }
            }
        }
        if( ( pi == plen && si == slen) || (pi == plen && p.charAt(pi-1) =='*') ) return true;
        
        if(si == slen){
            while(pi < plen && p.charAt(pi) =='*') pi++;
            return pi == plen;
        }
        return false;
    }
	// http://www.cnblogs.com/felixfang/p/3708999.html
	// http://yucoding.blogspot.com/2013/02/leetcode-question-123-wildcard-matching.html
	// https://oj.leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution
	
	
	// not linear time really, but the code is elegant and can pass large set test cases
	// The complexity is O(p*s), where p and s are the lengths of the pattern and input strings. 
	// An example of such a worst-case input is:
	//	input: bbbbbbbbbbbb pattern: *bbbb

	//This is actually DFS back tracking. what the pointers do is to save the DFS nodes and back track.

/*
 * The basic idea is to have one pointer for the string and one pointer for the pattern. This algorithm iterates at most length(string) + length(pattern) times, for each iteration, at least one pointer advance one step.
Analysis:

For each element in s
If *s==*p or *p == ? which means this is a match, then goes to next element s++ p++.
If p=='*', this is also a match, but one or many chars may be available, so let us save this *'s position and the matched s position.
If not match, then we check if there is a * previously showed up,
       if there is no *,  return false;
       if there is an *,  we set current p to the next element of *, and set current s to the next saved s position.


 */
	/*
依然以 p = "c*ab*c"，s = "cddabbac"为例。

对于p = "c*ab*c"，我们可以猜想出它可以匹配的s应该长成这样： "c....ab.....c"，省略号表示0到任意多的字符。我们发现主要就是p的中间那个"ab"比较麻烦，一定要s中的'ab'来匹配，因此只要s中间存在一个"ab"，那么一切都可以交给后面的'*'了。

所以说，当我们挨个比较p和s上的字符时，当我们遇到p的第一个'*'，我们实际只需要不断地在s的剩余部分找和'ab'匹配的部分。

换言之，我们可以记录下遇到*时p和s的位置，记为presp和press，然后挨个继续比较*(++p)和*(++s)；如果发现*p != *s，就回溯回去，p = presp，s = press+1, ++press；直到比较到末尾，或者遇到了下一个'*'，如果遇到了下一个'*'，说明 "ab"部分搞定了，下面的就交给第二个'*'了；如果p和s都到末尾了，那么就返回true；如果到末尾了既没遇到新的'*'，又还存在不匹配的值，press也已经到末尾了，那么就返回false了。

这样的思路和上面的递归比起来，最大的区别就在于：

遇到'*'，我们只考虑遇到下一个'*'前的子问题，而不是考虑一直到末尾的子问题。从而避免大量的子问题计算。

我们通过记录 presp和press，每次回溯的方法，避免使用递归。
	 */
	public boolean isMatchOld(String s, String p) {
		int curS = 0;
		int curP = 0;
		int starTargetP = -1;
		int toMatchPS = -1;
		while(curS < s.length()){
			// advancing both pointers
			if( curP < p.length() && (p.charAt(curP) == s.charAt(curS) || p.charAt(curP) == '?') ){
	             curS++;
	             curP++;
			}
			// * found, only advancing pattern pointer
			else if( curP < p.length() && p.charAt(curP) == '*' ){
				while(curP < p.length() && p.charAt(curP) == '*'){
					curP++;
				}
				if(curP == p.length()) return true;// have or not. both ok~
				starTargetP = curP;
				toMatchPS = curS;
			}
			////////////////////// CANNOT HAVE else if(curP == p.length()) return false;
			// found * before, then not match yet then r was *, advancing string pointer
			else if(starTargetP != -1){
				curP = starTargetP;
				curS = ++toMatchPS;
			}
			// characters do not match
			// current pattern pointer is not star, 
			// last pattern pointer was not *     
			else return false;
		}
		// check for remaining characters in pattern
		while( curP < p.length() && p.charAt(curP) == '*') curP++;
		return curP == p.length();
		
	}
	
	
	
	
	
	
	// recursive (and dp) time limit
	 public boolean isMatchRECURSIVE(String s, String p) {
	     return dfs(s,0,p,0);
	 }
	 // 每次两个字符串的第一个字母比较，若p的第一个字母是*，则一点点的chop s和p除了*剩下的recursive比较。
	 // p的那个*可以占用s的0个字符，1个字符，2个字符。。
	 public boolean dfs(String s, int ss, String p, int ps){
	     if(ss == s.length() && ps == p.length()) return true;
	     if(ps == p.length()) return false;
	     if(ss == s.length()){
	         if(p.charAt(ps) == '*') return dfs(s, ss, p, ps+1);
	         else return false;
	     } 
	     char c = p.charAt(ps);
	     if(c == s.charAt(ss) || c == '?'){
	         return dfs(s,ss+1,p,ps+1);
	     }
	     if(c == '*'){
	         // * for many || for 1 || for 0
	         // return dfs(s,ss+1,p,ps) ||dfs(s,ss+1,p,ps+1) || dfs(s,ss,p,ps+1) ;
	         // Last executed input:	"aaabababaaabaababbbaaaabbbbbbabbbbabbbabbaabbababab", 
	         //                         "*ab***ba**b*b*aaab*b"
	    	 while(ps < p.length() && p.charAt(ps) == '*') ps++;
	         if(ps == p.length()) return true;
	         for(int i = ss; i < s.length(); i++){
	             if(dfs(s,i,p,ps)) return true;
	         }
	         // Last executed input:	"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", 
	         //                         "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"

	     }
	     return false;
	 }
}
