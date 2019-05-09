package cn.rep.cloud.custom.basecommon.basedata.business;

import cn.rep.cloud.custom.basecommon.basedata.service.BasedataLbService;
import cn.rep.cloud.custom.basecommon.basedata.service.BasedataSerivce;
import cn.rep.cloud.custom.basecommon.basedata.service.dto.BaseDataLbVO;
import cn.rep.cloud.custom.basecommon.basedata.service.dto.BaseDataListDTO;
import cn.rep.cloud.custom.basecommon.basedata.service.vo.BaseDataLbDTO;
import cn.rep.cloud.custom.basecommon.basedata.service.vo.BaseDataListVO;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasecommonSerivceImpl {

    @Autowired
    private BasedataSerivce basedataSerivce;

    @Autowired
    private BasedataLbService basedataLbService;

    /**
     * 查询基础数据列表
     *
     * @param dto
     * @return
     */
    public Page<BaseDataListVO> queryBaseCommonList(PageDTO<BaseDataListDTO> dto) {
        Page<BaseDataListVO> page = basedataSerivce.selectPage(dto);
        return page;
    }

    /**
     * 查询basedata bean
     *
     * @param id
     * @return
     */
    public BaseDataListVO getBaseDataById(String id) {
        return basedataSerivce.getBaseDataById(id);
    }

    /**
     * 查询 返祖
     *
     * @param dto
     * @return
     */
    public List<BaseDataLbVO> queryBaseLbList(BaseDataLbDTO dto) {
        return basedataLbService.queryList(dto);
    }

    /**
     * 新增基础数据（lb lb数据）
     *
     * @param dto
     * @return
     */
    public Boolean addDataBaseLb(BaseDataListDTO dto) {
        int i = basedataSerivce.insert(dto);
        if (i > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean updataDataBase(BaseDataListDTO dto) {
        if (StringUtils.isBlank(dto.getId())) {
            return Boolean.FALSE;
        }
        int i = basedataSerivce.update(dto);
        if (i > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean deleteDataBase(BaseDataListDTO dto) {
        if (StringUtils.isBlank(dto.getId())) {
            return Boolean.FALSE;
        }
        int i = basedataSerivce.deleteJscsById(dto.getId());
        if (i > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 验证重复
     * @param dto
     * @return
     */
    public Boolean checkBaseData(BaseDataListDTO dto) {
        List<BaseDataListVO> volist = basedataSerivce.checkBaseData(dto);
        if (CollectionUtils.isNotEmpty(volist)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public int addJcsjLb(BaseDataLbDTO dto) {
        return basedataLbService.insertLb(dto);
    }

    public int editJcsjLb(BaseDataLbDTO dto){
        return basedataLbService.editJcsjLb(dto);
    }

}
