package com.sopiana.yang.javaDecompile.component.sub.target_info;

public class type_parameter_target_info extends target_info
{
	private byte type_parameter_index;
	public static type_parameter_target_info getInstance(byte[]classFileData, int offset)
	{
		type_parameter_target_info res = new type_parameter_target_info();
		res.type_parameter_index = classFileData[offset];
		return res;
	}
	public int getSize() { return 1; }
	public byte getType_parameter_index() { return type_parameter_index; }
}
