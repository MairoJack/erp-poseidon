package com.poseidon.erp.oauth2;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.poseidon.erp.exception.ErpOAuth2Exception;

import java.io.IOException;

/**
 * OAuth2Exception序列器
 *
 * @author mario on 2019-07-19.
 */
public class OAuth2ExceptionJacksonSerializer extends StdSerializer<ErpOAuth2Exception> {

    private static final long serialVersionUID = -7894130614704779577L;

    protected OAuth2ExceptionJacksonSerializer() {
        super(ErpOAuth2Exception.class);
    }

    @Override
    public void serialize(ErpOAuth2Exception value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("code", value.getCode());
        gen.writeStringField("msg", value.getMessage());
        gen.writeEndObject();
    }

}
