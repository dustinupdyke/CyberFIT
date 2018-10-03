package cyberfit.relogo;
import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.*;

public class Campaign {

	public static final String MPATH = "./docs/campaign_01_missions.xlsx";
	public static final String CPATH = "./docs/campaign_01_CPTs.xlsx";
	private int i;
	
	public boolean loadMissions() throws Exception, IOException {
		
		//id, type, forces, terrain
		
		Workbook workbook = WorkbookFactory.create(new File(MPATH));
		
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		
		sheet.forEach(row -> {
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
                
                
            });
            //System.out.println();
        });

        // Closing the workbook
        //((FileInputStream) workbook).close();
		
		return true;
	}
	
	public boolean loadCPTs() throws Exception, IOException {
		
		//id, type, forces, terrain
		
		Workbook workbook = WorkbookFactory.create(new File(CPATH));
		
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		int rowNum = 1;
		int rowPosition = -10;
		sheet.forEach(row -> {
			String[] forceAgentDetails = new String[4];		
			//rowPosition = rowPosition * rowNum;
            row.forEach(cell -> {
                String cellValue = dataFormatter.formatCellValue(cell);
                forceAgentDetails[cell.getColumnIndex()] = cellValue;
                System.out.print(cell.getColumnIndex() + "\t");
                System.out.print(cellValue + "\t");
            });
            Defender d = new Defender();
            //d.setTeam(forceAgentDetails[1]);
            //createDefenders(1){ [setxy(-100,rowPosition), setColor(green()), team = 1, rank = "O3", experienceMissions = 4, experienceTraining = 50] };
            //createDefenders(1);
            //rowNum++;
          System.out.println();
        });

        // Closing the workbook
        //((FileInputStream) workbook).close();
		
		return true;
	}
}
