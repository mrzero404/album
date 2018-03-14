package com.zero.textprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class CategoryStatistics {

	public static void main(String[] args) throws Exception, Exception {
		categoryStatstics("D:/StudyMaterials/StatisticalData/Tomato.txt");
	}
	
	public static Map<String, Integer> categoryStatstics(String url) throws Exception, FileNotFoundException {
		Map<String,Integer> map = new HashMap<String,Integer>();
		if(url.contains("\\")){
			url = url.replace("\\", "/");
		}
		File infile = new File(url);
		//判断当前文件的编码格式
		FileInputStream fis =new FileInputStream(infile);  
		String charset = null;
		byte[] b=new byte[3];  
		if(b[0]==-17&&b[1]==-69&&b[2]==-65) {
			charset = "UTF-8";
		}else {
			charset = "gbk";
		}		
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,charset));
		String data = null; //存储一行数据

		while((data = br.readLine())!=null){
			if(map.containsKey(data)) {
				map.replace(data, map.get(data)+1);
			}else {
				map.put(data, 1);
			}
		}
		
		
		
		  for(int i=100;i>0;i--){
			  for (Entry<String, Integer> entry : map.entrySet()) {  
				  if(i == entry.getValue()){
					  System.out.println(entry.getValue()+"-"+entry.getKey());
				  }

			  }  
		  }
		
		
		
		
		return map;
	}

}

