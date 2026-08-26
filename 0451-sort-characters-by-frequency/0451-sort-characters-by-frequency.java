class Solution {
    public String frequencySort(String s) {
        // First approach (HashMap + Sorting)
        Map<Character , Integer> map = new HashMap<>();

        for( char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch ,0) + 1);
        }

        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a, b) -> map.get(b) - map.get(a)); // syntax to sort in decreasing order using Lambda Expressions

        StringBuilder sb = new StringBuilder();
        for( char ch : chars){
            int freq = map.get(ch);

            while( freq-- > 0){
                sb.append(ch);
            }
        }

        return sb.toString();

    }
}