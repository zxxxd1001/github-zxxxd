package com.company.client.plugin;

import com.company.GetEnvironmentVariable;
import com.heren.his.commons.plugin.client.PluginEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by zhangxuedong on 2017/2/21.
 */
public class ReaderJar {
    //本例子是读取的heren目录下的jar文件 继承实现抽象方法的类 包必须一直 否则 无法读到jar包

    //如果不用继承抽象类  直接调用jar中的指定文件 也行 建议使用继承
    public static void main(String[] args) {
//       PluginManager.sendTransToPlugin("Apportion","0","{'operationType':" +
//               "'Apportion','sender':'2327','patientId':'P101613','clinicCate':3,'visitType':'体检','settleStatus':1,'chargeType':'北京医保'," +
//               "'factRcptNo':'ddd226','tradeNo':'','recipeVoList':[" +
//               "{'recipeNo':null,'recipeDate':1487668006783,'insuranceSign':null,'diagNo':null,'diagCode':null,'diagName':null," +
//               "'diagDoctorId':null,'diagDoctor':null,'diagDoctorTitle':null,'visitDeptCode':'5108','mrInfo':null,'orderClass':null," +
//               "'helpMedicineFlag':null,'traceNo':null,'memo':null}]," +
//               "'feeItemList':[" +
//               "{'orderDetailVo':null," +
//               "'billDetailVoList':[" +
//               "{'detailNo':null,'costsNo':null,'visitNo':null,'patientId':'P101613','recipeNo':'10001','orderId':null," +
//               "'applyItemNo':null,'groupNo':null,'groupSubNo':null,'itemClass':'E'," +
//               "'itemId':'3485','itemCode':'101020001','itemName':'门诊诊疗费','itemSpec':'(住院)','firmId':null,'price':8," +
//               "'chargePrice':8,'repetition':null,'amount':1,'units':'每天','orderedDate':null,'costs':8,'charges':8," +
//               "'orderedByDept':null,'orderedEmpId':'2327','performedBy':'5108','classOnOutpRcpt':'H','classOnInpRcpt':'D'}," +
//               "{'detailNo':null,'costsNo':null,'visitNo':null,'patientId':'P101613','recipeNo':'10001','orderId':null," +
//               "'applyItemNo':null,'groupNo':null,'groupSubNo':null,'itemClass':'Z','itemId':'11928','itemCode':'GH0005'," +
//               "'itemName':'专家号（主任医师）','itemSpec':'/','firmId':null,'price':5,'chargePrice':5,'repetition':null," +
//               "'amount':1,'units':'人次','orderedDate':null,'costs':5,'charges':5,'orderedByDept':null,'orderedEmpId':'2327'," +
//               "'performedBy':'5108','classOnOutpRcpt':'H','classOnInpRcpt':'H'}]}],'visitNo':null}");
        PluginEvent pluginEvent=PluginManager.sendTransToPlugin("TestPluginClient","0","123");
        System.out.println(pluginEvent.getAppendDescription());

    }
}
