package org.telbot.telran.info.model;

import javax.persistence.*;

@Entity
@Table(name = "channel")
public class Channel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "group_id")
    private long groupId;

    public Channel() {
        //
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }


    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
