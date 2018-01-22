package com.cosis.crm.cash.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * @author cosis
 * 参数校验类
 */
@Component
public class CheckHelper {

    private static final String PHONE_REG = "^1[3|4|5|7|8][0-9]{9}$";

    private static final String IDCARD_REG = "^1[0-9]{10}$";

    private static final String BANKCARD_REG = "^1[0-9]{10}$";

    /**
     * 过滤emoji
     * @param source
     * @return
     */
    public String filterEmoji(String source) {
        if (this.checkNotEmpty(source)) {
            return source.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", "");
        } else {
            return "";
        }
    }

    /**
     * 非空,去重
     * @param arg
     * @return true 不为空
     */
    public boolean checkNotEmpty(String arg){
        return (arg !=  null && (arg=arg.trim()).length()>0);
    }

    /**
     * 为空
     * @param arg
     * @return true 为空
     */
    public boolean checkEmpty(String arg){
        return (arg ==  null || (arg=arg.trim()).length()==0);
    }

    /**
     * 校验手机号是否合法
     * @param phoneNo
     * @return true 合法
     */
    public boolean checkPhoneNo(String phoneNo) {
        return StringUtils.isNotBlank(phoneNo)
                && Pattern.compile(PHONE_REG).matcher(phoneNo).matches();
    }

    /**
     * 校验身份证号码是否合法
     * @param idCardNo
     * @return
     */
    public boolean checkIDCardNo(String idCardNo){
        return  StringUtils.isNotBlank(idCardNo)
                && ((idCardNo=idCardNo.trim()).length()==15 || idCardNo.length()==18);
    }

    /**
     * 校验短信验证码是否合法
     * @param vfcode
     * @return
     */
    public boolean checkVFCode(String vfcode){
        return  StringUtils.isNotBlank(vfcode)
                && (vfcode=vfcode.trim()).length()== 6;
    }

    /**
     * 校验银行卡号码是否合法
     * @param bankCardNo
     * @return
     */
    public boolean checkBankCardNo(String bankCardNo){
        return true;
    }

}