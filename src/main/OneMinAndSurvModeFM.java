package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OneMinAndSurvModeFM {

	GamePanel gp;
	ArrayList<Record> storedRecords= new ArrayList<>();
	
	OneMinAndSurvModeFM(GamePanel gp){
		this.gp = gp;
	}
	
	public void setData() {
		try {
			if(gp.easy1MinGameState == true || gp.survivalGameState == true) {
				if(getRecordCount()<10) {
					String fileName="";
					if(gp.easy1MinGameState == true) {
						fileName="oneminmode.txt";
					}
					else {
						fileName="survivalmode.txt";
					}
					BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
					bw.write(gp.keyH.name);
					bw.write('|');
					bw.write(Float.toString(gp.ui.yourTime));
					bw.write('|');
					bw.write(Short.toString(gp.target.targetHitCount));
					bw.write('|');
					bw.write(Float.toString(gp.target.targetHitPerS));
					bw.newLine();
					bw.close();
				}
				else {
					handleBestScore(gp.keyH.name,gp.ui.yourTime,gp.target.targetHitCount,gp.target.targetHitPerS);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getRecordCount() {
		BufferedReader br;
		int lineCounter=0;
		try {
			String fileName="";
			if(gp.easy1MinGameState == true) {
				fileName="oneminmode.txt";
			}
			else {
				fileName="survivalmode.txt";
			}
			
			br = new BufferedReader(new FileReader(fileName));
			while(br.readLine()!= null) {
				lineCounter++;
			}
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineCounter;
		
	}
	public void handleBestScore(String name,float time,short targetHitCount,float targetHPS) {
		ArrayList<Record> records = new ArrayList<>();
		BufferedReader br;
		String line;
		String strArr[];
		try {
			Record temp =new Record();
			temp.name=name;
			temp.time=time;
			temp.targetHitCount =targetHitCount;
			temp.targetHPS=targetHPS;
			records.add(temp);
			
			String fileName="";
			if(gp.easy1MinGameState == true) {
				fileName="oneminmode.txt";
			}
			else {
				fileName="survivalmode.txt";
			}
			
			br = new BufferedReader(new FileReader(fileName));
			while((line =br.readLine())!= null) {
				temp =new Record();
				strArr =line.split("\\|");
				temp.name = strArr[0];
				temp.time = Float.parseFloat(strArr[1]);
				temp.targetHitCount =Short.parseShort(strArr[2]);
				temp.targetHPS=Float.parseFloat(strArr[3]);
				records.add(temp);
			}
			br.close();
			
//			for (Record record : records) {
//	            System.out.println(record.name + "| " + record.time);
//	        }
			
			Collections.sort(records, new Comparator<Record>() {
	            @Override
	            public int compare(Record o1, Record o2) {
	                return Short.compare(o2.targetHitCount, o1.targetHitCount);
	            }
	        });
			
			records.remove(records.size() -1);
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			for (Record record : records) {
				bw.write(record.name);
				bw.write('|');
				bw.write(Float.toString(record.time));
				bw.write('|');
				bw.write(Short.toString(record.targetHitCount));
				bw.write('|');
				bw.write(Float.toString(record.targetHPS));
				bw.newLine();
	        }
			
			bw.close();
			
//			for (Record record : records) {
//	            System.out.println(record.name + "| " + record.time);
//	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getValues() {
		BufferedReader br;
		String line;
		String strArr[];
		String fileName;
		try {
			if(gp.oneMinTableState == true) {
				fileName = "oneminmode.txt";
			}
			else {
				fileName = "survivalmode.txt";
			}
			br = new BufferedReader(new FileReader(fileName));
			while((line =br.readLine())!= null) {
				Record temp =new Record();
				strArr =line.split("\\|");
				temp.name = strArr[0];
				temp.time = Float.parseFloat(strArr[1]);
				temp.targetHitCount = Short.parseShort(strArr[2]);
				temp.targetHPS = Float.parseFloat(strArr[3]);
				storedRecords.add(temp);
				
		}
			br.close();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(Record record :storedRecords) {
//			System.out.println(record.name);
//			System.out.println(record.time);
//		}
		
	}
}
