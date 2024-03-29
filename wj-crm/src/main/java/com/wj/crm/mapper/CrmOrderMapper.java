package com.wj.crm.mapper;

import com.wj.crm.domain.CrmOrder;

import java.util.List;

/**
 * 订单Mapper接口
 * 
 * @author Vulcan.W
 * @date 2024-01-19
 */
public interface CrmOrderMapper
{
    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
     CrmOrder selectCrmOrderById(Long id);

    /**
     * 查询订单列表
     * 
     * @param crmOrder 订单
     * @return 订单集合
     */
     List<CrmOrder> selectCrmOrderList(CrmOrder crmOrder);

    /**
     * 新增订单
     * 
     * @param crmOrder 订单
     * @return 结果
     */
     int insertCrmOrder(CrmOrder crmOrder);

    /**
     * 修改订单
     * 
     * @param crmOrder 订单
     * @return 结果
     */
     int updateCrmOrder(CrmOrder crmOrder);

    /**
     * 删除订单
     * 
     * @param id 订单主键
     * @return 结果
     */
     int deleteCrmOrderById(Long id);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
     int deleteCrmOrderByIds(Long[] ids);
}
