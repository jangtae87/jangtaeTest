package com.open.myBoard.common.vo;

import java.util.HashMap;

public class ResultVo {

    private boolean success;
    private HashMap<String, Object> resultMap;
    private int total_count;
    private String resultMsg;
    private String resultView;
    
    public String getResultView() {
		return resultView;
	}

	public void setResultView(String resultView) {
		this.resultView = resultView;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HashMap<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(HashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

	@Override
	public String toString() {
		return "ResultVo [success=" + success + ", resultMap=" + resultMap + ", total_count=" + total_count
				+ ", resultMsg=" + resultMsg + ", resultView=" + resultView + "]";
	}

}


