package com.sopiana.yang.javaDecompiler.component.sub.cp_info;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class CONSTANT_String_info extends cp_info{
	private short string_index;
	
	public static CONSTANT_String_info getInstance(byte[] classFileData, int offset)
    {
		CONSTANT_String_info res = new CONSTANT_String_info();
		res.tag = classFileData[offset++];
		res.string_index = Util.byte2Short(classFileData,offset);
		return res;
    }
	public int getSize() { return 3; }
	public short getString_index(){ return string_index; }

}