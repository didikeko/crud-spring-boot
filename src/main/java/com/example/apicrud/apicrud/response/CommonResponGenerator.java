package com.example.apicrud.apicrud.response;

import org.springframework.stereotype.Component;

@Component
public class CommonResponGenerator<T> {
    public <T> CommonResponse<T> successResponse(T datas, String message) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus(("200"));
        commonResponse.setMessage(message);
        commonResponse.setDatas(datas);

        return commonResponse;
    }
    public <T> CommonResponse failedResponse(String message) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("500");
        commonResponse.setMessage(message);

        return commonResponse;
    }
}
