package cn.rep.cloud.custom.organizationa.service;

import cn.rep.cloud.custom.organizationa.entity.RepYg;
import cn.rep.cloud.custom.organizationa.mapper.RepYgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepYgService {
    @Autowired
    private RepYgMapper repYgMapper;

    /**
     *
     * @param id
     * @return
     */
    public RepYg queryRepYg(String id){
        return repYgMapper.selectById(id);
    }

}
