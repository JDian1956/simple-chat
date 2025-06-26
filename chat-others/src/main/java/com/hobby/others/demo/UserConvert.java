package com.hobby.others.demo;

import com.hobby.others.demo.domain.UserBO;
import com.hobby.others.demo.domain.UserDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Harris
 */
@Mapper(componentModel = "spring")
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * userBo 转换为 userDto
     * @param userBo
     * @return
     */
//    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password", ignore = true)
    })
    UserDTO userBoToUserDto(UserBO userBo);

    /**
     * userBo 列表转换为 userDto 列表
     * @param userBo
     * @return
     */
    List<UserDTO> userBoToUserDto(List<UserBO> userBo);
}
