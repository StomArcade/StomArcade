package net.bitbylogic.stomarcade.permission.database.processor;

import net.bitbylogic.orm.processor.FieldProcessor;
import net.bitbylogic.utils.HashMapUtil;

import java.util.HashMap;

public class PermissionsFieldProcessor implements FieldProcessor<HashMap<String, Boolean>> {

    @Override
    public Object processTo(HashMap<String, Boolean> o) {
        return o == null ? "" : HashMapUtil.mapToString(o, new HashMapUtil.ObjectParser<String, Boolean>() {
            @Override
            public String wrapKey(String s) {
                return s;
            }

            @Override
            public String wrapValue(Boolean aBoolean) {
                return aBoolean.toString();
            }
        });
    }

    @Override
    public HashMap<String, Boolean> processFrom(Object o) {
        return o == null || (o instanceof String string && string.isEmpty()) ? new HashMap<>() : HashMapUtil.mapFromString(new HashMapUtil.ObjectWrapper<String, Boolean>() {
            @Override
            public String wrapKey(String s) {
                return s;
            }

            @Override
            public Boolean wrapValue(String s) {
                return Boolean.parseBoolean(s);
            }
        }, (String) o);
    }

}
