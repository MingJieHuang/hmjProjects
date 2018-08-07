package com.phone.erp.boss.vo.common;

import com.phone.erp.base.vo.employee.LoginEmployeeVo;

/**
 * [Boss小程序公用查询Vo]
 * @author HMJ
 * @version [版本,2018-7-12]
 * @see 
 */

public class BossQueryVo {
	// 1.集团id
	private Long groupId;
	// 2.公司Id
	private Long companyId;
	// 3.公司Ids 字符串逗号拼接多公司id
	private String companyIds;
	// 4.部门Id
	private Long sectionId;
	// 5.部门Ids 字符串逗号拼接多部门id
	private String sectionIds;
	// 6.员工id
	private Long employeeId;
	// 7.登录的员工
	private LoginEmployeeVo employeeVo;
	// 8.分页参数_当前页
	private Integer page;
	// 9.分页参数_每页显示数量数目
	private Integer pageSize;
	// 10.分页参数_最大数据值
	private Integer totalCount;
	// 11.分页参数_最大页数
	private Integer totalPage;
	//12.是否禁用(0为启用,1为禁用,2删除)
	private Integer containsDisable;
	//13.公司部门参数
	private String companySectionParam;
	//14.商品分类id
	private Long goodsClassId;
	//15.商品品牌id
	private Long goodsBrandId;
	//16.主页模糊搜索关键字
	private String keyWord;
	//17.部门是否公开库存量[1:公开,0:不公开]
	private Boolean kcFalg;
	//18.是否只查一级商品类别[1:是,0:否]
	private Boolean onlyQueryOneLevelGoodsclass;
	//19.报表菜单码
	private String menuCode;
	//20.当前员工查看成本价权限[1:有,0:无]
	private Boolean canSeeAmount;
	//21.商品id
	private Long goodsId;
	//22.销售类型  全部:空,1:零售,2:销售
	private Long salesType;
	//23.查询起始时间startDate
	private String startDate;
	//24.查询截止时间endDate
	private String endDate;
	//25.nodeType 对象类型
	private String nodeType;
	//26.详情页模糊匹配
	private String detailKeyWord;
	//27.供应商id 
	private Long supplierId;
	//28.汇总字段 
	private String groupField;
	//29.串号Id 
	private Long imeiId;
	//29.destStr 方法描述 
	private String destStr;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyIds() {
		return companyIds;
	}
	public void setCompanyIds(String companyIds) {
		this.companyIds = companyIds;
	}
	public Long getSectionId() {
		return sectionId;
	}
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionIds() {
		return sectionIds;
	}
	public void setSectionIds(String sectionIds) {
		this.sectionIds = sectionIds;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LoginEmployeeVo getEmployeeVo() {
		return employeeVo;
	}
	public void setEmployeeVo(LoginEmployeeVo employeeVo) {
		this.employeeVo = employeeVo;
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getContainsDisable() {
		return containsDisable;
	}
	public void setContainsDisable(Integer containsDisable) {
		this.containsDisable = containsDisable;
	}
	public String getCompanySectionParam() {
		return companySectionParam;
	}
	public void setCompanySectionParam(String companySectionParam) {
		this.companySectionParam = companySectionParam;
	}
	public Long getGoodsClassId() {
		return goodsClassId;
	}
	public void setGoodsClassId(Long goodsClassId) {
		this.goodsClassId = goodsClassId;
	}
	public Long getGoodsBrandId() {
		return goodsBrandId;
	}
	public void setGoodsBrandId(Long goodsBrandId) {
		this.goodsBrandId = goodsBrandId;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public Boolean getKcFalg() {
		return kcFalg;
	}
	public void setKcFalg(Boolean kcFalg) {
		this.kcFalg = kcFalg;
	}
	public Boolean getOnlyQueryOneLevelGoodsclass() {
		return onlyQueryOneLevelGoodsclass;
	}
	public void setOnlyQueryOneLevelGoodsclass(Boolean onlyQueryOneLevelGoodsclass) {
		this.onlyQueryOneLevelGoodsclass = onlyQueryOneLevelGoodsclass;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public Boolean getCanSeeAmount() {
		return canSeeAmount;
	}
	public void setCanSeeAmount(Boolean canSeeAmount) {
		this.canSeeAmount = canSeeAmount;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getSalesType() {
		return salesType;
	}
	public void setSalesType(Long salesType) {
		this.salesType = salesType;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getDetailKeyWord() {
		return detailKeyWord;
	}
	public void setDetailKeyWord(String detailKeyWord) {
		this.detailKeyWord = detailKeyWord;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getGroupField() {
		return groupField;
	}
	public void setGroupField(String groupField) {
		this.groupField = groupField;
	}
	public Long getImeiId() {
		return imeiId;
	}
	public void setImeiId(Long imeiId) {
		this.imeiId = imeiId;
	}
	public String getDestStr() {
		return destStr;
	}
	public void setDestStr(String destStr) {
		this.destStr = destStr;
	}
	
}
