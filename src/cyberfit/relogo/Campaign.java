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
	
	public class Mission
	{
		public String missionId;
		public String missionType;
		public String numFriendlyForces;
		public String numTerrain;
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
                		mission.missionType = cellValue;
                else if(i ==2)
                		mission.numFriendlyForces = cellValue;
                else if(i==3)
                		mission.numTerrain = cellValue;
                
                i = i + 1;
            });
            
            list.add(mission);
            
            //System.out.println();
        });

        // Closing the workbook
        //((FileInputStream) workbook).close();
		
		return list;
	}
	
	public class Cpt
	{
		public String team;
		public String rank;
		public String experienceMissions;
		public String experienceTraining;
	}
	
	public ArrayList<Cpt> loadCPTs() throws Exception, IOException {
		
		//id, type, forces, terrain
		
		Workbook workbook = WorkbookFactory.create(new File(CPATH));
		
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		int rowNum = 1;
		int rowPosition = -10;
		
		ArrayList<Cpt> list = new ArrayList<Cpt>();

		sheet.forEach(row -> {
			Cpt cpt = new Cpt();
			i = 0;
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);

                if(i == 0)
            			cpt.team = cellValue;
	            else if (i ==1)
	            		cpt.rank = cellValue;
	            else if(i ==2)
	            		cpt.experienceMissions = cellValue;
	            else if(i==3)
	            		cpt.experienceTraining = cellValue;
            
            i = i + 1;
        });
        
        list.add(cpt);
            //createDefenders(1){ [setxy(-100,rowPosition), setColor(green()), team = 1, rank = "O3", experienceMissions = 4, experienceTraining = 50] };
            //rowNum++;
        });

        // Closing the workbook
        //((FileInputStream) workbook).close();
		
		return list;
	}
}
