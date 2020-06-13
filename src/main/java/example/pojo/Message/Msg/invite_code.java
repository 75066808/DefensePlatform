package example.pojo.Message.Msg;

import example.converter.Converter;

import java.util.HashMap;
import java.util.Map;

public class invite_code {
    public String code;
    public int type;


    public invite_code(
            String code,
            int type
    ) {
        this.code = code;
        this.type = type;
    }

    /*
    {user=HLSSSS, pwd=123, roles=Main, invite-code=}
    {user=HLSSSS, pwd=123, roles=Info, invite-code=}
    {user=HLSSSS, pwd=123, roles=Area, invite-code=}
    {user=HLSSSS, pwd=123, roles=Commercial, invite-code=}
    {user=HLSSSS, pwd=123, roles=Doctor, invite-code=}
    {user=HLSSSS, pwd=123, roles=Medical, invite-code=}
    */

    public invite_code(Map<String, Object> map) {
        this.code = (String)map.get("invite-code");
        this.type = Converter.applyTypeMap.get((String)map.get("roles"));
    }

}
