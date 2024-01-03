package com.liao.template.spring2.common.util.result;


import com.liao.template.spring2.core.util.http.HttpHeaderTool;
import com.liao.template.spring2.core.util.http.HttpHeaderTool.HeaderEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {
    @ApiModelProperty("响应码，当为8000000时，为正常返回")
    private Integer code;
    @ApiModelProperty("响应数据")
    private T data;
    @ApiModelProperty("响应信息")
    private String message;
    @ApiModelProperty("响应状态")
    private Boolean status = false;
    @ApiModelProperty("响应全局ID")
    private String txId;

    public Result() {
        this.txId = HttpHeaderTool.getHeaderValue(HeaderEnum.TX_ID);
    }

    public Result(Integer code, String message, Boolean status) {
        this.txId = HttpHeaderTool.getHeaderValue(HeaderEnum.TX_ID);
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public Result(Integer code, T data, String message, Boolean status) {
        this.txId = HttpHeaderTool.getHeaderValue(HeaderEnum.TX_ID);
        this.code = code;
        this.data = data;
        this.message = message;
        this.status = status;
    }

}
