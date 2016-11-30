package com.vunke.sharehome.utils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


public class PinyinUtils {
	public static String getPinyin(String inputString) {

		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(null);//HanyuPinyinVCharType.WITH_U_UNICODE
		char[] input = inputString.trim().toCharArray();
		StringBuffer output = new StringBuffer("");

		try {
			for (int i = 0; i < input.length; i++) {
				if (Character.toString(input[i]).matches("[\u4E00-\u9FA5]+")) {
					String[] temp = PinyinHelper.toHanyuPinyinStringArray(
							input[i], format);
					output.append(temp[0]);
					output.append(" ");
				} else
					output.append(Character.toString(input[i]));
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return output.toString();
	}
	/**
	 * 根据传入的字符串(包含汉字),得到拼音
	 * 黑马 -> HEIMA
	 * 黑  马*& -> HEIMA
	 * 黑马f5 -> HEIMA
	 * @param str 字符串
	 * @return
	 */
	/*public static String getPinyin(String str) {
		
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		
		StringBuilder sb = new StringBuilder();
		
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			// 如果是空格, 跳过
			if(Character.isWhitespace(c)){
				continue;
			}
			if(c >= -127 && c < 128){
				// 肯定不是汉字
				sb.append(c);
			}else {
				String s = "";
				try {
					// 通过char得到拼音集合. 单 -> dan, shan 
					s = PinyinHelper.toHanyuPinyinStringArray(c, format)[0];
					sb.append(s);
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
					sb.append(s);
				}
			}
		}
		
		return sb.toString();
	}*/
	 /**
     * 得到指定汉字的拼音
     * 注意:不应该被频繁调用，它消耗一定内存
     */
    public static String getPinYin(String hanzi){
        String pinyin = "";
         
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();//控制转换是否大小写，是否带音标
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);//大写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
         
        //由于不能直接对多个汉字转换，只能对单个汉字转换
        char[] arr = hanzi.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(Character.isWhitespace(arr[i]))continue;//如果是空格，则不处理，进行下次遍历
             
            //汉字是2个字节存储，肯定大于127，所以大于127就可以当为汉字转换
            if(arr[i]>127){
                try {
                    //由于多音字的存在，单 dan shan
                    String[] pinyinArr = PinyinHelper.toHanyuPinyinStringArray(arr[i], format);
                     
                    if(pinyinArr!=null){
                        pinyin += pinyinArr[0];
                    }else {
                        pinyin += arr[i];
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                    //不是正确的汉字
                    pinyin += arr[i];
                }
            }else {
                //不是汉字，
                pinyin += arr[i];
            }
        }
        return pinyin;
    }
	/** 
     * 汉字转换为汉语拼音首字母，英文字符不变 
     * 花花大神->hhds 
     * @param chinese 汉字 
     * @return 拼音 
     */  
    public static String getFirstSpell(String chinese) {  
         StringBuffer pybf = new StringBuffer();  
         char[] arr = chinese.toCharArray();  
         HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
         defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
         defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
         for (char curchar : arr) {  
                if (curchar > 128) {  
                        try {  
                                String[] temp = PinyinHelper.toHanyuPinyinStringArray(curchar, defaultFormat);  
                                if (temp != null) {  
                                        pybf.append(temp[0].charAt(0));  
                                }  
                        } catch (BadHanyuPinyinOutputFormatCombination e) {  
                                e.printStackTrace();  
                        }  
                } else {  
                        pybf.append(curchar);  
                }  
        }  
         return pybf.toString().replaceAll("\\W", "").trim();  
    }  
	/**
	 * 取sort_key的首字母
	 * 
	 * @param sortKey
	 * @return
	 */
	public static String getSortLetterBySortKey(String sortKey) {

		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

		String sb = "";
		char[] charArray = sortKey.toCharArray();

		char c = charArray[0];
		// 如果是空格, 跳过
		if (Character.isWhitespace(c)) {
			sb = "#";
		}
		if (c >= -127 && c < 128) {
			// 肯定不是汉字
			// sb.append(c);
			sb = Character.toString(c);
		} else {
			String s = "";
			try {
				// 通过char得到拼音集合. 单 -> dan, shan
				s = PinyinHelper.toHanyuPinyinStringArray(c, format)[0];
				// sb.append(s);
				sb = s;
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
				// sb.append(s);
				sb = s;
			}
		}
		if (sortKey == null || "".equals(sortKey.trim())) {
			return null;
		}
		sb = Character.toString(sb.charAt(0));
		if (sb.matches("[A-Z]")) {

			return sb;
		} else {
			return "#";
		}

	}
	  /**
     * 将字符串转换成拼音数组
     *
     * @param src
     * @return
     */
    public static String[] stringToPinyin(String src) {
        return stringToPinyin(src, false, null);
    }
    /**
     * 将字符串转换成拼音数组
     *
     * @param src
     * @return
     */
    public static String[] stringToPinyin(String src,String separator) {
        return stringToPinyin(src, true, separator);
    }

    /**
     * 将字符串转换成拼音数组
     *
     * @param src
     * @param isPolyphone
     *            是否查出多音字的所有拼音
     * @param separator
     *            多音字拼音之间的分隔符
     * @return
     */
    public static String[] stringToPinyin(String src, boolean isPolyphone,
                                          String separator) {
        // 判断字符串是否为空
        if ("".equals(src) || null == src) {
            return null;
        }
        char[] srcChar = src.toCharArray();
        int srcCount = srcChar.length;
        String[] srcStr = new String[srcCount];

        for (int i = 0; i < srcCount; i++) {
            srcStr[i] = charToPinyin(srcChar[i], isPolyphone, separator);
        }
        return srcStr;
    }

    /**
     * 将单个字符转换成拼音
     *
     * @param src
     * @return
     */
    public static String charToPinyin(char src, boolean isPolyphone,
                                      String separator) {
        // 创建汉语拼音处理类
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出设置，大小写，音标方式
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        StringBuffer tempPinying = new StringBuffer();


        // 如果是中文
        if (src > 128) {
            try {
                // 转换得出结果
                String[] strs = PinyinHelper.toHanyuPinyinStringArray(src,
                        defaultFormat);


                // 是否查出多音字，默认是查出多音字的第一个字符
                if (isPolyphone && null != separator) {
                    for (int i = 0; i < strs.length; i++) {
                        tempPinying.append(strs[i]);
                        if (strs.length != (i + 1)) {
                            // 多音字之间用特殊符号间隔起来
                            tempPinying.append(separator);
                        }
                    }
                } else {
                    tempPinying.append(strs[0]);
                }

            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            tempPinying.append(src);
        }

        return tempPinying.toString();

    }

    /**
     * 将字符串数组转换成字符串
     * @param str
     * @param separator 各个字符串之间的分隔符
     * @return
     */
    public static String stringArrayToString(String[] str, String separator) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
            if (str.length != (i + 1)) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
    /**
     * 简单的将各个字符数组之间连接起来
     * @param str
     * @return
     */
    public  static String stringArrayToString(String[] str){
        return stringArrayToString(str,"");
    }
    /**
     * 将字符数组转换成字符串
     * @param ch
     * @param separator 各个字符串之间的分隔符
     * @return
     */
    public static String charArrayToString(char[] ch, String separator) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
            if (ch.length != (i + 1)) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }

    /**
     * 将字符数组转换成字符串
     * @param ch
     * @return
     */
    public static String charArrayToString(char[] ch) {
        return charArrayToString(ch," ");
    }

    /**
     * 取汉字的首字母
     * @param src
     * @param isCapital 是否是大写
     * @return
     */
    public static char[]  getHeadByChar(char src,boolean isCapital){
        //如果不是汉字直接返回
        if (src <= 128) {
            return new char[]{src};
        }
        //获取所有的拼音
        String []pinyingStr=PinyinHelper.toHanyuPinyinStringArray(src);

        //创建返回对象
        int polyphoneSize=pinyingStr.length;
        char [] headChars=new char[polyphoneSize];
        int i=0;
        //截取首字符
        for(String s:pinyingStr){
            char headChar=s.charAt(0);
            //首字母是否大写，默认是小写
            if(isCapital){
                headChars[i]=Character.toUpperCase(headChar);
            }else{
                headChars[i]=headChar;
            }
            i++;
        }

        return headChars;
    }
    /**
     * 取汉字的首字母(默认是大写)
     * @param src
     * @return
     */
    public static char[]  getHeadByChar(char src){
        return getHeadByChar(src,true);
    }
    /**
     * 查找字符串首字母
     * @param src
     * @return
     */
    public  static String[] getHeadByString(String src){
        return getHeadByString( src, true);
    }
    /**
     * 查找字符串首字母
     * @param src
     * @param isCapital 是否大写
     * @return
     */
    public  static String[] getHeadByString(String src,boolean isCapital){
        return getHeadByString( src, isCapital,null);
    }
    /**
     * 查找字符串首字母
     * @param src
     * @param isCapital 是否大写
     * @param separator 分隔符
     * @return
     */
    public  static String[] getHeadByString(String src,boolean isCapital,String separator){
        char[]chars=src.toCharArray();
        String[] headString=new String[chars.length];
        int i=0;
        for(char ch:chars){

            char[]chs=getHeadByChar(ch,isCapital);
            StringBuffer sb=new StringBuffer();
            if(null!=separator){
                int j=1;

                for(char ch1:chs){
                    sb.append(ch1);
                    if(j!=chs.length){
                        sb.append(separator);
                    }
                    j++;
                }
            }else{
                sb.append(chs[0]);
            }
            headString[i]=sb.toString();
            i++;
        }
        return headString;
    }
   
}
