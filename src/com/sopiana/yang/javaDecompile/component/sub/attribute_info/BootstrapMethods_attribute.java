package com.sopiana.yang.javaDecompile.component.sub.attribute_info;

import com.sopiana.yang.javaDecompile.component.attribute_info;
import com.sopiana.yang.javaDecompile.component.decompilerException;
import com.sopiana.yang.javaDecompile.component.sub.bootstrap_methods_info;
import com.sopiana.yang.javaDecompile.util.Util;

public class BootstrapMethods_attribute extends attribute_info
{
	private short attribute_name_index;
	private int attribute_length;
	private short num_bootstrap_methods;
	private bootstrap_methods_info bootstrap_methods[];	//num_bootstrap_methods
	public static BootstrapMethods_attribute getInstance(short attribute_name_index, int attribute_length, byte[]info) throws decompilerException
 	{
 		int offset = 0;
 		BootstrapMethods_attribute res = new BootstrapMethods_attribute();
 		res.attribute_name_index = attribute_name_index;
 		res.attribute_length = attribute_length;
 		res.num_bootstrap_methods = Util.byte2Short(info,offset); offset+=2;
 		res.bootstrap_methods = new bootstrap_methods_info[res.num_bootstrap_methods];
 		for(int i=0;i<res.num_bootstrap_methods;++i)
 		{
 			res.bootstrap_methods[i] = bootstrap_methods_info.getInstance(info,offset);
 			offset+=res.bootstrap_methods[i].getSize();
 		}
 		return res;
 	}
	
}
