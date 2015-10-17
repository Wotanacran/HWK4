/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tyler
 */
public class MinecraftServers 
{
    private int serverID;
    private String serverName;
    private int averagePlayers;
    private String serverIP;
    private String serverType;

    public MinecraftServers() 
    {
        this.serverID = 0;
        this.serverName = "";
        this.averagePlayers = 0;
        this.serverIP = "";
        this.serverType = "";
    }
    
    public MinecraftServers(int serverID, String serverName, int averagePlayers, String serverIP, String serverType) 
    {
        this.serverID = serverID;
        this.serverName = serverName;
        this.averagePlayers = averagePlayers;
        this.serverIP = serverIP;
        this.serverType = serverType;
    }

    public int getServerID() {
        return serverID;
    }

    public void setServerID(int serverID) {
        this.serverID = serverID;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getAveragePlayers() {
        return averagePlayers;
    }

    public void setAveragePlayers(int averagePlayers) {
        this.averagePlayers = averagePlayers;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    @Override
    public String toString() {
        return "MinecraftServers{" + "serverID=" + serverID + ", serverName=" + serverName + ", averagePlayers=" + averagePlayers + ", serverIP=" + serverIP + ", serverType=" + serverType + '}';
    }
    
    
    
}
