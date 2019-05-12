package cn.rep.cloud.businessline.planeticket.business;

public class IcketTestBean {
    private String apiKey;
    private String sign;
    private String timestamp;
    private IcketDTO data;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public IcketDTO getData() {
        return data;
    }

    public void setData(IcketDTO data) {
        this.data = data;
    }
}
