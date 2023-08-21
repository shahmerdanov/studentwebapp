package com.freedom.studentwebapp.restcontroller.dto.response;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ResponseDto<T> {
    //General Response
    private String message;
    private LocalDateTime date = LocalDateTime.now();
    private int code;
    private T data;

    public static <T> ResponseDto<T> ok(T data) {
        ResponseDto<T> responseDTO = new ResponseDto<>();
        responseDTO.setData(data);
        responseDTO.setMessage("Successfully");
        return responseDTO;
    }

    public String getMessage() {
        return message;
    }

    public ResponseDto<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public ResponseDto<T> setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseDto<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseDto<T> setData(T data) {
        this.data = data;
        return this;
    }
}
