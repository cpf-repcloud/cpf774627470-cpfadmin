package cn.rep.cloud.custom.coreutils.common;

import cn.rep.cloud.custom.coreutils.annotation.ExcelCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * excel转实体bean 
 */
public class ExcelConveter {
    public static Workbook readFile(File file) throws Exception {
        try {
            //xls和xlsx必须不同的处理类，POI就这么规定的
            if (file.getName().toLowerCase().endsWith(".xls")) {
                return readFileHSSF(new FileInputStream(file));
            } else {
                return readFileXSSF(new FileInputStream(file));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    //HSSF*是处理xls格式的，XSSF是处理xlsx格式文件
    private static Workbook readFileHSSF(InputStream stream) throws Exception, IOException {
        try {
            return new HSSFWorkbook(stream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            stream.close();
        }
    }

    private static Workbook readFileXSSF(InputStream stream) throws Exception, IOException {
        try {
            return new XSSFWorkbook(stream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            stream.close();
        }
    }

    public static Workbook readFile(String path) throws Exception {
        File file = new File(path);
        if (!file.exists())
            throw new Exception("文件不存在");
        if (!file.isFile())
            throw new Exception("不是合法的文件");
        return readFile(file);
    }

    public static Sheet readSheet(HSSFWorkbook workbook, Integer index) {
        return workbook.getSheetAt(index);
    }

    public static Object[] convertArrayByRow(Row row) {
        int cols = row.getLastCellNum();
        Object[] arr = new Object[cols];
        for (int i = 0; i < cols; i++) {
            Cell cell = row.getCell(i);
            if (cell == null)
                continue;
            if (cell.getCellTypeEnum() == CellType.STRING) {
                arr[i] = cell.getStringCellValue();
            } else if(HSSFDateUtil.isCellDateFormatted(cell)) {
                arr[i] = DateUtil.getJavaDate(cell.getNumericCellValue());
            }else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                Object inputValue = null;// 单元格值
                Long longVal = Math.round(cell.getNumericCellValue());
                Double doubleVal = cell.getNumericCellValue();
                if(Double.parseDouble(longVal + ".0") == doubleVal){   //判断是否含有小数位.0
                    inputValue = longVal;
                }
                else{
                    inputValue = doubleVal;
                }
                DecimalFormat df = new DecimalFormat("#.####");    //格式化为四位小数，按自己需求选择；
                arr[i] = df.format(inputValue);
            }
        }
        return arr;
    }

    public static <T extends Object> T convertBeanFromArray(Object[] arr, Class<T> clazz) throws Exception {
        T entity;
        try {
            entity = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(ExcelCell.class))
                    continue;

                field.setAccessible(true);
                ExcelCell anno = field.getAnnotation(ExcelCell.class);
                Integer col = anno.col();

                if (col >= arr.length)
                    continue;
                if (arr[col] == null)
                    continue;
                field.set(entity, numericByStr(field.getType(), arr[col]));
            }
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 数据类型转换
     *
     * @param clazz
     * @param param
     * @param <T>
     * @return
     */
    public static <T extends Object> Object numericByStr(Class<T> clazz, Object param) {
        if (param == null)
            return null;
        if (clazz.isAssignableFrom(Double.class)) {
            return Double.valueOf(String.valueOf(param));
        } else if (clazz.isAssignableFrom(Long.class)) {
            Double d = Double.valueOf(String.valueOf(param));
            return d.longValue();
        } else if (clazz.isAssignableFrom(Integer.class)) {
            return Integer.valueOf(String.valueOf(param));
        } else if(clazz.isAssignableFrom(Date.class)){
            return param;
        }else{
            return String.valueOf(param);
        }
    }

    /**
     * 通过地址来解析文件
     *
     * @param path 路径
     * @param startRow 开始行
     * @param clazz 需要接收数据的实体
     * @param <T> 返回的实体
     * @return 返回解析后数据集合
     * @throws Exception
     */
    public static <T> List<T> getBean(String path,Integer startRow, Class<T> clazz) throws Exception {
        if (null == startRow || startRow <= 0){
            throw new Exception("开始行数不能为空或小于等于0!");
        }
        List<T> list = new ArrayList<T>();
        Workbook book = readFile(path);
        for (int i = startRow; i <= book.getSheetAt(0).getLastRowNum(); i++) {
            Object[] arr = convertArrayByRow(book.getSheetAt(0).getRow(i));
            T t = convertBeanFromArray(arr, clazz);
            list.add(t);
        }
        return list;
    }

    /**
     * 通过文件来解析文件
     *
     * @param file 文件
     * @param startRow 开始行
     * @param clazz 需要接收数据的实体
     * @param <T> 返回的实体
     * @return 返回解析后数据集合
     * @throws Exception
     */
    public static <T> List<T> getBean(File file,Integer startRow, Class<T> clazz) throws Exception {
        List<T> list = new ArrayList<T>();
        Workbook book = readFile(file);
        if (null == startRow || startRow <= 0){
            throw new Exception("开始行数不能为空或小于等于0!");
        }
        for (int i = startRow; i <= book.getSheetAt(0).getLastRowNum(); i++) {
            Object[] arr = convertArrayByRow(book.getSheetAt(0).getRow(i));
            T t = convertBeanFromArray(arr, clazz);
            list.add(t);
        }
        return list;
    }

    /**
     * 通过输入流来解析文件
     *
     * @param stream 输入流
     * @param startRow 开始行
     * @param excelType 文件后缀名
     * @param clazz 需要接收数据的实体
     * @param <T> 返回的实体
     * @return 返回解析后数据集合
     * @throws Exception
     */
    public static <T> List<T> getBean(InputStream stream,Integer startRow, String excelType, Class<T> clazz)
            throws Exception, IOException {
        Workbook book;
        if (null == startRow || startRow <= 0){
            throw new Exception("开始行数不能为空或小于等于0!");
        }
        if (excelType.equals("xls")) {
            book = readFileHSSF(stream);
        } else {
            book = readFileXSSF(stream);
        }
        List<T> list = new ArrayList<T>();
        for (int i = startRow; i <= book.getSheetAt(0).getLastRowNum(); i++) {
            Object[] arr = convertArrayByRow(book.getSheetAt(0).getRow(i));
            if (null == arr[0] || arr[0] == "") continue;
            T t = convertBeanFromArray(arr, clazz);
            list.add(t);
        }
        return list;
    }
}
