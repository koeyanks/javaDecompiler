package com.sopiana.yang.javaDecompiler.instruction.byteCodes;

import com.sopiana.yang.javaDecompiler.instruction.instruction;
import com.sopiana.yang.javaDecompiler.instruction.instructionException;
import com.sopiana.yang.javaDecompiler.instruction.opcodeTable;

public class iload extends instruction
{
	public static final opcodeTable ins = opcodeTable._iload;
	private byte index;
	public static iload getInstance(byte[]codes, int offset) throws instructionException
	{
		if(codes[offset]!=ins.opcode)
			throw new instructionException("supplied code is not valid "+ins.mnemonic+" opcode");
		iload res = new iload();
		res.offset = offset;
		res.opcode = codes[offset++];
		res.index = codes[offset];
		return res;
	}
	public byte getIndex() { return index; }
	public byte[] getData() { return new byte[]{opcode,index}; }
	public int getSize() { return 2; }
	public String getMnemonic() { return ins.mnemonic; }
	
}