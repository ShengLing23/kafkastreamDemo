import com.MessageEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import sun.applet.Main;

import java.io.IOException;

/**
 * @author shengling23
 * @create 2019-07-30 18:07
 */

public class Test {



    public static void main(String[] args) {
       String xmlString = "2019-07-30T08:50:18.659Z 192.168.90.217 \n" +
               "<ytmessage>\n" +
               "\t<message_id>m705KM6N_0</message_id>\n" +
               "\t<airline_no>m705KM6N</airline_no>\n" +
               "\t<airline_name>TESTm705KM6N</airline_name>\n" +
               "\t<lon>116.33112739</lon>\n" +
               "\t<lat>39.98706433</lat>\n" +
               "\t<time>2019-07-30 16:50:10</time>\n" +
               "</ytmessage>\n";

       xmlString = xmlString.replaceAll("\\n\\t","");
        System.out.println(xmlString);
    }

}
