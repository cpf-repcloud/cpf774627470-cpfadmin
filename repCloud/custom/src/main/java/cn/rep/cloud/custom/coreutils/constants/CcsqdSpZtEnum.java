package cn.rep.cloud.custom.coreutils.constants;

import org.apache.commons.lang.StringUtils;

/*出差申请单审批状态枚举*/
public enum CcsqdSpZtEnum {

    // '0草稿 1未提交 2审批中 3审批完成 4已拒绝 5已确认 6已报销 7无需审批'

    CCSQD_SP_ZT_CC("1","未提交"),
    CCSQD_SP_ZT_SPZ("2","审批中"),
    CCSQD_SP_ZT_SPWC("3","审批完成"),
    CCSQD_SP_ZT_YJJ("4","已拒绝"),
    CCSQD_SP_ZT_YBX("5","已报销"),
    CCSQD_SP_ZT_WXSP("6","无需审批"),;

    CcsqdSpZtEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }
    private String key;

    private String value;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public static String getSpztName(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        for (CcsqdSpZtEnum spztEnum : CcsqdSpZtEnum.values()) {
            if (StringUtils.equals(spztEnum.getKey(), key)) {
                return spztEnum.getValue();
            }
        }
        return null;
    }
}
