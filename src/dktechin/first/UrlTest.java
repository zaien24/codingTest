package dktechin.first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class UrlTest {

	public static void main(String[] args) {
		
		String inputFilePath = "C:/codeTest/input.log";	
		String outputFilePath = "C:/codeTest/output.log";
		File inputfile = new File(inputFilePath);
		File outputFile = new File(outputFilePath);
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(inputfile));
			String s;
			s = in.readLine();
			
			List<LogModel> connectList = new ArrayList<>();
			
			while ( s != null) {
				StringTokenizer st = new StringTokenizer(s, "[]");
				List<String> tempList = new ArrayList<>();
				while (st.hasMoreTokens()) {
					tempList.add(st.nextToken()); 
				}				
				connectList.add(LogModel.createLogModel(tempList.get(0), 
						tempList.get(1), tempList.get(2)));
				s = in.readLine();
			}						
			in.close();
			
			List<String> tempApikeyList = new ArrayList<>();
			List<String> tempSvcIdList = new ArrayList<>();
			List<String> tempBrowserNmList = new ArrayList<>();
			int totalCnt = 0; // API 전체 호출수 
			
			for (int i = 0; i < connectList.size(); ++i) {
				String tmpStateCode = connectList.get(i).getStateCode();
				
				if (tmpStateCode.equals("200")) {
					// 최다 호출 API KEY				
					String tmpApiKey = connectList.get(i).getApiKeyNm();
					int idxApiNmStart = tmpApiKey.lastIndexOf("apikey=");
					if (idxApiNmStart != -1) {
						String apiKey = tmpApiKey.substring(idxApiNmStart+7, idxApiNmStart+11);
						tempApikeyList.add(apiKey);
					}			
					
					// 상위 3개의 API ServiceID와 각각의 요청 수
					int idxSvcIdStart = tmpApiKey.indexOf("search/");
					int idxSvcIdEnd = tmpApiKey.indexOf("?");
					if (idxSvcIdStart != -1 || idxSvcIdEnd != -1) {
						String serviceId = tmpApiKey.substring(idxSvcIdStart+7, idxSvcIdEnd);	
						tempSvcIdList.add(serviceId);
					}
					
					// 웹브라우저별 사용 비율
					String tmpBrowserNm = connectList.get(i).getBrowserNm();
					if (!tmpBrowserNm.equals(null) ) {
						tempBrowserNmList.add(tmpBrowserNm);
					}		
					totalCnt++;
				}	
			}		
			
			// 최다 호출 API KEY	
			String resultApiNm = "";
			Map<String, Integer> apikeyMap = new HashMap<String, Integer>();
			for(String key : tempApikeyList) {
				apikeyMap.put(key, apikeyMap.getOrDefault(key, 0)+1);
			}
			Iterator<String> apiNmkeys = apikeyMap.keySet().iterator();
			int apikeyCnt = 0; // apikey 순
			while(apiNmkeys.hasNext()){
			    String key = apiNmkeys.next();
			    if (apikeyCnt < apikeyMap.get(key) ) {
			    	apikeyCnt = apikeyMap.get(key);
			    	resultApiNm = key;
			    }
			}
			
			// 상위 3개의 API ServiceID와 각각의 요청 수 
			Map<String, Integer> svcIdMap = new HashMap<String, Integer>();
			for(String key : tempSvcIdList) {
				svcIdMap.put(key, svcIdMap.getOrDefault(key, 0)+1);
			}
			// value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
	        List<Map.Entry<String, Integer>> svcIdList = new LinkedList<>(svcIdMap.entrySet());
	        Collections.sort(svcIdList, new Comparator<Map.Entry<String, Integer>>() {
	            @Override
	            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	                int comparision = (o1.getValue() - o2.getValue()) * -1;
	                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
	            }
	        });
	        
	       // 웹브라우저별 사용 비율
	       Map<String, Integer> browseNmMap = new HashMap<String, Integer>();
		   for(String key : tempBrowserNmList) {
				browseNmMap.put(key, browseNmMap.getOrDefault(key, 0)+1);
			}	
		   
		   // value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
	       List<Map.Entry<String, Integer>> browseNmList = new LinkedList<>(browseNmMap.entrySet());
	       Collections.sort(browseNmList, new Comparator<Map.Entry<String, Integer>>() {
	            @Override
	            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	                int comparision = (o1.getValue() - o2.getValue()) * -1;
	                return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
	            }
	        });
		   
		   // 결과 출력
		   PrintWriter out = new PrintWriter(new FileWriter(outputFile, true));						
		   
		   out.println("최대호출 API KEY");
		   out.println(resultApiNm);
		   out.println("");
		   
		   out.println("상위 3개의 API ServiceID와 각각의 요청 수 ");
		   for (int i = 0; i < 3; i++) {
			   out.println(svcIdList.get(i).getKey() + " : " + svcIdList.get(i).getValue());
	       }
		   out.println("");
		   
		   out.println("웹브라우저별 사용 비율");			
		   for (int i = 0; i < browseNmList.size(); i++) {
			   double useBrowseNmCnt = browseNmList.get(i).getValue();
			   out.println(browseNmList.get(i).getKey() + " : " + (int)Math.floor(useBrowseNmCnt / totalCnt * 100) + "%");
	       }
		   out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}                                
}
