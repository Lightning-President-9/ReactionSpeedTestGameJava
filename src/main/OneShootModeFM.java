package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OneShootModeFM {

	GamePanel gp;
	ArrayList<Record> storedRecords= new ArrayList<>();
	
	OneShootModeFM(GamePanel gp){
		this.gp = gp;
	}
	
	public void setData() {
		try {
			if(gp.oneShotGameState == true) {
				if(getRecordCount()<10) {
					BufferedWriter bw = new BufferedWriter(new FileWriter("oneshootmode.txt",true));
					bw.write(gp.keyH.name);
					bw.write('|');
					bw.write(Float.toString(gp.ui.yourTime));
					bw.newLine();
					bw.close();
				}
				else {
					handleBestScore(gp.keyH.name,gp.ui.yourTime);
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
			
			
			br = new BufferedReader(new FileReader("oneshootmode.txt"));
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
	public void handleBestScore(String name,float time) {
		ArrayList<Record> records = new ArrayList<>();
		BufferedReader br;
		String line;
		String strArr[];
		try {
			Record temp =new Record();
			temp.name=name;
			temp.time=time;
			records.add(temp);
			
			
			br = new BufferedReader(new FileReader("oneshootmode.txt"));
			while((line =br.readLine())!= null) {
				temp =new Record();
				strArr =line.split("\\|");
				temp.name = strArr[0];
				temp.time = Float.parseFloat(strArr[1]);
				records.add(temp);
			}
			br.close();
			
//			for (Record record : records) {
//	            System.out.println(record.name + "| " + record.time);
//	        }
			
			Collections.sort(records, new Comparator<Record>() {
	            @Override
	            public int compare(Record o1, Record o2) {
	                return Float.compare(o1.time, o2.time);
	            }
	        });
			
			records.remove(records.size() -1);
			BufferedWriter bw = new BufferedWriter(new FileWriter("oneshootmode.txt"));
			for (Record record : records) {
				bw.write(record.name);
				bw.write('|');
				bw.write(Float.toString(record.time));
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
		try {
			br = new BufferedReader(new FileReader("oneshootmode.txt"));
			while((line =br.readLine())!= null) {
				Record temp =new Record();
				strArr =line.split("\\|");
				temp.name = strArr[0];
				temp.time = Float.parseFloat(strArr[1]);
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