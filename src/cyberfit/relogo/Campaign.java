package cyberfit.relogo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.*;

public class Campaign {

	public static final String MPATH = "./docs/campaign_01_missions.xlsx";
	public static final String CPATH = "./docs/campaign_01_CPTs.xlsx";
	public static final String FPATH = "./docs/campaign_01_friendlys.xlsx";
	public static final String TPATH = "./docs/campaign_01_terrains.xlsx";
	
	public class Mission
	{
		public String missionId;
		public String numFriendlyForces;
		public String numTerrainT1;
		public String numTerrainT2;
		public String numTerrainT3;		
	}
	
	int i = 0;
	
	public ArrayList<Mission> loadMissions() throws Exception, IOException {
		
		//id, type, forces, terrain
		
		Workbook workbook = WorkbookFactory.create(new File(MPATH));
		
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		
		ArrayList<Mission> list = new ArrayList<Mission>();

		sheet.forEach(row -> {
			
			Mission mission = new Mission();
			i = 0;
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                //System.out.print(cellValue + "\t");
                
                if(i == 0)
                		mission.missionId = cellValue;
                else if (i ==1)
                		mission.numFriendlyForces = cellValue;
                else if(i ==2) 
                		mission.numTerrainT1 = cellValue;
                else if(i==3)
                		mission.numTerrainT2 = cellValue;
                else if(i==4)
            			mission.numTerrainT3 = cellValue;
                
                i = i + 1;
            });
            
            list.add(mission);
            
            //System.out.println();
        });

        // Closing the workbook
        //((FileInputStream) workbook).close();
		
		return list;
	}
	
	public class Soldier
	{
		public String team;
		public String rank;
		public String expMissions;
		public String expTraining;
	}
	
	public ArrayList<Soldier> loadSoldiers() throws Exception, IOException {
		
		//id, type, forces, terrain
		
		Workbook workbook = WorkbookFactory.create(new File(CPATH));
		
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		int rowNum = 1;
		int rowPosition = -10;
		
		ArrayList<Soldier> list = new ArrayList<Soldier>();

		sheet.forEach(row -> {
			Soldier soldier = new Soldier();
			i = 0;
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);

                if(i == 0)
            			soldier.team = cellValue;
	            else if (i ==1)
	            		soldier.rank = cellValue;
	            else if(i ==2)
	            		soldier.expMissions = cellValue;
	            else if(i==3)
	            		soldier.expTraining = cellValue;
            
            i = i + 1;
        });
        
        list.add(soldier);
        });

		
		return list;
	}
	
	public class Friendly
	{
		public String missionID;
	}
	
	public ArrayList<Friendly> loadFriendlys() throws Exception, IOException {
		
		//id, type, forces, terrain
		
		Workbook workbook = WorkbookFactory.create(new File(FPATH));
		
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		int rowNum = 1;
		int rowPosition = -10;
		
		ArrayList<Friendly> list = new ArrayList<Friendly>();

		sheet.forEach(row -> {
			Friendly friendly = new Friendly();
			i = 0;
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);

                if(i == 0)
            			friendly.missionID = cellValue;
            
            i = i + 1;
        });
        
        list.add(friendly);
        });
		
		return list;
	}
	
	public class Terrain
	{
		public String missionID;
		public String tType;
	}
	
	public ArrayList<Terrain> loadTerrains() throws Exception, IOException {
		
		Workbook workbook = WorkbookFactory.create(new File(TPATH));
		
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		int rowNum = 1;
		int rowPosition = -10;
		
		ArrayList<Terrain> list = new ArrayList<Terrain>();

		sheet.forEach(row -> {
			Terrain terrain = new Terrain();
			i = 0;
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);

                if(i == 0)
            			terrain.missionID = cellValue;
                if(i == 1)
        			terrain.tType = cellValue;
                
            i = i + 1;
        });
        
        list.add(terrain);
        });
		
		return list;
	}
}
