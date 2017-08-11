package com.main.common.util;

import java.util.Date;
import java.util.Random;

/**
 *  随机字符串生成工具类 </p>
 */
public class RandomCharacter {
	/**
	 * 生成任务标志
	 */
	 public static String getRandomNumber(int length){
		 String str="0123456789";
		 Random random=new Random();
		 StringBuffer sb=new StringBuffer();
		 for(int i=0;i<length;i++){
		   int number=random.nextInt(10);
		   sb.append(str.charAt(number));
		 }
		 return sb.toString();
	 }

	 /**
	  * java生成随机数字和字母组�?
	  * length[生成随机数的长度]
	  */
	 public static String getCharAndNumr(int length) {
	  String val = "";
	  Random random = new Random();
	  for (int i = 0; i < length; i++) {
	   // 输出字母还是数字
	   String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
	   // 字符�?
	   if ("char".equalsIgnoreCase(charOrNum)) {
		// 取得大写字母还是小写字母
		int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
		val += (char) (choice + random.nextInt(26));
	   } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
		val += String.valueOf(random.nextInt(10));
	   }
	  }
	  return val;
	 }

	 /**
	  * 生成任务代码
	  */
	 public static String getRandomCode() {
		 String strRandon = getCharAndNumr(8);
		return DateUtil.format(new Date(), "yyyyMMddHHmmss")+strRandon;
	 }

	 public static void main(String[] args) {
			 System.out.println(getRandomCode());
		}

}
