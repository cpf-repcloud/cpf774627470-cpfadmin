package cn.rep.cloud.custom.basecommon.business;


import cn.rep.cloud.custom.basecommon.entity.VeXm;
import cn.rep.cloud.custom.basecommon.mapper.VeXmMapper;
import cn.rep.cloud.custom.basecommon.service.dto.AddProDTO;
import cn.rep.cloud.custom.basecommon.service.dto.SearchDataDTO;
import cn.rep.cloud.custom.basecommon.service.vo.ProDataVo;
import cn.rep.cloud.custom.coreutils.common.PageCopyUtil;
import cn.rep.cloud.custom.coreutils.common.PageDTO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import cn.rep.cloud.custom.coreutils.utils.DateUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目管理实现类
 * Created by vetech on 2018/8/4.
 */
@Service
public class VeXmServiceImpl {

    @Autowired
   private VeXmMapper veXmMapper;

    /***
     * 添加项目方法
     *
     * @param dto 入参
     * @return
     */
    public int addPro(AddProDTO dto) {
        VeXm xm = BeanMapper.map(dto, VeXm.class);
        return veXmMapper.insert(xm);
    }

    /**
     * 查询项目分页
     *
     * @param dto
     * @return
     */
    public Page<ProDataVo> selectPage(PageDTO<SearchDataDTO> dto) {
        Page<ProDataVo> resultPage = PageCopyUtil.genPage(dto);
        List<ProDataVo> ids = veXmMapper.selectVeXmPage(resultPage, dto.getData());
        if (CollectionUtils.isNotEmpty(ids)) {
            List<ProDataVo> vos = new ArrayList<>();
            for (ProDataVo datavo : ids) {
                VeXm xm = veXmMapper.selectById(datavo.getId());
                ProDataVo vo = BeanMapper.map(xm, ProDataVo.class);
                vo.setKsrqStr(DateUtils.formatToStr(vo.getKsrq(), "yyyy-MM-dd"));
                vos.add(vo);
            }
            resultPage.setRecords(vos);
        } else {
            return null;
        }
        return resultPage;
    }

    /**
     * 编辑页面
     *
     * @param dto
     * @return
     */
    public int editPro(AddProDTO dto) {
        VeXm xm = BeanMapper.map(dto, VeXm.class);
        return veXmMapper.updateById(xm);
    }

    /**
     * 查询该企业下的所有项目集合
     *
     * @param qybh 企业编号
     * @return
     */
    public List<VeXm> getAllList(String qybh) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq("qybh", qybh);
        return veXmMapper.selectList(ew);
    }


    /**
     * 查询项目详情
     *
     * @param id
     * @return
     */
    public VeXm getXmByDto(String id) {
        return veXmMapper.selectById(id);
    }

    /**
     * 查询项目列表
     *
     * @param dto
     * @return
     */
    public List<VeXm> getXmListByDto(SearchDataDTO dto) {
        EntityWrapper ew = new EntityWrapper();
        if (StringUtils.isNotBlank(dto.getXmbh())) {
            ew.eq("xmbh", dto.getXmbh());
        }
        if (StringUtils.isNotBlank(dto.getXmmc())) {
            ew.eq("xmmc", dto.getXmmc());
        }
        return veXmMapper.selectList(ew);
    }

    /**
     * 修改项目状态
     * @param dto 入参
     * @return int
     */
    public int updateState(AddProDTO dto) {
        VeXm vexm = BeanMapper.map(dto, VeXm.class);
        return veXmMapper.updateById(vexm);
    }

    public int updateById(VeXm veXm){
        return veXmMapper.updateById(veXm);
    }
}
