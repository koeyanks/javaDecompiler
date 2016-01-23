package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.util.Util;

public class EnclosingMethod_attribute extends attribute_info
{
	private short class_index;
	private short method_index;
	public static EnclosingMethod_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info)
	{
		int offset = 0;
		EnclosingMethod_attribute res = new EnclosingMethod_attribute();
		res.attribute_name_index = attribute_name_index;
		res.attribute_length = attribute_length;
		res.class_index = Util.byte2Short(info);offset+=2;
		res.method_index = Util.byte2Short(info, offset);
		return res;
		
	}
	public static EnclosingMethod_attribute getInstance(attribute_info attrib)
	{
		return getInstance(attrib.getAttribute_name_index(), attrib.getAttribute_length(), attrib.getInfo());
	}
	public short getClass_index() { return this.class_index; }
	public short getMethod_index(){ return this.method_index; }
}