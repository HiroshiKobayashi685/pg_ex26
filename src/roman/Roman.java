package roman;

public class Roman {

	// ローマ数字を数値に変換する
	public int to_number(String str) {

		String pattern = "^M{0,3}(CM|D|CD)?C{0,3}(XC|L|XL)?X{0,3}(IX|V|IV)?I{0,3}?$";

		if (str.matches(pattern)){
		}else{
			throw new IllegalStateException("ローマ数字として正しくありません");
		}

	    int number = 0;
	    int pre = 0;

	    int size = str.length() -1 ;
	    while(size >= 0){
	    	char ch = str.charAt(size);
	    	int num = roman_to_number(ch);
	    	if(num >= pre){
	    		number += num;
	    		pre = num;
	    	}else{
	    		number -= num;
	    	}
	    	size--;
	    }

		return number;
	}

	private int roman_to_number(char ch) {
		int number = 0;
		if (ch == 'M')return number=1000;
		if (ch == 'D')return number=500;
		if (ch == 'C')return number=100;
		if (ch == 'L')return number=50;
		if (ch == 'X')return number=10;
		if (ch == 'V')return number=5;
		if (ch == 'I')return number=1;
		return number;

	}

	public String to_roman(int number) {

		String roman;

		if (number < 1 || 3999 < number){
			return "範囲外です";
		}

		int m = number / 1000;
	    number %= 1000;
	    int  c = number / 100;
	    number %= 100;
	    int x = number / 10;
	    number %= 10;
	    int i = number;

	    roman = number_to_roman(m, "M", "", "");
	    roman += number_to_roman(c, "C", "D", "M");
	    roman += number_to_roman(x, "X", "L", "C");
	    roman += number_to_roman(i, "I", "V", "X");

		return roman;

	}

	private String number_to_roman(int i , String one, String five,String ten){

		if (i == 0) return "";
		if (i == 1) return one;
		if (i == 2) return one + one;
		if (i == 3) return one + one + one;
		if (i == 4) return one + five;
		if (i == 5) return five;
		if (i == 6) return five + one;
		if (i == 7) return five + one + one;
		if (i == 8) return five + one + one +one;
		if (i == 9) return one + ten;
		return "";
	}

}
