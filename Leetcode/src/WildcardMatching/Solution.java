package WildcardMatching;

public class Solution {
	/*
Input:	"hi", "*?"
Output:	false
Expected:	true

=> 

pi < plen д�����棬�����������whileѭ�����ж����������������if����������һ����� ��pstart
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
��Ȼ�� p = "c*ab*c"��s = "cddabbac"Ϊ����

����p = "c*ab*c"�����ǿ��Բ����������ƥ���sӦ�ó��������� "c....ab.....c"��ʡ�Ժű�ʾ0���������ַ������Ƿ�����Ҫ����p���м��Ǹ�"ab"�Ƚ��鷳��һ��Ҫs�е�'ab'��ƥ�䣬���ֻҪs�м����һ��"ab"����ôһ�ж����Խ��������'*'�ˡ�

����˵�������ǰ����Ƚ�p��s�ϵ��ַ�ʱ������������p�ĵ�һ��'*'������ʵ��ֻ��Ҫ���ϵ���s��ʣ�ಿ���Һ�'ab'ƥ��Ĳ��֡�

����֮�����ǿ��Լ�¼������*ʱp��s��λ�ã���Ϊpresp��press��Ȼ�󰤸������Ƚ�*(++p)��*(++s)���������*p != *s���ͻ��ݻ�ȥ��p = presp��s = press+1, ++press��ֱ���Ƚϵ�ĩβ��������������һ��'*'�������������һ��'*'��˵�� "ab"���ָ㶨�ˣ�����ľͽ����ڶ���'*'�ˣ����p��s����ĩβ�ˣ���ô�ͷ���true�������ĩβ�˼�û�����µ�'*'���ֻ����ڲ�ƥ���ֵ��pressҲ�Ѿ���ĩβ�ˣ���ô�ͷ���false�ˡ�

������˼·������ĵݹ��������������������ڣ�

����'*'������ֻ����������һ��'*'ǰ�������⣬�����ǿ���һֱ��ĩβ�������⡣�Ӷ������������������㡣

����ͨ����¼ presp��press��ÿ�λ��ݵķ���������ʹ�õݹ顣
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
	 // ÿ�������ַ����ĵ�һ����ĸ�Ƚϣ���p�ĵ�һ����ĸ��*����һ����chop s��p����*ʣ�µ�recursive�Ƚϡ�
	 // p���Ǹ�*����ռ��s��0���ַ���1���ַ���2���ַ�����
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
