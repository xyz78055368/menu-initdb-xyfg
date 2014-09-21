package com.groupshop.text;
       import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.groupshop.dao.DataBase;
public class FileSystem1 extends DataBase {
    private static ArrayList filelist = new ArrayList(); 
    
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        
        String path = "E:\\Work\\JavaProject\\Project\\µº∫Ω±Í«©";
        refreshFileList(path);
        new FileSystem1().UpdateDpic(filelist);
        System.out.println(System.currentTimeMillis() - a);
    }
    public static void refreshFileList(String strPath) { 
        File dir = new File(strPath); 
        File[] files = dir.listFiles(); 
        
        if (files == null) 
            return; 
        for (int i = 0; i < files.length; i++) { 
            if (files[i].isDirectory()) { 
                refreshFileList(files[i].getAbsolutePath()); 
            } else { 
                String strFileName = files[i].getAbsolutePath();
                int k = strPath.length();
                strFileName = strFileName.substring(k+1);
                
//                strFileName = strFileName.lastIndexOf("/")+"";
                System.out.println(strFileName);
                filelist.add(strFileName);                    
            } 
        } 
    }
    
    public  void UpdateDpic (ArrayList  list){
    	
    	try {
			Connection conn = this.getConn();
			String sql = "insert into dpic (picname) values (?)";
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i<list.size();i++){
				pstmt.setString(1, list.get(i).toString());
				pstmt.execute();
				pstmt.clearParameters();
			}
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
