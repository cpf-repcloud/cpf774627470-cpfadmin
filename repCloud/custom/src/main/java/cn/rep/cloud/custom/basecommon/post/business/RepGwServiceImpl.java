package cn.rep.cloud.custom.basecommon.post.business;


import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.basecommon.costcenter.service.dto.DataSendsDTO;
import cn.rep.cloud.custom.basecommon.post.dto.PostRankDataDTO;
import cn.rep.cloud.custom.basecommon.post.dto.PostRankSearchDTO;
import cn.rep.cloud.custom.basecommon.post.dto.SelectPostRankListDTO;
import cn.rep.cloud.custom.basecommon.post.entity.RepGw;
import cn.rep.cloud.custom.basecommon.post.mapper.RepGwMapper;
import cn.rep.cloud.custom.basecommon.post.vo.PostRankDataVO;
import cn.rep.cloud.custom.basecommon.post.vo.SelectPostRankListVO;
import cn.rep.cloud.custom.coreutils.utils.BeanMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vetech on 2018/7/26.
 */
@Service
public class RepGwServiceImpl {

    @Autowired
    private RepGwMapper repGwMapper;

    /**
     * 查询公司岗位列表
     *
     * @param dto
     * @return
     */
    public List<PostRankDataVO> postRankList(PostRankSearchDTO dto) {
        EntityWrapper ew = new EntityWrapper();
        ew.eq("qybh", dto.getQybh());
        if(StringUtils.isNotBlank(dto.getGsid())){
            ew.eq("gsid",dto.getGsid());
        }
        if (StringUtils.isNotBlank(dto.getGwmc())) {
            ew.like("gwmc", dto.getGwmc()).or().like("gwbh", dto.getGwmc());
        }
        if(StringUtils.isNotBlank(dto.getGwbh())){
            ew.eq("gwbh",dto.getGwbh());
        }
        ew.orderBy("zhxgsj",false);
        List<RepGw> gws = repGwMapper.selectList(ew);
        List<PostRankDataVO> vos = BeanMapper.mapList(gws,  PostRankDataVO.class);
        return vos;
    }

    /**
     * 添加员工岗位
     *
     * @param dataDTO
     * @return
     */
    public int addRank(PostRankDataDTO dataDTO) {
        RepGw gw = BeanMapper.map(dataDTO, RepGw.class);
        return repGwMapper.insert(gw);
    }

    /**
     * 编辑员工岗位
     *
     * @param dataDTO
     * @return
     */
    public int editRank(PostRankDataDTO dataDTO) {
        RepGw gw = BeanMapper.map(dataDTO, RepGw.class);
        return repGwMapper.updateById(gw);
    }

    /**
     * 删除公司岗位
     *
     * @param dto
     * @return
     */
    public int deleteRank(PostRankDataDTO dto) {
        RepGw gw = BeanMapper.map(dto, RepGw.class);
        EntityWrapper ew = new EntityWrapper(gw);
        return repGwMapper.delete(ew);
    }

    /**
     * 根据条件查询岗位集合
     * @param repGw 岗位查询条件
     * @return 岗位集合
     */
    public List<RepGw> queryVegwList(RepGw repGw){
        EntityWrapper<RepGw> ew = new EntityWrapper<>();
        ew.setEntity(repGw);
        return repGwMapper.selectList(ew);
    }

    /**
     * 根据条件查询岗位集合
     * @param dto 入参对象
     * @return 岗位集合
     */
    public List<RepGw> queryVegwLists(DataSendsDTO dto){
        EntityWrapper<RepGw> ew = new EntityWrapper<RepGw>();
        RepGw repGw = new RepGw();
        repGw.setQybh(dto.getQybh());
        if(org.apache.commons.lang3.StringUtils.isNotBlank(dto.getGsid())){
            repGw.setGsid(dto.getGsid());
        }
        repGw.setZt(Constants.ZT_ONE);
        ew.setEntity(repGw);
        if(CollectionUtils.isNotEmpty(dto.getGsdxflids())){
            ew.in("gwbh",dto.getGsdxflids());
        }
        if(CollectionUtils.isNotEmpty(dto.getGsids())){
            ew.in("gsid",dto.getGsids());
        }
        return repGwMapper.selectList(ew);
    }

    /**
     * 查询岗位数据
     *
     * @param dto 入参
     * @return List<SelectPostRankListVO> 岗位数据集合
     */
    public List<SelectPostRankListVO> selectPostRankList(SelectPostRankListDTO dto){
        return repGwMapper.selectPostRankList(dto) ;
    }

}
