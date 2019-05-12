package cn.rep.cloud.businessline.planeticket.business;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.rep.cloud.businessline.properties.BusinessProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class IcketTest {


    public static void main(String args[]){
        IcketDTO icketDTO = new IcketDTO();
        icketDTO.setDepartCityCode("SHA");
        icketDTO.setArriveCityCode("HFE");
        icketDTO.setIsChild(false);
        icketDTO.setDepartDate("2018/06/01");
        IcketTestBean icketTestBean = new IcketTestBean();
        icketTestBean.setApiKey("");
        icketTestBean.setSign("");
        icketTestBean.setTimestamp("2017/10/1 00:00:00");
        icketTestBean.setData(icketDTO);
        String str = JSONUtil.toJsonStr(icketTestBean);
        String url = "/Flight/Query";
        String str2 = HttpUtil.post(url,str);
        System.out.println(str2);

    }
}
