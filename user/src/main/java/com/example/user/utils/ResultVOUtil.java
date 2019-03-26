package com.example.user.utils;

import com.example.user.VO.ResultVO;
import com.example.user.enums.ResultEnum;

public class ResultVOUtil {
    public static ResultVO success(Object obj){
        ResultVO resultVO = new ResultVO();

        resultVO.setCode(0);
        resultVO.setMeg("成功");
        resultVO.setData(obj);

        return resultVO;
    }

    public static ResultVO success(){
        ResultVO resultVO = new ResultVO();

        resultVO.setCode(0);
        resultVO.setMeg("成功");

        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();

        resultVO.setCode(resultEnum.getCode());
        resultVO.setMeg(resultEnum.getMessage());

        return resultVO;
    }
}
