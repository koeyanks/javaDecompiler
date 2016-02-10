package com.sopiana.yang.javaDecompiler.component.sub.verification_type;

import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.verification_type_info;

public class Float_variable_info extends verification_type_info 
{
	public static final Float_variable_info getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		if(classFileData[offset]==ITEM_Float)
		{
			Float_variable_info res = new Float_variable_info();
			res.tag = ITEM_Float;
			return res;
		}
		throw new decompilerException("Arguments passed is not type of Float_variable_info");
	}

	public int getSize() { return 1; }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
