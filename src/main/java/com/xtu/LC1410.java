package com.xtu;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

class LC1410 {
    class EntityChar {
        String entity;
        char character;

        public EntityChar(String entity, char character) {
            this.entity = entity;
            this.character = character;
        }
    }

    List<EntityChar> entityList = new ArrayList<EntityChar>();

    public String entityParser(String text) {
        entityList.add(new EntityChar("&quot;", '"'));
        entityList.add(new EntityChar("&apos;", '\''));
        entityList.add(new EntityChar("&amp;", '&'));
        entityList.add(new EntityChar("&gt;", '>'));
        entityList.add(new EntityChar("&lt;", '<'));
        entityList.add(new EntityChar("&frasl;", '/'));
        StringBuffer res = new StringBuffer();
        int length = text.length();
        int pos = 0;
        while (pos < length) {
            boolean isEntity = false;
            if (text.charAt(pos) == '&') {
                for (EntityChar entityChar : entityList) {
                    String e = entityChar.entity;
                    char c = entityChar.character;
                    if (pos + e.length() <= text.length() && text.substring(pos, pos + e.length()).equals(e)) {
                        res.append(c);
                        pos += e.length();
                        isEntity = true;
                        break;
                    }
                }
            }
            if (!isEntity) {
                res.append(text.charAt(pos++));
                continue;
            }
        }
        return res.toString();
    }
}

