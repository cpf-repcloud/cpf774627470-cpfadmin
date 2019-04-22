package cn.rep.cloud.custom.openapi.kjController.baseBean;

/**
 * 控件基础bean
 */
public class KjBaseResponse {
    /**
     * id 用于搜索的id,可以为编号,工号等
     */
    private String id;
    /**
     * 显示的名称
     */
    private String name;
    /**
     * 控件返回的数据  一般为主键id
     */
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
