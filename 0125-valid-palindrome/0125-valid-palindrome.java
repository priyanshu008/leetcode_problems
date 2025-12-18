class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();
        s = s.toLowerCase();
        for(char a: s.toCharArray()){
            if(Character.isLetterOrDigit(a)){st.append(a);}
        }
        String orig = st.toString();
        String rev = st.reverse().toString();
        if (orig.equals(rev)){
            return true;
        }else{
            return false;
        }
        
    }
}