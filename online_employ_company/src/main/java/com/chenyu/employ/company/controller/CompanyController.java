package com.chenyu.employ.company.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chenyu.employ.common.base.BaseController;
import com.chenyu.employ.common.enums.UserStatus;
import com.chenyu.employ.common.error.EmployAssert;
import com.chenyu.employ.common.error.ErrorType;
import com.chenyu.employ.common.utils.FileUploadUtil;
import com.chenyu.employ.common.utils.PaginationUtil;
import com.chenyu.employ.company.dto.CompanyDetailDto;
import com.chenyu.employ.company.model.Company;
import com.chenyu.employ.company.model.CompanyDetail;
import com.chenyu.employ.company.service.CompanyDetailService;
import com.chenyu.employ.company.service.CompanyService;
import com.chenyu.employ.company.util.SessionManager;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController{
	@Autowired
	private CompanyDetailService companyDetailService;
	@Autowired
	private CompanyService companyService;
	
	private static final String FilePath="/img/employ/company/logo/";
	
	@RequestMapping("/companyList")
	public String companyList(CompanyDetailDto companyDetailDto,HttpServletRequest request,ModelMap map){
		Company company = SessionManager.get(request);
		EmployAssert.notNull(company,ErrorType.SYSTEM_BUSY);
		companyDetailDto.setCompany(company);
		List<CompanyDetail> companyList=companyDetailService.getCompanyDetailByCompanyId(companyDetailDto);
		//还未被创建公司详情信息
		if(companyList==null||companyList.size()<=0){
			logger.debug("未发现详细信息");
		}
		map.addAttribute("company",company);
		
		PaginationUtil<CompanyDetail> page=new PaginationUtil<CompanyDetail>(companyDetailDto.getPageNo(),companyDetailDto.getPageSize());
		page.setItems(companyList);
		page.setTotalCount(companyDetailService.getCompanyDetailCount(companyDetailDto));
		map.addAttribute("page",page);
		map.addAttribute("requestUrl",request.getRequestURL().toString());
		return "/company/company_list";
	}

	@ResponseBody
	@RequestMapping("/lockOrActiveCompany")
	public String lockOrActiveCompany(Company company,HttpServletRequest request,ModelMap map){
		Company companyInfo = SessionManager.get(request);
		EmployAssert.isTrue(company!=null&&company.getStatus()!=null, ErrorType.PARAM_EMPTY);
		//当前用户不能改变自己的状态
		if(companyInfo.getCid().equals(company.getCid())||companyInfo.getStatus()==UserStatus.check.getFlag()){
			return jsonFailed(ErrorType.SYSTEM_BUSY);
		}
		company.setStatus((company.getStatus()+1)%2);
		companyService.changeStatus(company);
		return jsonSuccess();
	}
	
	@RequestMapping("/toEdit")
	public String toEdit(Integer cdId,HttpServletRequest request,ModelMap map){
		Company company=SessionManager.get(request);
		CompanyDetail companyDetail=companyDetailService.getCompanyDetailById(cdId);
		EmployAssert.notNull(companyDetail, ErrorType.PARAM_EMPTY);
		map.addAttribute("companyDetail",companyDetail);
		map.addAttribute("company",company);
		return "/company/company_edit";
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(CompanyDetail companyDetail,HttpServletRequest request,ModelMap map,@RequestParam(value = "logoImg") MultipartFile logoImg){
		Company company = SessionManager.get(request);
		EmployAssert.notNull(company, ErrorType.PARAM_EMPTY);
		EmployAssert.isTrue(company.getCid().equals(companyDetail.getCompany().getCid()), ErrorType.SYSTEM_FORBIDDEN);
        if (logoImg.getSize() > 0) {
            logger.info("上传文件：" + logoImg.getOriginalFilename());
            String logo = FileUploadUtil.fileUpload(logoImg, request,FilePath);
            companyDetail.setLogo(FilePath+logo);
        }
        if(companyDetail.getCdId()!=null){
        	companyDetailService.update(companyDetail);
        }else{
        	companyDetailService.save(companyDetail);
        }
        if (logoImg.getSize() > 0) {
            FileUploadUtil.deleteFile(request, request.getParameter("originPic"),FilePath);
        }
		return "redirect:/company/companyList.jhtml";
	}
	
	@ResponseBody
	@RequestMapping("/changeWeight")
	public String changeWeight(CompanyDetail companyDetail,HttpServletRequest request,ModelMap map){
		companyDetailService.changeWeight(companyDetail);
		EmployAssert.notNull(companyDetail.getWeight(), ErrorType.PARAM_EMPTY);
		return jsonSuccess();
	}
	
	@ResponseBody
	@RequestMapping("/changePassword")
	public String changePassword(Company company,HttpServletRequest request,ModelMap map,String oldPassword,String confirmPassword){
		Company currentCompany = SessionManager.get(request);
		if(!currentCompany.getCid().equals(company.getCid())){
			return jsonFailed(ErrorType.SYSTEM_FORBIDDEN);
		}
		if(StringUtils.isBlank(oldPassword)){
			return jsonFailed(ErrorType.PARAM_EMPTY);
		}
		if(!oldPassword.equals(currentCompany.getPassword())){
			return jsonFailed(ErrorType.SYSTEM_USER_LOGIN_PWD_INVALID);
		}
		if(!company.getPassword().equals(confirmPassword)){
			return jsonFailed(ErrorType.SYSTEM_USER_NEWPSD_NOTEQUAL_OLDPSD);
		}
		companyService.modifyPassword(company);
		return jsonSuccess();
	}
}
