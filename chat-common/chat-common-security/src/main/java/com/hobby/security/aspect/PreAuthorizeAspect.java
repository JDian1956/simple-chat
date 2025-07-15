package com.hobby.security.aspect;

import com.hobby.security.annotation.RequiresPermissions;
import com.hobby.security.annotation.RequiresRoles;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author Harris
 */
@Aspect
public class PreAuthorizeAspect {

    public PreAuthorizeAspect() {

    }

    @Pointcut("@annotation(com.hobby.security.annotation.RequiresPermissions) || " +
            "@annotation(com.hobby.security.annotation.RequiresRoles)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 检查是否标注了权限或角色注解
        if (method.isAnnotationPresent(RequiresPermissions.class)) {
            RequiresPermissions annotation = method.getAnnotation(RequiresPermissions.class);
            String[] permissions = annotation.value();
            checkPermissions(permissions);

        } else if (method.isAnnotationPresent(RequiresRoles.class)) {
            RequiresRoles annotation = method.getAnnotation(RequiresRoles.class);
            String[] roles = annotation.value();
            checkRoles(roles);
        }

        return joinPoint.proceed();
    }

    /**
     * 校验用户是否拥有指定权限
     */
    private void checkPermissions(String[] permissions) {
        // TODO: 实现权限校验逻辑
        boolean hasPermission = false;

        // 示例逻辑：假设用户没有权限
        if (!hasPermission) {
            throw new SecurityException("缺少必要权限：" + String.join(",", permissions));
        }
    }

    /**
     * 校验用户是否属于指定角色
     */
    private void checkRoles(String[] roles) {
        // TODO: 实现角色校验逻辑
        boolean hasRole = false;

        // 示例逻辑：假设用户不属于该角色
        if (!hasRole) {
            throw new SecurityException("不具备所需角色：" + String.join(",", roles));
        }
    }

}
