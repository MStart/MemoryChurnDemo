package com.huxian.memorychurn;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_memory_churn_coming).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imPrettySureSortingIsFree();
            }
        });
        findViewById(R.id.btn_memory_churn_where).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changedImPrettySureSortingIsFree();
            }
        });
    }

    private void imPrettySureSortingIsFree() {
        int dimension = 300;
        int[][] lotsOfInts = new int[dimension][dimension];
        Random randomGenerator = new Random();
        for (int i = 0; i < lotsOfInts.length; i++) {
            for (int j = 0; j < lotsOfInts[i].length; j++) {
                lotsOfInts[i][j] = randomGenerator.nextInt();
            }
        }

        for (int i = 0; i < lotsOfInts.length; i++) {
            String rowAsStr = "";
            for (int j = 0; j < lotsOfInts.length; j++) {
                rowAsStr += getSorted(lotsOfInts[i])[j];
                if (j < (lotsOfInts[i].length - 1)) {
                    rowAsStr += ", ";
                }
            }
            Log.i(TAG, "Row " + i + " rowAsStr is " + rowAsStr);
        }
    }

    private void changedImPrettySureSortingIsFree() {
        int dimension = 300;
        int[][] lotsOfInts = new int[dimension][dimension];
        Random randomGenerator = new Random();
        for (int i = 0; i < lotsOfInts.length; i++) {
            for (int j = 0; j < lotsOfInts[i].length; j++) {
                lotsOfInts[i][j] = randomGenerator.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        String rowAsStr = "";
        for (int i = 0; i < lotsOfInts.length; i++) {
            sb.delete(0, rowAsStr.length());
            for (int j = 0; j < lotsOfInts[i].length; j++) {
                sb.append(getSorted(lotsOfInts[i])[j]);
                if (j < lotsOfInts[i].length - 1) {
                    sb.append(", ");
                }
            }
            rowAsStr = sb.toString();
            Log.i(TAG, "Row " + i + " rowAsStr is " + rowAsStr);
        }
    }

    private int[] getSorted(int[] array) {
        int i, j, temp, len = array.length;
        for (i = 0; i < len - 1; i++)
            for (j = 0; j < len - 1 - i; j++)
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        return array;
    }

}
