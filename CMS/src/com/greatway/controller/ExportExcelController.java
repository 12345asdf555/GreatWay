package com.greatway.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greatway.enums.WeldEnum;
import com.greatway.manager.MaintainManager;
import com.greatway.manager.WeldingMachineManager;
import com.greatway.model.Gather;
import com.greatway.model.WeldingMachine;
import com.greatway.model.WeldingMaintenance;
import com.greatway.util.CommonExcelUtil;
import com.greatway.util.IsnullUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/export", produces = { "text/json;charset=UTF-8" })
public class ExportExcelController {
	
	private static final long serialVersionUID = -4171187629012625142L;
	
	@Autowired
	private WeldingMachineManager wmm;
	@Autowired
	private MaintainManager mm;
	private String filename;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
	IsnullUtil iutil = new IsnullUtil();
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	@RequestMapping("/exporWeldingMachine")
	@ResponseBody
	public ResponseEntity<byte[]> exporWeldingMachine(HttpServletRequest request){
		JSONObject obj = new JSONObject();
		File file = null;
		try {
			String str=(String) request.getSession().getAttribute("searchStr");
			List<WeldingMachine> list = wmm.getWeldingMachine(str);
			
			String[] titles = new String[]{"序号","设备编码","设备类型","入厂时间","所属项目","状态","厂家","是否在网","采集序号","位置"};
			Object[][] data = new Object[list.size()][10];
			for(int i =0; i<list.size();i++){
				data[i][0] = list.get(i).getId();
				data[i][1] = list.get(i).getEquipmentNo();
				data[i][2] = WeldEnum.getValue(list.get(i).getTypeId());
				data[i][3] = list.get(i).getJoinTime();
				data[i][4] = list.get(i).getInsframeworkId().getName();
				data[i][5] = WeldEnum.getValue(list.get(i).getStatusId());
				data[i][6] = list.get(i).getManufacturerId().getName();
				data[i][7] = WeldEnum.getValue(list.get(i).getIsnetworking());
				Gather gather = list.get(i).getGatherId();
				if(gather!=null){
					data[i][8] = gather.getGatherNo();
				}else{
					data[i][8] = null;
				}
				data[i][9] = list.get(i).getPosition();
			}
			filename = "焊机设备" + sdf.format(new Date()) + ".xls";
			String path = "/tmp/excelfiles//" + filename;
			File f = new File("/tmp/excelfiles");
			if (!f.exists()) {
				f.mkdirs();
			}
			new CommonExcelUtil(titles, data, path, "焊机设备数据");

			file = new File(path);
			HttpHeaders headers = new HttpHeaders();
			String fileName = "";
			
			fileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
			
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			
			
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		}catch (Exception e) {
	    	return null;
		}  finally {
			file.delete();
		}
	}
	
	
	@RequestMapping("/exporMaintain")
	@ResponseBody
	public ResponseEntity<byte[]> exporMaintain(HttpServletRequest request){
		JSONObject obj = new JSONObject();
		File file = null;
		try{
			String str=(String) request.getSession().getAttribute("searchStr");
			List<WeldingMaintenance> list = mm.getWeldingMaintenanceAll(str);
			
			String[] titles = new String[]{"序号","设备编码","维修人员","维修起始时间","维修结束时间","维修类型","维修说明"};
			Object[][] data = new Object[list.size()][7];
			for(int i =0; i<list.size();i++){
				data[i][0] = list.get(i).getId();
				data[i][1] = list.get(i).getWelding().getEquipmentNo();
				data[i][2] = list.get(i).getMaintenance().getViceman();
				data[i][3] = list.get(i).getMaintenance().getStartTime();
				data[i][4] = list.get(i).getMaintenance().getEndTime();
				data[i][5] = WeldEnum.getValue(list.get(i).getMaintenance().getTypeId());
				data[i][6] = list.get(i).getMaintenance().getDesc();
			}
			filename = "焊机维修" + sdf.format(new Date())+".xls";
			String path = "/tmp/excelfiles//" + filename;
			File f = new File("/tmp/excelfiles");
			if (!f.exists()) {
				f.mkdirs();
			}
			new CommonExcelUtil(titles, data, path, "焊机维修数据");
			file = new File(path);
			HttpHeaders headers = new HttpHeaders();
			String fileName = "";
			fileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
		
			headers.setContentDispositionFormData("attachment", fileName);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			return null;
		} finally {
			file.delete();
		}
	}
	
}
