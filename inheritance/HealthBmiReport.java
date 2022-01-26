package com.ssafy.hw02;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HealthBmiReport {
	List<HealthStudent> studentList;
	DecimalFormat df;
	
	public HealthBmiReport() {
	   studentList = new ArrayList<>();
	   df = new DecimalFormat("0.000");
	}
	
	//파일의 내용(inputStudent.txt)을 배열(HealthStudent[])에 저장
	public void fromFileToArray(){
		try {
			Scanner scan  = new Scanner(new File("inputStudent.txt"));
			while(scan.hasNext()) {//다음 읽을 정보가 있다면
				String str = scan.nextLine();//라인단위로 정보 얻기 (예: "라이언,2021-01-02,110.5,180.1")
				String []arrayStr = str.split(",");//콤마를 구분자로 데이터를 분리하기 {"라이언","2021-01-02","110.5","180.1"}

				//배열의 정보를 (HealthStudent)객체로 변환
			    HealthStudent student = new HealthStudent(arrayStr[0], 
			    		                                  arrayStr[1], 
			    		                                  Double.parseDouble(arrayStr[2]), 
			    		                                  Double.parseDouble(arrayStr[3]));
			    
			    studentList.add(student);//HealthStudent를 List에 저장 
			                             //"inputStudent.txt"에서 학생의 정보가 몇개인지 알기 어려우므로 List사용이 편리함.
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}//fromFileToArray
	
	public void printStudentInfo() {
		  System.out.println("이름 \t 측정일 \t\t 몸무게 \t 키 \t");		
		  System.out.println("-------------------------------------");
		  for (int i = 0; i < studentList.size(); i++)
              System.out.println(studentList.get(i));
	}
	
	public String printAvgByName(String searchName) {
		double weightSum = 0, heightSum = 0, cnt = 0;
		for (int i = 0; i < studentList.size(); i++) {
			HealthStudent student = studentList.get(i);
			if(student.getName().equals(searchName)) {//일치하는 이름을 찾았다면
				 weightSum += student.getWeight();
				 heightSum += student.getHeight();
				 cnt++;//평균을 구하기 위해 카운트
			}
		}
		return "평균 몸무게 : "+ df.format(weightSum/cnt)+"kg, 평균 키 : "+df.format(heightSum/cnt)+"cm";
	}
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);

    	HealthBmiReport report = new HealthBmiReport();
	    	report.fromFileToArray();
	    	report.printStudentInfo();
	   
	    System.out.println("\n학원생 이름을 입력하세요. >>");
	    String searchName = scan.next();
	        String printStr = report.printAvgByName(searchName);
	    PrintProcess process = new SystemPrint();
	        process.print(printStr);
	                 process = new FilePrint();
	        process.print(printStr);
	    scan.close();    
	}//main
}
