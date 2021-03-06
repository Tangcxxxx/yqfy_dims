package com.hengtianyi.dims.web;

import com.hengtianyi.common.core.base.service.AbstractBaseController;
import com.hengtianyi.common.core.constant.BaseConstant;
import com.hengtianyi.common.core.feature.ServiceResult;
import com.hengtianyi.dims.service.api.VillageService;
import com.hengtianyi.dims.service.entity.VillageEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author LY
 */
@Controller
@RequestMapping(value = Village1Controller.MAPPING)
public class Village1Controller extends AbstractBaseController<VillageEntity, String> {

  private static final Logger LOGGER = LoggerFactory.getLogger(Village1Controller.class);
  public static final String MAPPING = "village1";

  @Resource
  private VillageService villageService;

  @Override
  public VillageService getService() {
    return villageService;
  }

  @Override
  public Logger getLogger() {
    return LOGGER;
  }

  @ResponseBody
  @GetMapping(value = "/list.json", produces = BaseConstant.JSON)
  public String saveTree(@RequestParam String areaCode) {
    ServiceResult<Object> result = new ServiceResult<>();
    result.setSuccess(true);
    result.setResult(villageService.townChilds(areaCode));
    return result.toJson();
  }


  @ResponseBody
  @GetMapping(value = "/list2.json", produces = BaseConstant.JSON)
  public String saveTree2(@RequestParam String areaCode) {
    ServiceResult<Object> result = new ServiceResult<>();
    result.setSuccess(true);
    result.setResult(villageService.townChilds2(areaCode));
    return result.toJson();
  }
}
