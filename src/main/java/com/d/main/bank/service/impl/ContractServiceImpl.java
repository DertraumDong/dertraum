package com.d.main.bank.service.impl;
import com.d.main.bank.model.Contract;
import com.d.main.bank.model.ContractResultDTO;
import com.d.main.bank.model.Info;
import com.d.main.bank.service.IContractService;
import com.d.main.bank.dao.ContractDAO;
import com.d.main.bank.service.IInfoService;
import com.d.main.bank.util.RequestApiUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.d.main.bank.model.ContractDTO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
* ������合约 ����ʵ�ֲ�
* @author Administrator
* @date 2020-03-23 05:34:21
*/
@Service
public class ContractServiceImpl implements IContractService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ContractServiceImpl.class);

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private IInfoService iInfoService;
    /**
    * ����������Id��ȡDTO
    * @param id
    */
    @Override
    public ContractDTO findDTOById(String id) throws Exception {
        ContractDTO contractDTO = contractDAO.findDTOById(id);
        return contractDTO;
    }

    /**
    * ����������������ѯUser
    * @param contract
    */
    @Override
    public List<Contract> selectAll(Contract contract){
        List<Contract> contractList = contractDAO.selectAll(contract);
        return contractList;
    }

    @Override
    public int insetContractByValue(List<Contract> contracts) {
        return contractDAO.insetContractByValue(contracts);
    }

    @Override
    public int insetContractByValueB(Contract contract) {
        return contractDAO.insetContractByValueB(contract);
    }

    @Override
    public List<ContractResultDTO> selectByName(Contract contract) {
        return contractDAO.selectByName(contract);
    }

    @Override
    public List<ContractResultDTO> selectTimeByName(String type) {
        return contractDAO.selectTimeByName(type);
    }

    /**
     * 品种每日详细的信息
     */
    @Override
    public void taskFutures() throws ParseException {
        List<Info> infoList = iInfoService.selectAll( new Info());
        LOGGER.info(" 查询出来的大小:" + infoList.size());
        // System.out.println(infoList.size() + " 查询出来的大小");
        List<Contract> contractList = new ArrayList<>(infoList.size());
        for (Info info : infoList){
            String url  = "https://hq.sinajs.cn/list=nf_";
            String result = RequestApiUtil.get(url,info.getContract());
            // 处理返回字符串
            StringBuilder stringBuilder = new StringBuilder(result);
            stringBuilder.replace(0,stringBuilder.indexOf("\"")+1,"");
            stringBuilder.replace(stringBuilder.indexOf("\""),stringBuilder.length()+1,"");
            LOGGER.info("api返回结果 ： " + stringBuilder.toString());
            //System.out.println("api返回结果 ： " + stringBuilder.toString());
            // 切割处理后字符串
            result = stringBuilder.toString();
            String[] oi = result.split(",");
            Contract contract = buildFullModel(oi);
            if(contract != null){
                contractList.add(contract);
            }
            insetContractByValueB(contract);
        }
        LOGGER.info("contractList : " + contractList.size());
        // System.out.println("contractList : " + contractList.size());
        //iContractService.insetContractByValue(contractList);
        // var hq_str_nf_P2009="棕榈油2009,150000,4600.000,4650.000,4558.000,4588.000,4586.000,4588.000,4588.000,0.000,4670.000,58,5,180563.000,263822,连,棕榈油,2020-03-23,0,,,,,,,,,4606.728"

    }

    @Override
    public void taskMoreFutures() throws ParseException {
        List<Info> infoList = iInfoService.selectAll( new Info());
        LOGGER.info(infoList.size() + " 查询出来的大小");
        // System.out.println(infoList.size() + " 查询出来的大小");
        for (Info info : infoList) {
            // 发送查询api请求
            String url = "http://stock2.finance.sina.com.cn/futures/api/json.php/IndexService.getInnerFuturesDailyKLine?symbol=";
            String result = RequestApiUtil.get(url, info.getContract());
            // 处理返回结果
            result=result.replace("[","");
            result=result.replace("]","");
            result=result.replace("\"","");
            System.out.println(result);
            String[] oo = result.split(",");
            LOGGER.info("oo size :" + oo.length);
            //System.out.println("oo size :" + oo.length);
            // 创建Contract对象
            List<Contract> contractList = new ArrayList<>();
            for(int i = 0 ; i < oo.length ; ){
                Contract contract = new Contract();
                // name
                contract.setName(info.getName());
                // date
                String datatime = oo[i];
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                contract.setDate(sdf.parse(datatime));
                // open
                contract.setOpen(new BigDecimal(oo[i+1]));
                // top
                contract.setTop(new BigDecimal(oo[i+2]));
                // down
                contract.setDown(new BigDecimal(oo[i+3]));
                // now
                contract.setNow(new BigDecimal(oo[i+4]));
                // volume
                contract.setVolume(new BigDecimal(oo[i+5]));
                // flag
                contract.setFlag(contract.getName().toString() + contract.getDate().toString());
                contractList.add(contract);
                i = i + 6;
            }
            LOGGER.info("contractList : " + contractList.size());
            // System.out.println("contractList : " + contractList.size());
            insetContractByValue(contractList);
        }
    }

    private Contract buildFullModel(String[] array) throws ParseException {
        if(array.length < 2){
            return null;
        }
        Contract contract = new Contract();
        contract.setName(array[0]);
        contract.setCode(array[1]);
        BigDecimal bigDecimal = new BigDecimal(array[2]);
        contract.setOpen(bigDecimal);
        contract.setTop(new BigDecimal(array[3]));
        contract.setDown(new BigDecimal(array[4]));
        contract.setClosing(new BigDecimal(array[5]));
        contract.setNow(new BigDecimal(array[6]));
        contract.setOnesell(new BigDecimal(array[7]));
        contract.setOnebuy(new BigDecimal(array[8]));
        contract.setSettlement(new BigDecimal(array[9]));
        contract.setYessettlement(new BigDecimal(array[10]));
        contract.setOnebuynum(new BigDecimal(array[11]));
        contract.setOnesellnum(new BigDecimal(array[12]));
        contract.setHoldings(new BigDecimal(array[13]));
        contract.setVolume(new BigDecimal(array[14]));
        contract.setExchange(array[15]);
        contract.setVarieties(array[16]);
        String datatime = array[17];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        contract.setDate(sdf.parse(datatime));
        contract.setUnknownparameters1(array[18]);
        contract.setUnknownparameters2(array[19]);
        contract.setUnknownparameters3(array[20]);
        contract.setUnknownparameters4(array[21]);
        contract.setUnknownparameters5(array[22]);
        contract.setUnknownparameters6(array[23]);
        contract.setUnknownparameters7(array[24]);
        contract.setHistorytop(array[25]);
        contract.setHistorydown(array[26]);
        contract.setAvg(new BigDecimal(array[27]));
        contract.setFlag(contract.getName().toString() + contract.getDate().toString());
        return contract;
    }


}

