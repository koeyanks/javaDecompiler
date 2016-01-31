package com.sopiana.yang.javaDecompiler.component.sub.attribute_info;

import com.sopiana.yang.javaDecompiler.component.attribute_info;
import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.parameters_info;

public class MethodParameters_attribute extends attribute_info
{
	private byte parameters_count;
	private parameters_info parameters[];	//parameters_count
	public static MethodParameters_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException
 	{
 		int offset = 0;
 		MethodParameters_attribute res = new MethodParameters_attribute();
 		res.attribute_name_index = attribute_name_index;
 		res.attribute_length = attribute_length;
 		res.parameters_count = info[offset++];
 		res.parameters = new parameters_info[res.parameters_count&0xFF];
 		for(int i=0;i<res.parameters_count;++i)
 		{
 			res.parameters[i] = parameters_info.getInstance(info,offset);
 			offset+=res.parameters[i].getSize();
 		}
 		return res;
 	}
	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
