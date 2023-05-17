package com.rodrigo.GeekDev.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Url {


    public static String decoderUri(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
