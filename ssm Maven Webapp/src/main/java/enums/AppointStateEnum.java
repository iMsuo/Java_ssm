package enums;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

public enum AppointStateEnum {
	SUCCESS(1,"预约成功"),
	NO_NUMBER(0,"库存不足"),
	REPEAT_APPOINT(-1,"重复预约"),
	INNER_ERROR(-2,"系统异常");
	
	private int state;
	private String stateInfo;
	
	private AppointStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public String getStateInfo() {
		return stateInfo;
	}
	
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	public static AppointStateEnum stateOf(int index)
	{
		for(AppointStateEnum state:values())
		{
			if(state.getState()==index)
			{
				return state;
			}
		}
		return null;
		
	}


}
