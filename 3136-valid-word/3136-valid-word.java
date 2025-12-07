class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) 
            return false;

        boolean foundVowel = false, foundConstant = false;

        for(char ch : word.toCharArray())
        {
            if(Character.isLetter(ch))
            {
                if(isVowel(ch))
                {
                    foundVowel = true;
                }
                else
                {
                    foundConstant = true;
                }
            }
            else if(!Character.isDigit(ch))
            {
                return false;
            }
        }
        return foundConstant && foundVowel;
    }

    public boolean isVowel(char ch)
    {
        return "AIEOUaeiou".indexOf(ch) != -1;
    }
}