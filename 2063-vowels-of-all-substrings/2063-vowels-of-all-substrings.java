class Solution {
    public long countVowels(String word) {
        // traverse the word if element at index i not a vowel skip it
        // if it is vowel then we will find in how much substring it can contribute
        // it can start from any [position between 0 to i] so total start = i+1
        // it can end anywhere between n - i
        // hence no. of substrings = start * end ie (i+1) * (n- i)


        long count = 0;

        for( int i = 0 ; i < word.length() ; i++){
            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' ||  ch =='i' || ch == 'o' || ch == 'u'){

                long startpos = i + 1;
                long endpos = word.length() - i;

                count += startpos * endpos;

            }
        }

        return count;

    }
}