import java.util.TreeMap;

class romanNum {
    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabKeyMap = new TreeMap<>();
    public romanNum() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);

        arabKeyMap.put(1, "I");
        arabKeyMap.put(4, "IV");
        arabKeyMap.put(5, "V");
        arabKeyMap.put(9, "IX");
        arabKeyMap.put(10, "X");
        arabKeyMap.put(40, "XL");
        arabKeyMap.put(50, "L");
        arabKeyMap.put(90, "XC");
        arabKeyMap.put(100, "С");
    }
    public boolean isRoman(String number) {
        return romanKeyMap.containsKey(number.charAt(0));
    }
    public String IntToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabKeyMap.floorKey(number);
            roman += arabKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;
    }
    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romanKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanKeyMap.get(arr[i]);
            if (arabian < romanKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}