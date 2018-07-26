package wellcao.com.myresume.utils;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @author wellcao
 * @date 2018/7/26
 * class introduction:
 */
public class XmlUtils {

    public static List<Object> getClassList(Context context){
        List<Object> classList =new ArrayList<>();
        try {
            InputStream inputStream = context.getAssets().open("config.xml");
            List<String> classNameList = getClassNameList(inputStream);
            if (classNameList!=null){
                for (int i =0;i<classNameList.size();i++){
                    Class c=Class.forName(classNameList.get(i));
                    Object obj=c.newInstance();
                    classList.add(obj);
                }

                return classList;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classList;
    }

    private static List<String> getClassNameList(InputStream inputStream) throws Exception {

        List<String> classList = new ArrayList<>();
        //获取DOM解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //获DOM解析器
        DocumentBuilder builder = factory.newDocumentBuilder();
        //将解析树放入内存，通过返回值Document来描述结果
        Document document = builder.parse(inputStream);
        //取得根元素<personos>
        Element root = document.getDocumentElement();
        //取得所有person节点集合
        NodeList personNodes = root.getElementsByTagName("className");
        for (int i = 0; i < personNodes.getLength(); i++) {
            if (personNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                classList.add( personNodes.item(i).getFirstChild().getNodeValue());
            }

        }
        return classList;
    }
}
