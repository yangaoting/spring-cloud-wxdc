package com.imooc.product.utils;

import com.imooc.product.VO.ResultVO;

public class ResultVOUtils<T> {

    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);

        return resultVO;
    }
}
