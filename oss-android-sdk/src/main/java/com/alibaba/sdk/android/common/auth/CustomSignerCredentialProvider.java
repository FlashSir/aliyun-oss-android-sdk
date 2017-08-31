package com.alibaba.sdk.android.common.auth;

import com.alibaba.sdk.android.common.auth.CredentialProvider;

/**
 * Created by zhouzhuo on 11/4/15.
 */
public abstract class CustomSignerCredentialProvider extends CredentialProvider {
    /**
     * Custom content sign method. Considering the AccessKeyId/AccessKeySecret is not likely be stored in mobile device,
     * this method is supposed to talk to customer's app servers and get the signature of the content.
     * The typical implementation could be that it posts the content to an app servers and the server has the AK information
     * and sign the content then return the signature.
     *
     * The sign algorithm：http://help.aliyun.com/document_detail/oss/api-reference/access-control/signature-header.html
     * *      signature = "OSS " + AccessKeyId + ":" + base64(hmac-sha1(AccessKeySecret, content))
     *
     * content is the final text to sign which comes from the URL parameters, headers and the actual content payload.
     *
     * @param content The content is concated from URL parameters, headers and the body's data.
     * @return "OSS " + AccessKeyId + ":" + base64(hmac-sha1(AccessKeySecret, content))
     */
    public abstract String signContent(String content);
}
