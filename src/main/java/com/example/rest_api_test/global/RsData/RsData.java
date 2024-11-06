package com.example.rest_api_test.global.RsData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class RsData<T> {
    private String resultCode;
    private String msg;
    private T data; // 데이터 코드는 제네릭으로 받음
    public static <T> RsData<T> of(String resultCode, String msg, T data) {
        return new RsData<>(resultCode, msg, data);
    }
    public static <T> RsData<T> of(String resultCode, String msg) {
        return of(resultCode, msg, null);
    }
    @JsonIgnore
    public boolean isSuccess() {
        return resultCode.startsWith("200"); // 성공이면 200을 보냄
    }
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }
}