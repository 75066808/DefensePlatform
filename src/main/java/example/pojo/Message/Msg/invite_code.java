package example.pojo.Message.Msg;

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
    static Map<String, Integer> typeMap = new HashMap<String, Integer>() {
        {
            put("Main", 0);
            put("Info", 1);
            put("Area", 2);
            put("Commercial", 3);
            put("Doctor", 4);
            put("Medical", 5);

        }
    };

    static invite_code convertMapToClass(Map<String, Object> map) {
        return new invite_code(
                (String)map.get("invite-code"),
                typeMap.get((String)map.get("roles"))
        );
    }

}
