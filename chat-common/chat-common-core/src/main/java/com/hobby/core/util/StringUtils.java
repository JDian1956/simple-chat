package com.hobby.core.util;

import org.springframework.util.AntPathMatcher;

import java.util.List;

/**
 * @author Harris
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {


    /**
     * 匹配URL
     *
     * @param requestUrl    请求URL
     * @param whiteListUrls 白名单URL列表
     * @return 匹配结果
     */
    public static boolean matchesUrl(String requestUrl, List<String> whiteListUrls) {
        if (isBlank(requestUrl) || whiteListUrls.isEmpty()) {
            return false;
        }
        for (String whiteListUrl : whiteListUrls) {
            if (match(requestUrl, whiteListUrl)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 路径匹配
     *
     * @param str     待匹配
     * @param pattern 匹配模式
     * @return 匹配结果
     */
    public static boolean match(String str, String pattern) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, str);
    }
}
