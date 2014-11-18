package com.jagex.runescape;

/*
 * This file is part of the RuneScape client
 * revision 317, which was publicly released
 * on the 10th of April 2006.
 * 
 * This file has been refactored in order to
 * restore readability to the codebase for
 * educational purposes, primarility to those
 * with an interest in game development.
 * 
 * It may be a criminal offence to run this
 * file. This file is the intellectual property
 * of Jagex Ltd.
 */

public final class  Varp {

    public static void load(Archive archive)
    {
        Stream stream = new Stream(archive.getFile("varp.dat"));
        anInt702 = 0;
        int cacheSize = stream.getUnsignedLEShort();
        if(cache == null)
            cache = new Varp[cacheSize];
        if(anIntArray703 == null)
            anIntArray703 = new int[cacheSize];
        for(int j = 0; j < cacheSize; j++)
        {
            if(cache[j] == null)
                cache[j] = new Varp();
            cache[j].readValues(stream, j);
        }
        if(stream.currentOffset != stream.buffer.length)
            System.out.println("varptype load mismatch");
    }

    private void readValues(Stream stream, int i)
    {
        do
        {
            int opcode = stream.getUnsignedByte();
            if(opcode == 0)
                return;
            if(opcode == 1)
                 stream.getUnsignedByte();
            else
            if(opcode == 2)
                stream.getUnsignedByte();
            else
            if(opcode == 3)
                anIntArray703[anInt702++] = i;
            else
            if(opcode == 4) { } // dummy
            else
            if(opcode == 5)
                type = stream.getUnsignedLEShort();
            else
            if(opcode == 6) { } // dummy
            else
            if(opcode == 7)
                stream.getInt();
            else
            if(opcode == 8)
                aBoolean713 = true;
             else
            if(opcode == 10)
                 stream.getString();
            else
            if(opcode == 11)
                aBoolean713 = true;
            else
            if(opcode == 12)
                stream.getInt();
            else
            if(opcode == 13) { } // dummy
            else
                System.out.println("Error unrecognised config code: " + opcode);
        } while(true);
    }

    private Varp()
    {
        aBoolean713 = false;
    }

    public static Varp cache[];
    private static int anInt702;
    private static int[] anIntArray703;
    public int type;
    public boolean aBoolean713;

}
