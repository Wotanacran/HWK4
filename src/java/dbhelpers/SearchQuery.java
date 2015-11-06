
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

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery() 
    {
        
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSearch(String serverName)
    {
        try {
            String query = "SELECT * FROM minecraftservers WHERE UPPER(serverName) LIKE ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + serverName.toUpperCase() + "%");
            this.results = ps.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLtable()
    {
        String table = "";
        
        table += "<table>";
        table += "<tr>";
        table += "<th>Server ID</th>";
        table += "<th>Server Name</th>";
        table += "<th>Server IP</th>";
        table += "<th>Average Players</th>";
        table += "<th>Server Type</th>";
        table += "<th></th>";
        table += "</tr>";
        
        try {
            while (this.results.next())
            {
                MinecraftServers server = new MinecraftServers();
                server.setServerID(this.results.getInt("serverID"));
                server.setServerName(this.results.getString("serverName"));
                server.setServerIP(this.results.getString("serverIP"));
                server.setServerType(this.results.getString("serverType"));
                server.setAveragePlayers(this.results.getInt("averagePlayers"));
                
                table += "<tr>";
                table += "<td>";
                table += server.getServerID();
                table += "</td>";
                
                table += "<td>";
                table += server.getServerName();
                table += "</td>";
                
                table += "<td>";
                table += server.getServerIP();
                table += "</td>";

                table += "<td>";
                table += server.getAveragePlayers();
                table += "</td>";

                table += "<td>";
                table += server.getServerType();
                table += "</td>";
                
                table += "<td id=\"delete\">";
                table += "<a class=\"update\"href=update?serverID=" + server.getServerID() + "> Update </a>" + "<a class=\"delete\"href=delete?serverID=" + server.getServerID() + "> Delete </a>";
                table += "</td>";
                table += "</tr>";
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table";
        
        return table;
    }
}
