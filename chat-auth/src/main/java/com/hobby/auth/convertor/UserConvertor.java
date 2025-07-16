package com.hobby.auth.convertor;

import com.hobby.auth.dto.SysUserDto;
import com.hobby.auth.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Harris
 */
@Mapper
public interface UserConvertor {

    UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);

    /**
     * 单个对象映射方法（必须）
     *
     * @param sysUser po
     * @return DTO
     */
    SysUserDto toDTO(SysUser sysUser);

    /**
     * 转换
     *
     * @param sysUsers po列表
     * @return DTO
     */
    List<SysUserDto> toDTO(List<SysUser> sysUsers);
}
