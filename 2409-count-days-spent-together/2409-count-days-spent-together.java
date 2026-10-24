class Solution {
    private int finddays(String s , int[] cumMonthDays){
        int month = (s.charAt(0) -'0') * 10 + s.charAt(1) - '0';
        int days = (s.charAt(3)-'0') * 10 +s.charAt(4) - '0';

        return cumMonthDays[month-1] + days;

    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] cumMonthDays = new int[12];
        cumMonthDays[0] = 0;

        for( int i = 1; i < 12 ; i++){
            cumMonthDays[i] = cumMonthDays[i-1] + monthDays[i - 1];
        }

        int arriveA = finddays(arriveAlice , cumMonthDays);
        int leaveA = finddays(leaveAlice , cumMonthDays);
        int arriveB =  finddays(arriveBob , cumMonthDays);
        int leaveB = finddays(leaveBob , cumMonthDays);

        int ans = 0;
        ans = Math.min(leaveB , leaveA) - Math.max(arriveA , arriveB) + 1;

        return (ans < 0 ? 0 : ans);
    }
}