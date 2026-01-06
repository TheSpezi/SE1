package org.hbrs.se1.ws25.exercises.uebung9;


import java.io.UnsupportedEncodingException;

public class TextDocument extends CoreDocument{

    public enum Encoding {
        UTF8("UTF-8"),
        UTF16("UTF-16"),
        UTF32("UTF-32");

        private String name;

        Encoding(String s){
            this.name = s;
        }
        public String getName(){
            return this.name;
        }
    }

    private String content;
    private Encoding encoding;

    public TextDocument(String content, Encoding encoding){
        this.content = content;
        this.encoding = encoding;
    }

    @Override
    public int getSize() {
        try {
            byte[] bytes = content.getBytes(encoding.getName());
            return bytes.length;
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
            return -1;
        }
    }
}
