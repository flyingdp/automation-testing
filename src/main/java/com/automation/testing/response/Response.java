package com.automation.testing.response;

public class Response {

    private final static String SUCCESS = "success";

    private final static String FAIL = "fail";

    //正常返回
    public static <T> ResponseResult<T> makeOKResponse() {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS);
    }

//    public static <T> ResponseResult<T> makeOKResponse(String message) {
//        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(message);
//    }

    public static <T> ResponseResult<T> makeOKResponse(T data) {
        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }
//
//    public static <T> ResponseResult<T> makeOKResponse(T data,String message) {
//        return new ResponseResult<T>().setCode(ResultCode.SUCCESS).setMsg(message).setData(data);
//    }

    //异常返回
    public static <T> ResponseResult<T> makeErrResponse(String message) {
        return new ResponseResult<T>().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMsg(message);
    }

}