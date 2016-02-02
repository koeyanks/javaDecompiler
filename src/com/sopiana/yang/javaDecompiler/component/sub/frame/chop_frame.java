package com.sopiana.yang.javaDecompiler.component.sub.frame;

import com.sopiana.yang.javaDecompiler.component.cp_info;
import com.sopiana.yang.javaDecompiler.component.decompilerException;
import com.sopiana.yang.javaDecompiler.component.sub.stack_map_frame;
import com.sopiana.yang.javaDecompiler.util.Util;

public class chop_frame extends stack_map_frame
{
	private short offset_delta;
	public static chop_frame getInstance(byte[] classFileData, int offset) throws decompilerException
	{
		chop_frame res= new chop_frame();
		res.tag = classFileData[offset++];
		res.offset_delta = Util.byte2Short(classFileData,offset);
		return res;
	}
	
	public int getSize() { return 3; }
	public short getOffset_delta() { return offset_delta; }

	@Override
	public String toString(int indent, cp_info[] constant_pool) {
		// TODO Auto-generated method stub
		return null;
	}
}
