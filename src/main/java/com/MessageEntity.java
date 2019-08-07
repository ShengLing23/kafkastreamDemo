package com;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shengling23
 * @create 2019-07-30 17:56
 */
@JacksonXmlRootElement(localName = "ytmessage")
public class MessageEntity {

    @JacksonXmlProperty(localName = "message_id")
    private String messageId;

    @JacksonXmlProperty(localName = "airline_no")
    private String airlineNo;

    @JacksonXmlProperty(localName = "airline_name")
    private String airlineName;

    @JacksonXmlProperty(localName = "lon")
    private String lon;

    @JacksonXmlProperty(localName = "lat")
    private String lat;
    @JacksonXmlProperty(localName = "time")
    private String time;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getAirlineNo() {
        return airlineNo;
    }

    public void setAirlineNo(String airlineNo) {
        this.airlineNo = airlineNo;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "MessageEntity{" +
                "messageId='" + messageId + '\'' +
                ", airlineNo='" + airlineNo + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
