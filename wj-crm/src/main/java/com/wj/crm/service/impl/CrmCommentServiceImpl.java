package com.wj.crm.service.impl;

import com.wj.common.utils.DateUtils;
import com.wj.crm.domain.CrmComment;
import com.wj.crm.domain.CrmCustomer;
import com.wj.crm.mapper.CrmCommentMapper;
import com.wj.crm.service.ICrmCommentService;
import com.wj.crm.service.ICrmCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 跟进记录Service业务层处理
 * 
 * @author Vulcan.W
 * @date 2024-01-19
 */
@Service
public class CrmCommentServiceImpl implements ICrmCommentService 
{
    @Autowired
    private CrmCommentMapper crmCommentMapper;

    @Autowired
    private ICrmCustomerService customerService;

    /**
     * 查询跟进记录
     * 
     * @param id 跟进记录主键
     * @return 跟进记录
     */
    @Override
    public CrmComment selectCrmCommentById(Long id)
    {
        return crmCommentMapper.selectCrmCommentById(id);
    }

    /**
     * 查询跟进记录列表
     * 
     * @param crmComment 跟进记录
     * @return 跟进记录
     */
    @Override
    public List<CrmComment> selectCrmCommentList(CrmComment crmComment)
    {
        return crmCommentMapper.selectCrmCommentList(crmComment);
    }

    /**
     * 新增跟进记录
     * 
     * @param crmComment 跟进记录
     * @return 结果
     */
    @Override
    public int insertCrmComment(CrmComment crmComment)
    {
        crmComment.setCreateTime(DateUtils.getNowDate());
        return crmCommentMapper.insertCrmComment(crmComment);
    }

    /**
     * 修改跟进记录
     * 
     * @param crmComment 跟进记录
     * @return 结果
     */
    @Override
    public int updateCrmComment(CrmComment crmComment)
    {
        crmComment.setUpdateTime(DateUtils.getNowDate());
        return crmCommentMapper.updateCrmComment(crmComment);
    }

    /**
     * 批量删除跟进记录
     * 
     * @param ids 需要删除的跟进记录主键
     * @return 结果
     */
    @Override
    public int deleteCrmCommentByIds(Long[] ids)
    {
        return crmCommentMapper.deleteCrmCommentByIds(ids);
    }

    /**
     * 删除跟进记录信息
     * 
     * @param id 跟进记录主键
     * @return 结果
     */
    @Override
    public int deleteCrmCommentById(Long id)
    {
        return crmCommentMapper.deleteCrmCommentById(id);
    }

    /**
     * 写跟进
     * @param crmComment 跟进
     * @param nextFollowupTime 下次跟进时间
     * @return
     */
    @Override
    @Transactional
    public int insertCrmComment(CrmComment crmComment, Date nextFollowupTime) {
        CrmCustomer crmCustomer = customerService.selectCrmCustomerById(crmComment.getCustomerId());
        crmCustomer.setLastUpdateRecord(crmComment.getContent());
        crmCustomer.setLastFollowupTime(DateUtils.getNowDate());
        crmCustomer.setNextFollowupTime(nextFollowupTime);
        customerService.updateCrmCustomer(crmCustomer);

        crmComment.setCreateTime(DateUtils.getNowDate());
        return crmCommentMapper.insertCrmComment(crmComment);
    }
}
