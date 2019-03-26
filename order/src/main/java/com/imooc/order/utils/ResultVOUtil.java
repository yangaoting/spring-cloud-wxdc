package com.imooc.order.utils;

import com.imooc.order.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object obj){
        ResultVO resultVO = new ResultVO();

        resultVO.setCode(0);
        resultVO.setMeg("成功");
        resultVO.setData(obj);

        return resultVO;
    }
}
