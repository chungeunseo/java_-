package com.ssafy.hw02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BmiCalculator {

   public static void main(String[] args) throws FileNotFoundException {
      System.setIn(new FileInputStream("input.txt"));
      Scanner in = new Scanner(System.in);
      double weight;
      double height;
      for(int i=0; i<6; i++) {
          int year = in.nextInt();
          if(year>=2) {
             weight = in.nextDouble();
             height = in.nextDouble();
             double bmi = weight/((height/100) * (height/100));
                if(bmi>30) {
                   System.out.println("BMI 지수는 "+bmi+"로 <고도비만>입니다.");
                }else if(bmi>25 && bmi<=30) {
                   System.out.println("BMI 지수는 "+bmi+"로 <비만>입니다.");
                }else if(bmi>23 && bmi<=25) {
                   System.out.println("BMI 지수는 "+bmi+"로 <과체중>입니다.");
                }else if(bmi>18.5 && bmi<=23) {
                   System.out.println("BMI 지수는 "+bmi+"로 <정상>입니다.");
                }else {
                   System.out.println("BMI 지수는 "+bmi+"로 <저체중>입니다.");
                }
          }
       }

          
       
    }

 }
