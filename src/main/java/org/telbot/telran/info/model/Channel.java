package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "channels")
public class Channel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int channelId;
    @Column(name = "channel_name")
    private String channelName;

    public Channel() {
        //
    }

    public Channel(int channelId, String channelName) {
        this.channelId = channelId;
        this.channelName = channelName;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                '}';
    }
}
