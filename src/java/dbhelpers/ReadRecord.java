/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MinecraftServers;

public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private MinecraftServers server = new MinecraftServers();
    private int serverID;
    
    public ReadRecord(int serverID) {
        
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.serverID = serverID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead()
    {
        
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM minecraftservers WHERE serverID = ?";
            
            //create a preparedstatement using out query
            PreparedStatement ps = conn.prepareStatement(query);
            
            //fill in the preparedstatement
            ps.setInt(1, serverID);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            server.setServerID(this.results.getInt("serverID"));
            server.setServerName(this.results.getString("serverName"));
            server.setServerIP(this.results.getString("serverIP"));
            server.setAveragePlayers(this.results.getInt("AveragePlayers"));
            server.setServerType(this.results.getString("serverType"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }
    
    public MinecraftServers getServer()
    {
        return this.server;
    }
}
