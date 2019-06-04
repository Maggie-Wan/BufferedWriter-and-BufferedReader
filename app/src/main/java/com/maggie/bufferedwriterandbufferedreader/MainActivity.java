package com.maggie.bufferedwriterandbufferedreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void write(View view) {
        String path = getFilesDir().getAbsolutePath();
        //File fname = new File(path + File.separator + "test.txt");
        String fname=path + File.separator + "test1.txt";
        try {
            FileWriter fw = new FileWriter(fname);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("happy to find you");
            bw.newLine();
            bw.write("it is sad");
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(View view) {
        String path = getFilesDir().getAbsolutePath();
        //File fname = new File(path + File.separator + "test.txt");
        String fname=path + File.separator + "test1.txt";
        try {
            FileReader fr = new FileReader(fname);
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str=br.readLine()) != null)
            {
                Log.d("FNAME", "Read:" + str);
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write2(View view) {
        int[] data = {4,1,7,3,4,8,2,1};
        StringBuilder sb = new StringBuilder();
        for (int i : data)
        {
            sb.append(i + ",");
        }
        String path = getFilesDir().getAbsolutePath();
        File fname = new File(path + File.separator + "test2.txt");
        try {
            FileWriter fw = new FileWriter(fname);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb.toString());
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void read2(View view) {
        String path = getFilesDir().getAbsolutePath();
        File fname = new File(path + File.separator + "test2.txt");
        ArrayList<Integer> mylist = new ArrayList();
        try {
            FileReader fr = new FileReader(fname);
            BufferedReader br = new BufferedReader(fr);
            String str;
            str = br.readLine();
            String strdata[] = str.split(",");
            for (String s : strdata)
            {
                if (s.length() > 0)
                {
                    mylist.add(Integer.valueOf(s));
                }
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i : mylist)
        {
            Log.d("FNAME", "data:" + i);
        }
    }
}
