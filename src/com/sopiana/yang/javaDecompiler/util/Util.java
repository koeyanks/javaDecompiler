package com.sopiana.yang.javaDecompiler.util;

public class Util 
{
	public static short byte2Short(byte[] byteArr)
	{
		return byte2Short(byteArr, 0);
		
	}
	public static short byte2Short(byte[] byteArr,int offset)
	{
		return (short)(((byteArr[offset]&0xFF)<<8)|(byteArr[offset+1]&0xFF));
	}
	
	public static int byte2Int(byte[] byteArr)
	{
		return byte2Int(byteArr, 0);
	}
	
	public static int byte2Int(byte[] byteArr,int offset)
	{
		return (((byteArr[offset]&0xFF)<<24)|((byteArr[offset+1]&0xFF)<<16)|((byteArr[offset+2]&0xFF)<<8)|(byteArr[offset+3]&0xFF));
	}
	
	public static String byteArr2HexString(int[]byteArr)
	{
		String tempStr="";
		for(int i=0;i<byteArr.length;++i)
			tempStr+=String.format("%02x ", byteArr[i]);
		return tempStr;
	}
	
	public static String byteArr2HexString(byte[]byteArr)
	{
		String tempStr="";
		for(int i=0;i<byteArr.length;++i)
			tempStr+=String.format("%02X ", byteArr[i]);
		return tempStr;
	}
	
	public static String intArr2String(int[]intArr)
	{
		byte[] byteArr = new byte[intArr.length];
		for(int i=0;i<byteArr.length;++i)
			byteArr[i] = (byte)intArr[i];
		return new String(byteArr);
	}
	public static byte Char2Byte(char ch)
	{
		if((ch>='0')&&(ch<='9'))
			return (byte)(ch-'0');
		else
			return (byte)((ch-'a')+10);
	}
	
	public static short String2Short(String str)
	{
		str = str.toLowerCase().replace(" ", "");
		return (short)((Char2Byte(str.charAt(0))<<24)|(Char2Byte(str.charAt(1))<<16)|(Char2Byte(str.charAt(2))<<8)| Char2Byte(str.charAt(3)));
	}
	
	public static byte String2Byte(String str)
	{
		str = str.toLowerCase().replace(" ", "");;
		return (byte)((Char2Byte(str.charAt(0))<<4)|Char2Byte(str.charAt(1)));
	}
	
	public static byte[] String2ByteArray(String str)
	{
		str = str.replace(" " , "").toUpperCase();
		int len = str.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) 
	    {
	        data[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i+1), 16));
	    }
	    return data;
	}
	
	public static int arrayCopy(byte[]src, int srcOffset, byte[] dest, int destOffset, int length)
	{
		int i=0;
		try
		{
			for(;i<length;++i)
				dest[i+destOffset] = src[i+srcOffset];
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return i;
	}
	
	public static byte getHighByte(short s)
	{
		return (byte)((s&0xFF00)>>8);
	}
	
	public static byte getLowByte(short s)
	{
		return (byte)(s&0x00FF);
	}
	
	public static short getHighShort(int i)
	{
		return (short)((i&0xFFFF0000)>>16);
	}
	
	public static short getLowShort(int i)
	{
		return (short)(i&0x0000FFFF);
	}
	
	public static int intToByteArray(int i, byte[] dest, int offset)
	{
		short highShort = getHighShort(i);
		short lowShort = getLowShort(i);
		dest[offset++] = Util.getHighByte(highShort);
		dest[offset++] = Util.getLowByte(highShort);
		dest[offset++] = Util.getHighByte(lowShort);
		dest[offset++] = Util.getLowByte(lowShort);
		return offset+=4;
	}
	
	public static String getFieldDescriptor(String input)
	{
		String res="";
		boolean isArray = false;
		boolean isReference = false;
		int i=0;
		for(;i<input.length()&&!isReference;++i)
		{
			switch(input.charAt(i))
			{
				case'B':
					res+="byte";break;
				case 'C':
					res+="char";break;
				case 'D':
					res+="double";break;
				case 'F':
					res+="float";break;
				case 'I':
					res+="int";break;
				case 'J': 
					res+="long";break;
				case 'L':
					isReference = true; break;
				case 'S': 
					res+="short";break;
				case 'Z': 
					res+="boolean";break;
				case '[':
					res+="[]";
					isArray = true;
					break;
				default:
					break;
			}
		}
		if(isReference)
			res += input.substring(i).replace("/", ".").replace(";", "");
		if(isArray)
		{
			res = res.substring(res.lastIndexOf("]")+1)+res.substring(0, res.lastIndexOf("]")+1);
		}
		return res;
	}
}
