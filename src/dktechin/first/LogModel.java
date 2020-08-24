package dktechin.first;

import java.util.Date;

public class LogModel {
	
	private String stateCode;
	private String serviceId;
	private String apiKeyNm;
	private String browserNm;
	
	
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getApiKeyNm() {
		return apiKeyNm;
	}
	public void setApiKeyNm(String apiKeyNm) {
		this.apiKeyNm = apiKeyNm;
	}
	public String getBrowserNm() {
		return browserNm;
	}
	public void setBrowserNm(String browserNm) {
		this.browserNm = browserNm;
	}
	
	 //==생성 메서드==//
    public static LogModel createLogModel(String stateCode, String apiKeyNm
    								 , String browserNm) {
    	LogModel logModel = new LogModel();
    	logModel.setStateCode(stateCode);
    	logModel.setApiKeyNm(apiKeyNm);
    	logModel.setBrowserNm(browserNm);
        return logModel;
    }
	
	
	


}
