package com.sellerdata.mapper.mybatis;


import com.sellerdata.pojo.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapperEx {

    List<Integer> findModuleIdListByModuleType(@Param("moduleType") int moduleType);

    List<Module> findModuleListByModuleType(@Param("moduleType") int moduleType);
}
