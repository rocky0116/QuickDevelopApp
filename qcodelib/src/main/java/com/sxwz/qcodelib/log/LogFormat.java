package com.sxwz.qcodelib.log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.UnknownHostException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/29 10:16
 * description: log 格式化
 *****************************************************/

public class LogFormat {
    static final int JSON_INDENT = 4;
    static final int XML_INDENT = 4;

    private static final char VERTICAL_BORDER_CHAR = '║';

    // Length: 100.
    private static final String TOP_HORIZONTAL_BORDER =
            "╔═════════════════════════════════════════════════" +
                    "══════════════════════════════════════════════════";

    // Length: 99.
    private static final String DIVIDER_HORIZONTAL_BORDER =
            "╟─────────────────────────────────────────────────" +
                    "──────────────────────────────────────────────────";

    // Length: 100.
    private static final String BOTTOM_HORIZONTAL_BORDER =
            "╚═════════════════════════════════════════════════" +
                    "══════════════════════════════════════════════════";

    public static String formatJson(String json) {
        String formatted = null;
        if (json == null || json.length() == 0) {
            return formatted;
        }
        try {
            if (json.startsWith("{")) {
                JSONObject jo = new JSONObject(json);
                formatted = jo.toString(JSON_INDENT);
            } else if (json.startsWith("[")) {
                JSONArray ja = new JSONArray(json);
                formatted = ja.toString(JSON_INDENT);
            }
        } catch (Exception e) {
        }

        return formatted;
    }

    public static String formatXml(String xml) {
        String formatted = null;
        if (xml == null || xml.trim().length() == 0) {
            return formatted;
        }
        try {
            Source xmlInput = new StreamSource(new StringReader(xml));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
                    String.valueOf(XML_INDENT));
            transformer.transform(xmlInput, xmlOutput);
            formatted = xmlOutput.getWriter().toString().replaceFirst(">", ">"
                    + ZPrinter.lineSeparator);
        } catch (Exception e) {

        }
        return formatted;
    }

    public static String formatThrowable(Throwable tr) {
        if (tr == null) {
            return "";
        }
        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        tr.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }


    public static String formatArgs(String format, Object... args) {
        if (format != null) {
            return String.format(format, args);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0, N = args.length; i < N; i++) {
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(args[i]);
            }
            return sb.toString();
        }
    }

    public static String formatBorder(String[] segments) {
        if (segments == null || segments.length == 0) {
            return "";
        }
        String[] nonNullSegments = new String[segments.length];
        int nonNullCount = 0;
        for (String segment : segments) {
            if (segment != null) {
                nonNullSegments[nonNullCount++] = segment;
            }
        }
        if (nonNullCount == 0) {
            return "";
        }

        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append(TOP_HORIZONTAL_BORDER).append(ZPrinter.lineSeparator);
        for (int i = 0; i < nonNullCount; i++) {
            msgBuilder.append(appendVerticalBorder(nonNullSegments[i]));
            if (i != nonNullCount - 1) {
                msgBuilder.append(ZPrinter.lineSeparator).append(DIVIDER_HORIZONTAL_BORDER)
                        .append(ZPrinter.lineSeparator);
            } else {
                msgBuilder.append(ZPrinter.lineSeparator).append(BOTTOM_HORIZONTAL_BORDER);
            }
        }
        return msgBuilder.toString();
    }

    private static String appendVerticalBorder(String msg) {
        StringBuilder borderedMsgBuilder = new StringBuilder(msg.length() + 10);
        String[] lines = msg.split(ZPrinter.lineSeparator);
        for (int i = 0, N = lines.length; i < N; i++) {
            if (i != 0) {
                borderedMsgBuilder.append(ZPrinter.lineSeparator);
            }
            String line = lines[i];
            borderedMsgBuilder.append(VERTICAL_BORDER_CHAR).append(line);
        }
        return borderedMsgBuilder.toString();
    }
}
