package com.t.water.handler.exceptionhandler;



import com.t.water.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    //全局异常处理
    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行全局异常处理");
    }



    //指定异常执行方法
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody//为了能够返回数据
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("方法执行ArithmeticException异常！");
    }

    //自定义的异常处理
    @ExceptionHandler(WaterException.class)
    @ResponseBody
    public R error(WaterException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}
