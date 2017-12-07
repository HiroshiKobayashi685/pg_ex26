package roman;

import java.util.Arrays;

public class Daiji {

	String[] num1s = new String[]{"", "壱", "弐" ,"参", "肆", "伍", "陸", "漆","捌", "玖"};
	String[] num2s = new String[]{"", "" ,  "弐", "参", "肆", "伍", "陸", "漆","捌", "玖"};
	String[] digits = new String[]{"","拾", "佰", "仟"};

	public int to_number(String daiji) {

		String pattern = "^([弐参肆伍陸漆捌玖]?仟)?([弐参肆伍陸漆捌玖]?佰)?([弐参肆伍陸漆捌玖]?拾)?([壱弐参肆伍陸漆捌玖]?)$|^零$";
		if (daiji.matches(pattern)){
		}else{
			throw new IllegalStateException("大字として正しくありません");
		}

		if (daiji == "零")return 0;

		int number = 0;
	    number += _to_number_one(daiji);
	    for(int rank = 1; rank <= digits.length; rank++){
	    	number += _to_number(daiji,rank);
	    }
	    return number;

	}

    //壱の位の大字を数値に変換する'''
	private int _to_number_one(String result){
        if (Arrays.asList(num1s).contains(result)){
            return Arrays.asList(num1s).indexOf(result) ;
        }
        return 0;
	}

	//位ごとの大字を数値に変換する
	private int _to_number(String result, int digit){

		int index = digits.length - digit;

		if(Arrays.asList(num1s).contains(index)){
			if( result ==digits[index]){
				return (int) Math.pow(10, digit);
			}else{
				int val = Arrays.asList(num1s).indexOf(result) ;
				int num = Arrays.asList(num1s).indexOf(val) ;
				return (int) (num * Math.pow(10, digit));
			}
		}else{
			return 0;
		}
	}

	public String to_daiji(int number) {

		System.out.println("number:"+number);

		if (number < 0 || 9999 <number) return "範囲外です";
		if (number == 0)return "零";

	    String daiji="";
	    int digit = String.valueOf(number).length()-1;

	    while(digit>0){
	    	int num = (int) (number / Math.pow(10, digit));
	    	daiji += num2s[num];
	    	if(num != 0){
	    		daiji += digits[digit];
	    	}
	    	number = (int) (number % Math.pow(10, digit));
	    	digit--;
	    }
	    daiji += num1s[number];
		return daiji;
	}

}
