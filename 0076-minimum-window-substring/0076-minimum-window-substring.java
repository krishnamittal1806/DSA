class Solution {
    public String minWindow(String s, String t) {
        int l = 0; int h = 0; int minlen = Integer.MAX_VALUE; int startindex = -1; int count = t.length();

        HashMap<Character , Integer> map = new HashMap<>();

        for( char ch : t.toCharArray()){
            map.put(ch , map.getOrDefault(ch ,0) + 1);
        }

        while( h < s.length()){
            char c = s.charAt(h);

            if(map.containsKey(c)){
                if(map.get(c) > 0) count --;
                map.put ( c, map.get(c) - 1 );
            }

            while( count == 0){
                if(h-l+1 < minlen){
                    minlen = h-l+1;
                    startindex = l;
                }

                char left = s.charAt(l);
                if(map.containsKey(left)){
                    map.put(left , map.get(left) + 1);
                    if(map.get(left) > 0) count++;
                }
                l++;
            }
            h++;
        }

        return (startindex == -1) ? "" : s.substring(startindex , minlen +startindex);
    }
}