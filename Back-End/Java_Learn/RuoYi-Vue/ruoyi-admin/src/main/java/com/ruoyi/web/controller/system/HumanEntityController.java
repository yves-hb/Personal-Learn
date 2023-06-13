package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.app.service.IHumanEntityService;
import com.ruoyi.common.core.domain.model.LoginUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.app.domain.HumanEntity;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 人员基本信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-09
 */
@RestController
@RequestMapping("/system/entity")
public class HumanEntityController extends BaseController
{
    @Autowired
    private IHumanEntityService humanEntityService;

    /**
     * 查询人员基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:entity:list')")
    @GetMapping("/list")
    @ApiOperation("获取用户列表")
    public TableDataInfo list(HumanEntity humanEntity)
    {
        startPage();
        List<HumanEntity> list = humanEntityService.selectHumanEntityList(humanEntity);
        return getDataTable(list);
    }

    /**
     * 导出人员基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:entity:export')")
    @Log(title = "人员基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HumanEntity humanEntity)
    {
        List<HumanEntity> list = humanEntityService.selectHumanEntityList(humanEntity);
        ExcelUtil<HumanEntity> util = new ExcelUtil<HumanEntity>(HumanEntity.class);
        util.exportExcel(response, list, "人员基本信息数据");
    }

    /**
     * 批量导入用户信息
     */
    @PreAuthorize("@ss.hasPermi('system:entity:import')")
    @Log(title = "人员基本信息批量导入",businessType = BusinessType.IMPORT)
    @PostMapping("/import")
    public AjaxResult importHumanData(MultipartFile file,boolean updateSupport)throws Exception
    {
        ExcelUtil<HumanEntity> excelUtil = new ExcelUtil<>(HumanEntity.class);
        List<HumanEntity> humanEntities = excelUtil.importExcel(file.getInputStream());
        LoginUser loginUser = getLoginUser();
        String operName = loginUser.getUsername();
        String message = humanEntityService.importHumanData(humanEntities, updateSupport, operName);
        return AjaxResult.success(message);
    }


    /**
     * 获取人员基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:entity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(humanEntityService.selectHumanEntityById(id));
    }

    /**
     * 新增人员基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:entity:add')")
    @Log(title = "人员基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HumanEntity humanEntity)
    {
        return toAjax(humanEntityService.insertHumanEntity(humanEntity));
    }

    /**
     * 修改人员基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:entity:edit')")
    @Log(title = "人员基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HumanEntity humanEntity)
    {
        return toAjax(humanEntityService.updateHumanEntity(humanEntity));
    }

    /**
     * 删除人员基本信息
     */
    @PreAuthorize("@ss.hasPermi('system:entity:remove')")
    @Log(title = "人员基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(humanEntityService.deleteHumanEntityByIds(ids));
    }
}
