package substringtest;

import java.util.HashMap;

public class MaxSubstring {
    static int solution(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0, res = 0;
        for (int j = 0; j < str.length(); j++){
            if (map.containsKey(str.charAt(j)))
                i = Math.max(i,map.get(str.charAt(j)));
            map.put(str.charAt(j), j + 1);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution("afasfaf"));
    }
}
