package com.company;
import Classes.MyFloat;

public class Main
{
    public static void main(String args[])
    {
        MyFloat a = new MyFloat(12345, 2);
        MyFloat b = new MyFloat(56789, 3);

        a.sum(b);
    }
}
