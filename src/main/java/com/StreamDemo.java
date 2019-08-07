package com;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;


import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

/**
 * @author shengling23
 * @create 2019-07-30 17:14
 */
public class StreamDemo {

    private static XmlMapper xmlMapper = new XmlMapper();
    private static ObjectWriter objectWriter = new ObjectMapper().writerWithView(MessageEntity.class);


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-pipe");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.90.70:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG,Serdes.String().getClass().getName());

        final StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> source = builder.stream("udp_topic");
        source.flatMapValues(value-> Arrays.asList(xml2jSON(value)))
                .to("udp_stream_topic");


        Topology build = builder.build();

        KafkaStreams streams = new KafkaStreams(build,props);

        streams.start();

    }

    public static String xml2jSON(String xmlString){
        xmlString = xmlString.replaceAll("\\n\\t","").replaceAll("\\n","");
        int index = xmlString.indexOf("<ytmessage>");
        xmlString = xmlString.substring(index,xmlString.length());
        String result = "";
        try {
            MessageEntity messageEntity = xmlMapper.readValue(xmlString, MessageEntity.class);
            result = objectWriter.writeValueAsString(messageEntity);
        } catch (IOException e) {
            System.out.println(e);
        }
        return result;
    }
}
