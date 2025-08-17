package com.example.solverpractise;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.solverpractise.databinding.ActivityMainBinding;

public class Solver extends BaseObservable {
    ActivityMainBinding binding;
    String a, b, c;
    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public Solver() {
    }

    public Solver(ActivityMainBinding binding) {
        this.binding = binding;
    }

    public void solveEq(View view) {
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        double discr = b*b - 4 * a *c;
        double x1, x2;
        if (discr > 0) {
            x1 = (-b + Math.sqrt(discr)) / (2*a);
            x2 = (-b - Math.sqrt(discr)) / (2*a);
            binding.solvedText.setText("X1 = " + x1 + " X2= " + x2);
        } else if (discr < 0) {
            binding.solvedText.setText("No real solutions");
        } else {
            x1 = -b / (2 * a);
            binding.solvedText.setText("X = " + x1);
        }
    }

}
